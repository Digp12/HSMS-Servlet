package org.example.hospitalmanagementsystem.controller.salary;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.Salary;
import org.example.hospitalmanagementsystem.model.Staff;

import java.io.IOException;

@WebServlet("/loadUpdate")
public class LoadUpdateSal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.getParameter("sal_id");
        Salary s = ServiceHelper.salaryService.getSalaryById(Integer.parseInt(req.getParameter("sal_id")));
        Staff st =  ServiceHelper.staffService.getStaffById(s.getStaff().getStaff_id());
        req.setAttribute("salary",s);
        req.setAttribute("staff",st);
        req.getRequestDispatcher("salary/update_Salary.jsp").forward(req,resp);
    }
}
