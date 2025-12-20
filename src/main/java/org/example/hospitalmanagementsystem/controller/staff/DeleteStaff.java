package org.example.hospitalmanagementsystem.controller.staff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;

import java.io.IOException;

@WebServlet("/deletestaff")
public class DeleteStaff extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id=Integer.parseInt(request.getParameter("staff_id"));
        if(ServiceHelper.staffService.deleteStaff(id)){
            request.setAttribute("delmsg","success");
        }
        else {
            request.setAttribute("delmsg", "fail");
        }
        request.getRequestDispatcher("/viewstaff").forward(request,response);
    }
}
