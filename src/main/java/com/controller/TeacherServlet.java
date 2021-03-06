package com.controller;

import com.entity.User;
import com.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = 0;
        for (int i = 0; i < ServiceFactory.getStudentService().getAllRequests().size(); i++) {
            if (ServiceFactory.getStudentService().getAllRequests().get(i).getConfirm() == 0) count += 1;
        }
        req.getSession().setAttribute("teacher", ServiceFactory.getTeacherService().getTeacher(((User) req.getSession().getAttribute("user")).getId()));
        req.getSession().setAttribute("requestCount", count);
        req.getSession().setAttribute("requests", ServiceFactory.getStudentService().getAllRequests());
        req.getRequestDispatcher("/WEB-INF/jsp/teacher.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = new String(req.getParameter("userName").getBytes("iso-8859-1"), "utf-8");
        String academy = new String(req.getParameter("academy").getBytes("iso-8859-1"), "utf-8");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String url = "/teacher";
        if (ServiceFactory.getTeacherService().updateProfile(Integer.parseInt(req.getParameter("tid")), userName, academy, phone, email, password)) {
            req.getSession().setAttribute("teacher", ServiceFactory.getTeacherService().getTeacher(Integer.parseInt(req.getParameter("tid"))));
            req.getSession().setAttribute("user", ServiceFactory.getUserService().login(Integer.parseInt(req.getParameter("tid")), password));
        } else {
            url = "/error";
        }
        resp.sendRedirect(url);
    }
}
