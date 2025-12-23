package org.example.hospitalmanagementsystem.controller.attendance;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.Attendance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/viewallattendance")
public class ViewAttendance extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Attendance> attendanceList= ServiceHelper.attendanceService.showAllAttendance();
        request.setAttribute("attendanceList",attendanceList);
        request.getRequestDispatcher("/attendance/view_attendance.jsp").forward(request,response);
    }
}
