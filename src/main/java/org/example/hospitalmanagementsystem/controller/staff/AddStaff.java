package org.example.hospitalmanagementsystem.controller.staff;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/add_staff")
public class AddStaff extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("staff_name");
        Gender gender = Gender.valueOf(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        LocalDate joinDate = LocalDate.parse(request.getParameter("join_date"));
        Status status = Status.valueOf(request.getParameter("status"));
        Department department = ServiceHelper.deptService.getDeptById(Integer.parseInt(request.getParameter("department")));
        StaffRole staffRole = ServiceHelper.staffRoleService.getStaffRoleById(Integer.parseInt(request.getParameter("staffrole")));
        Staff staff = new Staff(0, name, gender, phone, email, address, joinDate, status, department, staffRole);
        if(ServiceHelper.staffService.addStaff(staff)){
            request.setAttribute("msg","success");
        }
        else{
            request.setAttribute("msg","fail");
        }
        request.getRequestDispatcher("/loadadd_staff").forward(request, response);

    }
}