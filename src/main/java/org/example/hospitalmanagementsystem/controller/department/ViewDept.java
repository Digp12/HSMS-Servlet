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
import java.util.List;

@WebServlet("/viewdept")
public class ViewDept extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("updatemsg")!=null){
            request.setAttribute("updatemsg",session.getAttribute("updatemsg"));
            session.removeAttribute("updatemsg");
        }
        List <Department> departmentList= ServiceHelper.deptService.getAllDept();
        request.setAttribute("departments",departmentList);
        request.getRequestDispatcher("/department/department_view.jsp").forward(request,response);
    }
}
