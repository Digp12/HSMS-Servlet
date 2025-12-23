package org.example.hospitalmanagementsystem.controller.attendance;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.Attendance;
import org.example.hospitalmanagementsystem.model.Staff;

import java.io.IOException;
import java.time.LocalDate;
@WebServlet("/approve")
public class ApproveLeave extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        LocalDate date= LocalDate.parse(request.getParameter("date"));
        int id=Integer.parseInt(request.getParameter("staffname"));
        Staff staff= ServiceHelper.staffService.getStaffById(id);
        if(staff!=null) {
            Attendance attendance = new Attendance();
            attendance.setStaff(staff);
            attendance.setDate(date);
            attendance.setStatus("absent");
            attendance.setIn_time(null);
            attendance.setOut_time(null);
            if (ServiceHelper.attendanceService.addAttendance(attendance)) {
                request.setAttribute("msg", "success");
            } else {
                request.setAttribute("msg", "fail");
            }
            request.getRequestDispatcher("/loadapproveleave").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
