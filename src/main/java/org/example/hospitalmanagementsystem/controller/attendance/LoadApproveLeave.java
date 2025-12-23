package org.example.hospitalmanagementsystem.controller.attendance;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.Staff;

import java.io.IOException;
import java.util.List;
@WebServlet("/loadapproveleave")
public class LoadApproveLeave extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Staff> staffs = ServiceHelper.staffService.getAllStaff();
        request.setAttribute("staffList",staffs);
        request.getRequestDispatcher("/attendance/approveleave.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
