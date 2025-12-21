package org.example.hospitalmanagementsystem.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;

import java.io.IOException;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("adminName");
        String password = request.getParameter("password");

        boolean b = ServiceHelper.adminLoginService.isLogin(username, password);
        System.out.println(b);
        if(b){
            request.setAttribute("isLogin","success");
            response.sendRedirect("index.jsp");
        }
        else{
            request.setAttribute("isLogin","Invalid Credentials..!");
            RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
            rd.forward(request,response);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
