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

@WebServlet("/users")
public class GuestsUsersViews extends HttpServlet {
    /**
     * вызов синглтона
     */
    private final ValidateService valServ = ValidateService.getInstance();


    /**
     * Заполним хранилише дефолтными
     * значениями
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        valServ.add(new User(1, "Ivan", "ivan@Mail.ru",
                "1.02.2008","user","111", User.Role.USER));
        valServ.add(new User(2, "Dmitry", "dmitry@Mail.ru",
                "1.05.2009","admin","123", User.Role.ADMINISTRATOR));
        valServ.add(new User(3, "Gleb", "gleb@Mail.ru", "22.08.2009","gleb","222", User.Role.USER));

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userList", valServ.getAllValues());
        RequestDispatcher dis = request.getRequestDispatcher(getProperty("servlet.mainPage"));
        dis.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

doPost(request, response);
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
