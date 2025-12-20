package org.example.hospitalmanagementsystem.controller.staffrole;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.StaffRole;

import java.io.IOException;

@WebServlet("/addstaffrole")
public class AddStaffRole extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String role=req.getParameter("role");
        StaffRole staffRole=new StaffRole(0,role);
        if(ServiceHelper.staffRoleService.addStaffRole(staffRole)){
            req.setAttribute("msg","success");
        }
        else{
            req.setAttribute("msg","failed");
        }
        req.getRequestDispatcher("/staffrole/add_staffrole.jsp").forward(req,resp);
    }
}
