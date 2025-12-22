package org.example.hospitalmanagementsystem.controller.staff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.*;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/updatestaff")
public class UpdateStaff extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int staff_id = Integer.parseInt(request.getParameter("staff_id"));
        String name = request.getParameter("staff_name");
        Gender gender = Gender.valueOf(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        LocalDate joinDate = LocalDate.parse(request.getParameter("join_date"));
        Status status = Status.valueOf(request.getParameter("status"));
        Department department = ServiceHelper.deptService.getDeptById(Integer.parseInt(request.getParameter("department")));
        StaffRole staffRole = ServiceHelper.staffRoleService.getStaffRoleById(Integer.parseInt(request.getParameter("staffrole")));
        Staff staff = new Staff(staff_id, name, gender, phone, email, address, joinDate, status, department, staffRole,password);
        if(ServiceHelper.staffService.updateStaff(staff)){
            request.setAttribute("updatemsg","success");
        }
        else{
            request.setAttribute("updatemsg","fail");
        }
        request.getRequestDispatcher("/viewstaff").forward(request, response);
    }
}
