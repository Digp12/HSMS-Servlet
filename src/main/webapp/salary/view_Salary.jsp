<%@ page import="java.util.List" %>
<%@ page import="org.example.hospitalmanagementsystem.model.Salary" %>
<%@ page import="org.example.hospitalmanagementsystem.helper.ServiceHelper" %><%--
  Created by IntelliJ IDEA.
  User: 91902
  Date: 20-12-2025
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../Dependancy.jsp" %>
<html>
<head>
    <title>View Salary</title>

    <style>
        #th1 th{
            background-color: gray;
            color: white;
            border-bottom: 1px solid brown;
        }
    </style>
</head>
<body>
<%@include file="../navbar.jsp" %>
<div>
    <%
        HttpSession session1 = request.getSession(false);

        if(session1 == null || session1.getAttribute("username") == null){
            session.setAttribute("loginFirst", "Login First");
            response.sendRedirect("AdminLogin.jsp");
        }
    %>
    <%
        if (request.getAttribute("updatemsg") != null) {
            String sc = (String) request.getAttribute("updatemsg");
            if (sc.equals("success")) {
    %>
    <div class="alert alert-success" role="alert">
        Salary updated Succesfully
    </div>
    <%
    } else {%>
    <div class="alert alert-danger" role="alert">
        Salary not updated
    </div>
    <%}
    }

    if (request.getAttribute("check") != null) {
        String sc = (String) request.getAttribute("check");
        if (sc.equals("success")) {
%>
    <div class="alert alert-danger" role="alert">
        Salary Already Exist
    </div>
    <%
    } else {%>
    <div class="alert alert-danger bg-danger" role="alert">
        Salary not updated
    </div>
    <%}
    }%>
    <div class="container  p-4">
        <table class="table table-striped table-hover shadow mb-5">
            <thead>
            <tr id="th1">
                <th scope="col">Staff Name</th>
                <th scope="col">Basic Salary</th>
                <th scope="col">H. R. A</th>
                <th scope="col">D. A.</th>
                <th scope="col">P. F.</th>
                <th scope="col">Month</th>
                <th scope="col">GrossSalary</th>
                <th scope="col">Update</th>
                <th scope="col"> Delete</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Salary> list = (List<Salary>) request.getAttribute("AllSal");
                if(list != null){
                    for(Salary sal : list){
                        String n = ServiceHelper.staffService.getStaffNameById(sal.getStaff().getStaff_id());
            %>
            <tr id="td1">
                <td><%=n%>
                </td>
                <td><%=sal.getBasic_salary()%>
                </td>
                <td><%=sal.getHra()%>
                </td>
                <td><%=sal.getDa()%>
                </td>
                <td><%=sal.getPf()%>
                </td>
                <td><%=sal.getMonth_year()%>
                </td>
                <td><%=sal.getNet_salary()%>
                </td>
                <td><a href="/delSalary?sal_id=<%=sal.getSalary_id()%>" onclick="confirm('Are you sure')">Delete</a></td>
                <td><a href="/loadUpdate?sal_id=<%=sal.getSalary_id()%>">Update</a></td>
            </tr>
            <%
                }
            } else {
            %>
            <div class="alert alert-danger" role="alert">
                First Add Staff
            </div>
            <%}%>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
