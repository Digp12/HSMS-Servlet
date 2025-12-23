package org.example.hospitalmanagementsystem.controller.stafflogin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.Attendance;
import org.example.hospitalmanagementsystem.model.Staff;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/attendance/checkin")
public class AttendanceCheckIn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        if (session.getAttribute("staff_id") == null) {
            response.sendRedirect("/AdminLogin.jsp?error=not logged in");
        } else {
            int id = (int) session.getAttribute("staff_id");
            Staff staff = ServiceHelper.staffService.getStaffById(id);
            Attendance att = ServiceHelper.attendanceService.getAttendanceMarked(id);
            if (staff != null && att == null ) {
                Attendance attendance = new Attendance();
                attendance.setDate(LocalDate.now());
                attendance.setIn_time(LocalTime.now());
                attendance.setStaff(staff);
                attendance.setStatus("present");
                System.out.println(attendance);
                if (ServiceHelper.attendanceService.addAttendance(attendance)) {
                    session.invalidate();
                    response.sendRedirect("/AdminLogin.jsp?msg=checkin");
                }
            }
            response.sendRedirect("/attendance/staff_attendance.jsp?error=already_checked_in");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
