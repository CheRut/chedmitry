package ru.chedmitriy.filter;


import ru.chedmitriy.logic.ValidateService;
import ru.chedmitriy.models.User;
import ru.chedmitriy.service.Settings;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/adminFilter")
public class AdminFilter implements Filter {

    public void destroy() {
    }

    /**
     * метод направляет на страниуц логирования
     * либо если login равен null,
     * либо если UrI оканчивается  строкой admin/account
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        if (session.getAttribute("login") == null && !request.getRequestURI().endsWith("admin/account")) {
            request.getRequestDispatcher("login.jsp").forward(req, resp);

        } else {
            chain.doFilter(req, resp);
        }
    }
}
