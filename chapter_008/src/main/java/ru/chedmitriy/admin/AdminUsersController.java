package ru.chedmitriy.admin;

import ru.chedmitriy.logic.ValidateService;
import ru.chedmitriy.models.User;
import ru.chedmitriy.service.Settings;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Класс взаимодействия объектов User
 * с хранилищем данных,а также -
 * с Web сервисом
 * @see ru.chedmitriy.models.User - класс свойств пользователей
 * @see ru.chedmitriy.logic.ValidateService - синглтон взаимодействия пользователей с базой данных-
 * хранилищем
 */
@WebServlet("/admin/users")
public class AdminUsersController extends HttpServlet {


    /**
     * вызов синглтона
     */
    private final ValidateService valServ = ValidateService.getInstance();



    /**
     * работа с аттрибутами,отображение страниц и т.д
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /** выполняем действия: добавление,удаление,редактирование
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        switch (action) {
            case "/new":
                showAddUserWindow(req, resp);
                break;
            case "/edit":

                showEditUserWindow(req, resp);
                break;
            case "/delete":
                deleteUser(req, resp);
                break;
            case "/insert":
                addUser(req, resp);
                break;
            case "/update":
                editUser(req, resp);
                break;
            default:
                userList(req, resp);
                break;

        }

    }
    /**
     * Добавляем нового пользователя
     * Параметры запроса соответствуют
     * параметрам класса User
     * @see ru.chedmitriy.models.User
     * Создадем экземпляяр объекта User,
     * затем, используя экземпляр Синглтона valServ
     * @see ru.chedmitriy.logic.ValidateService
     * добавляем пользователя в коллекцию
     * @param request - запрос
     * @param response - ответ
     * @throws IOException
     */
    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // делаем привязку id к размеру хранилища
        int id = valServ.getAllValues().size();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String create = request.getParameter("create");
        User newUser = new User(++id, name, email, create);
        valServ.add(newUser);
        userList(request, response);

    }

    /**
     * Редактируем пользователя,
     * вызываем метод синглтона edit(User user)
     * @param request
     * @param response
     * @throws IOException
     */
    private void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String create = request.getParameter("create");

        User editUser = new User(id, name, email, create);
        System.out.println(editUser);
        valServ.edit(editUser);
        response.sendRedirect("list");

    }

    /**
     * Удаляем пользователя,
     * вызываем метод синглтона
     * @param request
     * @param response
     * @throws IOException
     */
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        valServ.delete(id);
        response.sendRedirect("list");
    }

    /**
     * получаем список всех
     * пользователей
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void userList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("userList", valServ.getAllValues());
        RequestDispatcher dis = request.getRequestDispatcher(getProperty("servlet.adminPage"));
        dis.forward(request, response);
    }

    /**
     * Отображение окна для
     * добавления
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void showAddUserWindow(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher(getProperty("servlet.addUserForm"));
        dispatcher.forward(request, response);


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

        System.out.println(request.getParameter("id"));
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = valServ.getById(id);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(getProperty("servlet.addUserForm"));

        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

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
