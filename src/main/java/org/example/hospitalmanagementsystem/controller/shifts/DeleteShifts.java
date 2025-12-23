package org.example.hospitalmanagementsystem.controller.shifts;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;

import javax.swing.text.html.HTML;
import java.io.IOException;

@WebServlet("/delete_shifts")
public class DeleteShifts extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("shift_id"));
        if(ServiceHelper.shiftsService.deleteShiftById(id)){
            req.setAttribute("delmsg","success");
        }
        else{
            req.setAttribute("delmsg","fail");
        }
        req.getRequestDispatcher("/view_shifts").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
