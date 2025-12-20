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
import java.time.YearMonth;

@WebServlet("/updateSal")
public class UpdateSalary extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Salary sal = new Salary();
        System.out.println("dig");

        int salid = Integer.parseInt(request.getParameter("sal_id"));
        double basic_salary = Double.parseDouble(request.getParameter("basic_salary"));
        double hra = Double.parseDouble(request.getParameter("hra"));
        double da = Double.parseDouble(request.getParameter("Da"));

        double pf = Double.parseDouble(request.getParameter("pf"));
        YearMonth month_year = YearMonth.parse(request.getParameter("month_year"));
        Staff  st =  ServiceHelper.staffService.getStaffByName(request.getParameter("staff_name"));
        double grossSal = ((basic_salary + hra + da) - pf);

        sal.setSalary_id(salid);
        sal.setBasic_salary(basic_salary);
        sal.setHra(hra);
        sal.setDa(da);
        sal.setPf(pf);
        sal.setMonth_year(month_year);
        sal.setStaff(st);
        sal.setNet_salary(grossSal);
        System.out.println(sal);
        if(ServiceHelper.salaryService.updateSalary(sal)){
            request.setAttribute("updatemsg","success");
        }
        else{
            request.setAttribute("updatemsg","fail");
        }
        request.getRequestDispatcher("/viewSalary").forward(request, response);
    }
}