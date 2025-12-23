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
import java.util.List;

@WebServlet("/markabsents")
public class MarkAbsents extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate date = LocalDate.now().minusDays(1);
        List<Integer> staffids = ServiceHelper.attendanceService.getAbsentStaffIds(date);
        if(staffids.isEmpty() || staffids==null){
            resp.sendRedirect("/viewallattendance?absentmsg=already_marked");
            return;
        }
        boolean failed=false;
        for (Integer id : staffids) {
            Staff staff = new Staff();
            staff.setStaff_id(id);
            Attendance a = new Attendance();
            a.setStaff(staff);
            a.setStatus("absent");
            a.setDate(date);
            if (!ServiceHelper.attendanceService.addAttendance(a)) {
                failed=true;
                break;
            }
        }
        if (failed) {
            resp.sendRedirect("/viewallattendance?absentmsg=fail");
        } else {
            resp.sendRedirect("viewallattendance?absentmsg=success");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
