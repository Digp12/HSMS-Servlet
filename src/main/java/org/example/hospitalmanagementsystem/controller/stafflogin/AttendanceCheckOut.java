package org.example.hospitalmanagementsystem.controller.stafflogin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.Attendance;

import java.io.IOException;
import java.time.LocalTime;
@WebServlet("/attendance/checkout")
public class AttendanceCheckOut extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        if (session.getAttribute("staff_id") == null) {
            response.sendRedirect("/AdminLogin.jsp");
        }
        int id=(int)session.getAttribute("staff_id");
        Attendance attendance= ServiceHelper.attendanceService.getAttendanceMarked(id);
        if(attendance==null || attendance.getIn_time()==null ){
            response.sendRedirect("/attendance/staff_attendance.jsp?error=not_checked_in");
            return;
        }
        if (attendance.getOut_time() != null) {
            response.sendRedirect("/attendance/staff_attendance.jsp?error=already_checked_out");
            return;
        }
        attendance.setOut_time(LocalTime.now());
        if(!ServiceHelper.attendanceService.updateAttendance(attendance))
            response.sendRedirect("/attendance/staff_attendance.jsp?error=not updated");
        session.invalidate();
        response.sendRedirect("/AdminLogin.jsp?msg=checkout");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
