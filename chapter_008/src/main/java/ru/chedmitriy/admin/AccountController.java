package ru.chedmitriy.admin;

import ru.chedmitriy.logic.ValidateService;
import ru.chedmitriy.models.User;
import ru.chedmitriy.service.Settings;

import javax.servlet.ServletException;
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            System.out.println(request.getContextPath());
            request.setAttribute("userList", valServ.getAllValues());
            request.getRequestDispatcher(getProperty("servlet.adminPage")).forward(request, response);
        } else {
            request.setAttribute("error","Account's Invalid");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("logout")){
            HttpSession session = request.getSession();
            session.removeAttribute("username");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
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
