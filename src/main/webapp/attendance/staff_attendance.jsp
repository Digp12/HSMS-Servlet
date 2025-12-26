<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: digvi
  Date: 22-12-2025
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Mark Attendance</title>

    <%@ include file="../Dependancy.jsp" %>

    <style>
        body {
            background-color: #f5f7fa;
        }

        .attendance-card {
            max-width: 450px;
            margin: auto;
            margin-top: 80px;
            padding: 30px;
            border-radius: 10px;
            background: #ffffff;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        .attendance-card img {
            margin-bottom: 15px;
        }
    </style>
</head>

<body>

<div class="attendance-card text-center">

    <img src="../images/hospital_logo.png"
         width="80"
         alt="Hospital Logo">

    <h3 class="mt-3">Mark Your Attendance</h3>

    <p class="text-muted">
        Today :
        <strong class=".me-3"><%= java.time.LocalDate.now() %>
        </strong>
        <%
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String currentTime = sdf.format(new Date());%>
        Time :
        <strong ><%= currentTime %>
        </strong>
    </p>
    </p>
        <p class="text-muted">
    <hr>

    <%String error = request.getParameter("error");
        if ("not_checked_in".equals(error)) {%>
    <div class="alert alert-danger">
        You must CHECK IN before CHECK OUT...!
    </div>
    <%}
        if ("already_checked_out".equals(error)) {%>
    <div class="alert alert-warning">
        You have already checked out today...!
    </div>
    <%}
        if ("not Updated".equals(error)) {%>
    <div class="alert alert-warning">
        Error while CHECK OUT try again...!
    </div>
    <%}
        if ("already_checked_in".equals(error)) {%>
    <div class="alert alert-warning">
        You have already checked in today...!
    </div>
    <%}%>
    <div class="d-grid gap-3 mt-4">

        <a href="/attendance/checkin" class="btn btn-success btn-lg">CHECK IN</a>

        <a href="/attendance/checkout" class="btn btn-danger btn-lg">CHECK OUT</a>

    </div>

    <p class="text-muted mt-4" style="font-size: 14px;">
        Attendance can be marked only from hospital premises.
    </p>

</div>

</body>
</html>

