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

@WebServlet("/assign_shift")
public class AssignShifts extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int staffId = Integer.parseInt(request.getParameter("staffId"));
        Staff staff= ServiceHelper.staffService.getStaffById(staffId);
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        ShiftType status = ShiftType.valueOf(request.getParameter("shift_type"));
        LocalTime startTime = LocalTime.parse(request.getParameter("start_time"));
        LocalTime endTime = LocalTime.parse(request.getParameter("end_time"));
        Shifts shifts=new Shifts(0,staff,date,status,startTime,endTime);

        if(ServiceHelper.shiftsService.assignShifts(shifts)){
            request.setAttribute("msg","success");
        }
        else{
            request.setAttribute("msg","fail");
        }
        request.getRequestDispatcher("/shifts/assign_shift.jsp").forward(request,response);
    }
}
