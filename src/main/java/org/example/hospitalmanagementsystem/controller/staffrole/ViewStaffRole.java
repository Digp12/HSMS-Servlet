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
import java.util.ArrayList;
import java.util.List;
@WebServlet("/viewstaffrole")
public class ViewStaffRole extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        request.setAttribute("staffrrolemsg",session.getAttribute("staffrrolemsg"));
        List<StaffRole> staffRoles= ServiceHelper.staffRoleService.getAllStaffRoles();
        request.setAttribute("staffRoles",staffRoles);
        request.getRequestDispatcher("/staffrole/view_staffrole.jsp").forward(request,response);

    }
}
