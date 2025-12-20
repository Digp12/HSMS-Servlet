package org.example.hospitalmanagementsystem.controller.salary;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.Salary;
import org.example.hospitalmanagementsystem.model.Staff;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/loadSal")
public class LoadAddSalary extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        List<Salary> salList = ServiceHelper.salaryService.viewSalary();
        request.setAttribute("AllSal",salList);

        List<Staff> sList = ServiceHelper.staffService.getAllStaff();
        request.setAttribute("AllStaff",sList);

        request.getRequestDispatcher("/salary/add_Salary.jsp").forward(request,response);
    }
}
