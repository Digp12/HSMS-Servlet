package org.example.hospitalmanagementsystem.controller.stafflogin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.Staff;

import java.io.IOException;
@WebServlet("/userlogin")
public class UserLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("adminName");
        String password=request.getParameter("password");

        Staff staff=ServiceHelper.staffService.checkStaff(email,password);

        if(staff!=null)
        {   HttpSession session=request.getSession();
            session.setAttribute("staff_id",staff.getStaff_id());
            response.sendRedirect("/attendance/staff_attendance.jsp");
        }
        else {
            request.setAttribute("isLogin", "Invalid Credentials...!");
            request.getRequestDispatcher("/AdminLogin.jsp").forward(request, response);
        }
    }
}
