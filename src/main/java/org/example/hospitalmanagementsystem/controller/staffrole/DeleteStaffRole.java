package org.example.hospitalmanagementsystem.controller.staffrole;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;

import java.io.IOException;
@WebServlet("/deletestaffrole")
public class DeleteStaffRole extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        int id=Integer.parseInt(req.getParameter("sr_id"));
        ServiceHelper.staffRoleService.deleteStaffRole(id);
        resp.sendRedirect("/viewstaffrole");
    }
}
