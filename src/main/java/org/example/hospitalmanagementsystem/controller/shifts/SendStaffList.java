package org.example.hospitalmanagementsystem.controller.shifts;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.Shifts;
import org.example.hospitalmanagementsystem.model.Staff;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/get_staffs")
public class SendStaffList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        List<Staff> staffs = ServiceHelper.staffService.getAllStaff();
        String dateParam = request.getParameter("date");

        String shiftParam = request.getParameter("shift");
        Staff staf = null;
        if (shiftParam != null && !shiftParam.isEmpty()) {
           int shiftid = Integer.parseInt(shiftParam);
           Shifts shifts= ServiceHelper.shiftsService.getShiftById(shiftid);
           staf=shifts.getStaff();
        }
        if (dateParam != null && !dateParam.isEmpty()) {
            LocalDate shiftdate = LocalDate.parse(dateParam);
            List<Shifts> shifts = ServiceHelper.shiftsService.getAllShiftsByDate(shiftdate);
            if (shifts != null && staffs != null) {
                List<Integer> assignedStaffIds = new ArrayList<>();
                for (Shifts shift : shifts) {
                    if (shift.getStaff() != null) {
                        assignedStaffIds.add(shift.getStaff().getStaff_id());
                    }
                }
                Integer curStaffId= (staf != null) ? staf.getStaff_id() : null;
                staffs.removeIf(staff -> assignedStaffIds.contains(staff.getStaff_id()) &&
                        (curStaffId == null || staff.getStaff_id() != curStaffId));
            }
            StringBuilder json = new StringBuilder("[");
            for (Staff s : staffs) {
                json.append("{")
                        .append("\"id\":").append(s.getStaff_id()).append(",")
                        .append("\"name\":\"").append(s.getName()).append("\"")
                        .append("},");
            }
            if (json.length() > 1) json.deleteCharAt(json.length() - 1);
            json.append("]");
            response.getWriter().write(json.toString());
        } else {
            response.getWriter().write("[]");
            return;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doGet(request, response);
    }
}
