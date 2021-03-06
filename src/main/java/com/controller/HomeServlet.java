package com.controller;

import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.service.ServiceFactory;
import com.service.impl.UserServiceImpl;

@WebServlet("/home")
public class HomeServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("requests", ServiceFactory.getStudentService().getRequests(((User) req.getSession().getAttribute("user")).getId()));
        req.getSession().setAttribute("scores", ServiceFactory.getStudentService().getScoreBySid(((User) req.getSession().getAttribute("user")).getId()));
        req.getSession().setAttribute("student", ServiceFactory.getStudentService().getStudent(((User) req.getSession().getAttribute("user")).getId()));
        req.getSession().setAttribute("pplist", ServiceFactory.getStudentService().getP_PBySid(((User) req.getSession().getAttribute("user")).getId()));
        req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
    }
}
