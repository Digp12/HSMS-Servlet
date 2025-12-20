package org.example.hospitalmanagementsystem.controller.staff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.Department;
import org.example.hospitalmanagementsystem.model.Staff;
import org.example.hospitalmanagementsystem.model.StaffRole;

import java.io.IOException;
import java.util.List;

@WebServlet("/loadupdatestaff")
public class LoadUpdateStaff extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        int staff_id = Integer.parseInt(req.getParameter("staff_id"));
        Staff staff = ServiceHelper.staffService.getStaffById(staff_id);
        List<StaffRole> staffRoles=ServiceHelper.staffRoleService.getAllStaffRoles();
        List<Department> departments=ServiceHelper.deptService.getAllDept();
        if(staff!=null){
            req.setAttribute("staff",staff);
            req.setAttribute("staffRoles",staffRoles);
            req.setAttribute("departments",departments);
        }
        req.getRequestDispatcher("/staff/update_staff.jsp").forward(req,resp);
    }

}
