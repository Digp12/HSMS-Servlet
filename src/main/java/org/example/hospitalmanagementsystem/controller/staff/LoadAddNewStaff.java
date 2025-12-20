package org.example.hospitalmanagementsystem.controller.staff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.Department;
import org.example.hospitalmanagementsystem.model.StaffRole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/loadadd_staff")
public class LoadAddNewStaff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        List<Department> departments= ServiceHelper.deptService.getAllDept();
        req.setAttribute("departments",departments);
        List<StaffRole> staffRoles= ServiceHelper.staffRoleService.getAllStaffRoles();
        req.setAttribute("staffRoles",staffRoles);
        req.getRequestDispatcher("/staff/add_staff.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
