package org.example.hospitalmanagementsystem.controller.department;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;

import java.io.IOException;

@WebServlet("/deletedept")
public class DeleteDept extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int d_id = Integer.parseInt((request.getParameter("d_id")));

        if(ServiceHelper.deptService.deleteDept(d_id)) {
            request.setAttribute("delmsg", "success");
        }else{
            request.setAttribute("delmsg", "fail");
        }
        request.getRequestDispatcher("/viewdept").forward(request, response);
    }
}