package org.example.hospitalmanagementsystem.controller.salary;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.Salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/viewSalary")
public class ViewSalary extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Salary> salList = ServiceHelper.salaryService.viewSalary();
        request.setAttribute("AllSal",salList);
        request.getRequestDispatcher("/salary/view_Salary.jsp").forward(request,response);
    }
}