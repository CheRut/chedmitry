package ru.chedmitriy.presentation.admin;

import ru.chedmitriy.logic.ValidateService;
import ru.chedmitriy.models.User;
import ru.chedmitriy.service.Settings;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin/account")
public class AccountController extends HttpServlet {

    /**
     * вызов синглтона
     */
    private final ValidateService valServ = ValidateService.getInstance();

    /**
     * Определяем роль
     * по введенным параметрам
     * логин и пароль
     *
     * @see ru.chedmitriy.logic.ValidateService#registeredRole(String, String)
     *
     * далее, на основании введенных данных
     * загружаем нужную страницу
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = null;
        for(User u:valServ.getAllValues()) {
            if (login.isEmpty() || valServ.registeredRole(login, password).equals(User.Role.GUEST)){
                request.setAttribute("error", "Account's Invalid");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

                if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                    if (valServ.registeredRole(login, password).equals(User.Role.ADMINISTRATOR)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("login", login);
                        request.setAttribute("userList", valServ.getAllValues());
                        request.getRequestDispatcher(getProperty("servlet.adminPage")).forward(request, response);
                        break;
                    }  else if (valServ.registeredRole(login, password).equals(User.Role.USER)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("login", login);
                        for (User us : valServ.getAllValues()) {
                            if (us.getLogin().equals(login)) {
                                user = new User(us.getId(), us.getName(),
                                        us.getEmail(), us.getCreate(),
                                        us.getLogin(), us.getPassword(),
                                        us.getRole());
                            }
                        }
                        request.setAttribute("user", user);
                        request.getRequestDispatcher(getProperty("servlet.selfEditUserForm")).forward(request,
                                response);
                        break;
                    }
                }
        }
    }

    /**
     * определяем действие action:
     * если действие - logout
     * удаляем ранее инициализированные
     * login И password,
     * и при обработке фильтром
     *
     * @see ru.chedmitriy.filter.AdminFilter#doFilter(ServletRequest,
     * ServletResponse, FilterChain)
     *
     * мы не должны больше попасть на страницу
     * зарегистрированного пользователя
     * пока вновь не авторизируемся
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("logout")){
            HttpSession session = request.getSession();
            session.removeAttribute("login");
            session.removeAttribute("password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    /**
     * обращаемся к файлу
     * конфигурации,
     *
     * @see ru.chedmitriy.service.Settings#getValue(String)
     *
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
