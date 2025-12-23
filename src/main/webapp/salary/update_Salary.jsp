<%@ page import="org.example.hospitalmanagementsystem.model.Salary" %>
<%@ page import="org.example.hospitalmanagementsystem.model.Staff" %><%--
  Created by IntelliJ IDEA.
  User: 91902
  Date: 20-12-2025
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession session1 = request.getSession(false);
    if(session1 == null || session1.getAttribute("username") == null){
        session.setAttribute("loginFirst", "Login First");
        response.sendRedirect("AdminLogin.jsp");
    }
%>
<html>
<head>
    <title>Update Salary</title>
</head>
<body>
<%@ include file="../Dependancy.jsp"%>
<%@include file="../navbar.jsp"%>


<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-lg-10">

            <div class="card shadow-sm">
                <div class="card-body">

                    <h4 class="card-title mb-4">Update Salary</h4>

                    <%Salary sal = (Salary) request.getAttribute("salary");%>
                    <%Staff s = (Staff) request.getAttribute("staff");%>

                    <form action="/updateSal" method="post">
                        <input type="hidden" name="sal_id" value="<%=sal.getSalary_id()%>">
                        <div class="row mb-4">
                            <div class="col-md-4">
                                <label class="form-label">Staff Name</label>
                                <input readonly type="text" class="form-control" name="staff_name" id="staff_name"
                                       value="<%=s.getName()%>">
                                <small class="text-danger" id="nameerr"></small>
                            </div>

                            <div class="col-md-4">
                                <label class="form-label" for="basic">Basic Salary</label>
                                <input type="number" class="form-control" name="basic_salary" id="basic_salary"
                                       value="<%=sal.getBasic_salary()%>">
                                <small class="text-danger" id="emailerr"></small>
                            </div>

                            <div class="col-md-4">
                                <label class="form-label" for="hra">H.R.A.</label>
                                <div class="input-group">
                                    <input type="number" class="form-control" name="hra" id="hra"
                                           value="<%=sal.getHra()%>">
                                </div>
                                <small class="text-danger" id="phonerr"></small>
                            </div>
                        </div>
                        <div class="row mb-4">
                            <div class="col-md-4">
                                <label class="form-label" for="Da">D. A.</label>
                                <input type="number" class="form-control" name="Da" id="Da"
                                       value="<%=sal.getDa()%>">
                                <small class="text-danger" id="nameerr"></small>
                            </div>

                            <div class="col-md-4">
                                <label class="form-label" for="pf">P. F.</label>
                                <input type="number" class="form-control" name="pf" id="pf"
                                       value="<%=sal.getPf()%>">
                                <small class="text-danger" id="nameerr"></small>
                            </div>

                            <div class="col-md-4">
                                <label class="form-label" for="Month">Month</label>
                                <input type="month" class="form-control" name="month_year" id="Month"
                                       value="<%=sal.getMonth_year()%>">
                                <small class="text-danger" id="nameerr"></small>
                            </div>

                        </div>
                        <div class="row mb-4">
                            <div class=" text-center">
                                <button id="submit" class="btn btn-primary">Update Data</button>
                                <small class="text-danger" id="nameerr"></small>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../Js/staffvalidation.js">

</body>
</html>
