<%--
  Created by IntelliJ IDEA.
  User: digvi
  Date: 22-12-2025
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.example.hospitalmanagementsystem.model.Attendance" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    HttpSession session1 = request.getSession(false);
    if (session1 == null || session1.getAttribute("username") == null) {
        response.sendRedirect("AdminLogin.jsp");
        return;
    }
%>

<html>
<head>
    <title>View All Attendance</title>
</head>
<body>

<%@ include file="../Dependancy.jsp" %>
<%@ include file="../navbar.jsp" %>

<div class="container pt-3">

    <%-- Absent Messages --%>
    <%
        String msg = request.getParameter("absentmsg");
        if (msg != null) {
            if (msg.equals("fail")) {
    %>
    <div class="alert alert-warning">Error While Marking Absents!</div>
    <%
    } else if (msg.equals("success")) {
    %>
    <div class="alert alert-success">Marked Absents Successfully!</div>
    <%
    } else if (msg.equals("already_marked")) {
    %>
    <div class="alert alert-info">Absents are already marked!</div>
    <%
            }
        }
    %>

    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th>Attendance ID</th>
            <th>Staff Name</th>
            <th>Date</th>
            <th>Check In</th>
            <th>Check Out</th>
            <th>Status</th>

        </tr>
        </thead>
        <tbody>

        <%
            List<Attendance> attendances =
                    (List<Attendance>) request.getAttribute("attendanceList");

            if (attendances != null && !attendances.isEmpty()) {
                for (Attendance attendance : attendances) {
        %>
        <tr>
            <td><%=attendance.getId()%></td>
            <td><%=attendance.getStaff().getName()%></td>
            <td><%=attendance.getDate()%></td>
            <td><%=attendance.getIn_time()%></td>
            <td><%=attendance.getOut_time()%></td>
            <td><%=attendance.getStatus()%></td>

        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="8" class="text-center text-danger">
                No Attendance Records Found
            </td>
        </tr>
        <%
            }
        %>

        </tbody>
    </table>
</div>

</body>
</html>
