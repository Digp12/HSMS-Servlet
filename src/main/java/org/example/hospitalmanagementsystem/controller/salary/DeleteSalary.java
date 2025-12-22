package org.example.hospitalmanagementsystem.controller.salary;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;

import java.io.IOException;
import java.security.Provider;

@WebServlet("/delSalary")
public class DeleteSalary extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int sal_id =Integer.parseInt(request.getParameter("sal_id"));
        if(ServiceHelper.salaryService.deleteSalary(sal_id)) {
            request.setAttribute("delmsg","success");
        }
        else {
            request.setAttribute("delmsg", "fail");
        }
        request.getRequestDispatcher("/viewSalary").forward(request,response);
    }
}
