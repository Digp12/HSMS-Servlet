package org.example.hospitalmanagementsystem.controller.staffrole;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.StaffRole;

import java.io.IOException;
@WebServlet("/update_staffrole")
public class UpdateStaffRole extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("sr_id"));
        String staff_role=request.getParameter("sr_name");
        StaffRole staffRole= new  StaffRole(id,staff_role);
        HttpSession session=request.getSession();
        if(ServiceHelper.staffRoleService.updateStaffRole(staffRole)){
            session.setAttribute("staffrrolemsg","success");
        }else{
            session.setAttribute("staffrrolemsg","fail");
        }

        response.sendRedirect("/viewstaffrole");
    }
}
