package org.example.hospitalmanagementsystem.controller.shifts;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;

import java.io.IOException;

@WebServlet("/view_shifts")
public class ViewShifts extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(ServiceHelper.shiftsService.getAllShifts()!=null){
            request.setAttribute("shifts",ServiceHelper.shiftsService.getAllShifts());
        }
        request.getRequestDispatcher("/shifts/view_shifts.jsp").forward(request,response);
    }
}
