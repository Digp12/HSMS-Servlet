package org.example.hospitalmanagementsystem.controller.department;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.Department;

import java.io.IOException;

@WebServlet("/updatedept")
public class UpdateDeptPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        int id= Integer.parseInt(req.getParameter("d_id"));
        Department d=ServiceHelper.deptService.getDeptById(id);
        if(d!=null){
            req.setAttribute("dept",d);
            req.getRequestDispatcher("/department/updatedept.jsp").forward(req,resp);
        }
    }
}
