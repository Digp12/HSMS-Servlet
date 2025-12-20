package org.example.hospitalmanagementsystem.controller.department;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.Department;

import java.io.IOException;
@WebServlet("/adddept")
public class AddDept extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String d_name=request.getParameter("d_name");
        String d_desc=request.getParameter("d_desc");
        Department d=new Department(0,d_name,d_desc);
         if(ServiceHelper.deptService.addDept(d)){
           request.setAttribute("msg","success");
       }
       else{
           request.setAttribute("msg","fail");
       }
       RequestDispatcher rd=request.getRequestDispatcher("/department/Add_dept.jsp");
       rd.forward(request,response);
    }
}
