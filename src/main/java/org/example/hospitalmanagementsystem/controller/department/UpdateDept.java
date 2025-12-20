package org.example.hospitalmanagementsystem.controller.department;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.Department;

import java.io.IOException;

@WebServlet("/update_dept")
public class UpdateDept extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id= Integer.parseInt(request.getParameter("d_id"));
        String d_name=request.getParameter("d_name");
        String d_desc=request.getParameter("d_desc");
        Department d=new Department(id,d_name,d_desc);
        HttpSession session=request.getSession();
        if(ServiceHelper.deptService.updateDept(d)){
            session.setAttribute("updatemsg","success");
        }
        else {
            session.setAttribute("updatemsg","fail");
        }
        response.sendRedirect("/viewdept");
    }
}
