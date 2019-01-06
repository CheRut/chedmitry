package ru.chedmitriy.presentation.user;

import ru.chedmitriy.logic.ValidateService;
import ru.chedmitriy.models.User;
import ru.chedmitriy.service.Settings;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/selfpage")
public class SelfUserPage extends HttpServlet {

    /**
     * вызов синглтона
     */
    private final ValidateService valServ = ValidateService.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        System.out.println(action);
        switch (action) {
            case "/edit":
                showEditUserWindow(request, response);
                break;
            case "/update":
                editUser(request, response);
                break;
            default:
                showUser(request, response);
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    /**
     * получаем список всех
     * пользователей
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void showUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = null;
        for (User u : valServ.getAllValues()) {
            if (u.getId() == id) {
                user = u;
            }
            break;
        }
        request.setAttribute("user", user);
        request.setAttribute("userlist",valServ.getAllValues());
        RequestDispatcher dis = request.getRequestDispatcher(getProperty("servlet.selfEditUserForm"));
        dis.forward(request, response);
    }

    /**
     * Редактируем пользователя,
     * вызываем метод синглтона edit(User user)
     * @param request
     * @param response
     * @throws IOException
     */
    private void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String create = request.getParameter("create");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User.Role role = valServ.registeredRole(login, password);

        User editUser = new User(id, name, email, create, login, password,role);
        valServ.edit(editUser);
        showUser(request, response);


    }

    /**
     * Отображение окна для
     * редактирования
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void showEditUserWindow(HttpServletRequest request, HttpServletResponse response)
            throws  ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = valServ.getById(id);
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(getProperty("servlet.selfEditUser"));
        dispatcher.forward(request, response);

//        showUser(request, response);


    }
    /**
     * обращаемся к файлу
     * конфигурации,
     * вводим нужный адрес,
     * получаем строку результат
     *
     * @param propertyLine - исполняемая строка в конфигураторе
     * @return - полученный результат после конфигурации
     */
    private String getProperty(final String propertyLine) {
        Settings s = new Settings();
        s.load();
        return s.getValue(propertyLine);
    }
}
