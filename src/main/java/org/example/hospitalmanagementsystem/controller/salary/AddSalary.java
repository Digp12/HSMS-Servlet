package org.example.hospitalmanagementsystem.controller.salary;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.Salary;

import java.io.IOException;
import java.time.YearMonth;

@WebServlet("/addSalary")
public class AddSalary extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String staffIdStr = request.getParameter("staffname");
        String bsalaryStr = request.getParameter("salary");
        String ym = request.getParameter("yearMonth");
        System.out.println("staffIdStr:"+staffIdStr);
        System.out.println("bsalaryStr:"+bsalaryStr);
        System.out.println("ym:"+ym);
        if (staffIdStr == null || staffIdStr.isEmpty() ||
                bsalaryStr == null || bsalaryStr.isEmpty() ||
                ym == null || ym.isEmpty()) {

            response.sendRedirect("addSalary.jsp?error=MissingFields");
            return;
        }
            int staffId = Integer.parseInt(staffIdStr);
            double bsalary = Double.parseDouble(bsalaryStr);
            YearMonth yearMonth = YearMonth.parse(ym);

            double hra = (bsalary * 20) / 100;
            double da = (bsalary * 15) / 100;
            double pf = (bsalary * 12) / 100;

            int absentDays = ServiceHelper.salaryService.findHolidayReduction(staffId);
            int daysInMonth = yearMonth.lengthOfMonth();
            double oneDaySalary = bsalary / daysInMonth;

            if(ServiceHelper.salaryService.checkAlreadyAssignedOrNot(staffId, yearMonth)) {
                request.setAttribute("check", "success");
                request.getRequestDispatcher("/viewSalary").forward(request, response);
                return;
            }
            double netSalary = ((bsalary + hra + da) - (absentDays * oneDaySalary)) - pf;
            Salary sal = new Salary();
            sal.setBasic_salary(bsalary);
            sal.setHra(hra);
            sal.setDa(da);
            sal.setPf(pf);
            sal.setNet_salary(netSalary);
            sal.setMonth_year(yearMonth);
            sal.setStaff(ServiceHelper.staffService.getStaffById(staffId));

        if(ServiceHelper.salaryService.addSalary(sal)){
            request.setAttribute("addmsg","success");
        }
        else{
            request.setAttribute("addmsg","fail");
        }
        request.getRequestDispatcher("/viewSalary").forward(request, response);
    }
}
