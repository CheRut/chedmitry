package ru.chedmitriy.servlets;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.chedmitriy.logic.ValidateService;
import ru.chedmitriy.models.User;
import ru.chedmitriy.service.Settings;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {


    private final ValidateService valServ = ValidateService.getInstance();



    @Override
    public void init() throws ServletException {
        valServ.add(new User(1,"Ivan","ivan@Mail.ru","1.02.2008"));
        valServ.add(new User(2,"Dmitry","dmitry@Mail.ru","1.05.2009"));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch (action) {
            case "/new":
                showAddUserWindow(req,resp);
                break;
            case "/insert":
                addUser(req,resp);
                break;
            case "/edit":
               showEditUserWindow(req,resp);
                break;
            case "/update":
                editUser(req,resp);
                break;
            case "/delete":
                deleteUser(req,resp);
            default:
               userList(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
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
    private void addUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id = valServ.values().size();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String create = request.getParameter("create");
        User newUser = new User(++id,name,email,create);
        valServ.add(newUser);
        response.sendRedirect("list");

    }

    /**
     * @param request
     * @param response
     * @throws IOException
     */
    private void editUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String create = request.getParameter("create");

        User editUser = new User(id,name,email,create);
        valServ.edit(editUser);

        response.sendRedirect("list");
    }

    /**
     * @param request
     * @param response
     * @throws IOException
     */
    private void deleteUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        valServ.delete(id);
    }

    /**
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void userList(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("userList",valServ.values());
        RequestDispatcher dis = request.getRequestDispatcher(getProperty("servlet.mainPage"));
        dis.forward(request,response);
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void showAddUserWindow(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/addUser.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher(getProperty("servlet.addUserForm"));
        dispatcher.forward(request, response);
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void showEditUserWindow(HttpServletRequest request, HttpServletResponse response)
            throws  ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = valServ.getById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher(getProperty("servlet.addUserForm"));
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
