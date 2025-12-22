package org.example.hospitalmanagementsystem.controller.shifts;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.ShiftType;
import org.example.hospitalmanagementsystem.model.Shifts;
import org.example.hospitalmanagementsystem.model.Staff;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/updateshifts")
public class UpdateShift extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int shiftId = Integer.parseInt(request.getParameter("shift"));
        int staffId = Integer.parseInt(request.getParameter("staffId"));
        Staff staff= ServiceHelper.staffService.getStaffById(staffId);
        LocalDate shiftDate = LocalDate.parse(request.getParameter("date"));
        ShiftType status = ShiftType.valueOf(request.getParameter("shift_type"));
        LocalTime startTime = LocalTime.parse(request.getParameter("start_time"));
        LocalTime endTime = LocalTime.parse(request.getParameter("end_time"));
        Shifts shifts=new Shifts(shiftId,staff,shiftDate,status,startTime,endTime);
        if(ServiceHelper.shiftsService.updateShiftById(shifts)){
            request.setAttribute("updatemsg","success");
        }else {
            request.setAttribute("updatemsg","fail");
        }
        request.getRequestDispatcher("/viewstaff").forward(request,response);
    }
}
