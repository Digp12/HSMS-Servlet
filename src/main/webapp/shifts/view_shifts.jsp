<%@ page import="org.example.hospitalmanagementsystem.model.Shifts" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: digvi
  Date: 20-12-2025
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Shifts</title>
</head>
<body>

<%@ include file="../Dependancy.jsp" %>
<%@ include file="../navbar.jsp" %>

<div class=" justify-content-center pt-3">
    <%
        if (request.getAttribute("updatemsg") != null) {
            String sc = (String) request.getAttribute("updatemsg");
            if (sc.equals("success")) {
    %>
    <div class="alert alert-success" role="alert">
        Staff updated Succesfully
    </div>
    <%
    } else {%>
    <div class="alert alert-danger" role="alert">
        Staff not updated
    </div>
    <%}
    }
        if (request.getAttribute("delmsg") != null) {
            String delmsg = (String) request.getAttribute("delmsg");
            if (delmsg.equals("success")) {%>

    <div class="alert alert-success" role="alert">
        Department deleted Succesfully
    </div>
    <%} else {%>
    <div class="alert alert-success" role="alert">
        Something went wrong during deleting Department
    </div>
    <%}
    }%>
    <div class="container  p-4">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Staff Name</th>
                <th scope="col">Shift Date</th>
                <th scope="col">Shift Start Time</th>
                <th scope="col">Shift End Time</th>
                <th scope="col">Shift Type</th>
                <th scope="col">Update</th>
                <th scope="col"> Delete</th>
            </tr>
            </thead>
            <tbody>
            <%List<Shifts> shift = (List<Shifts>)  request.getAttribute("shifts");
                if (shift != null) {
                    for (Shifts shifts : shift) {%>
            <tr>
                <td><%=shifts.getShiftId()%>
                </td>
                <td><%=shifts.getStaff().getName()%>
                </td>
                <td><%=shifts.getShiftDate()%>
                </td>
                <td><%=shifts.getStartTime()%>
                </td>
                <td><%=shifts.getEndTime()%>
                </td>
                <td><%=shifts.getShiftType()%>
                </td>

                <td><a href="/deletestaff?staff_id=<%=shifts.getShiftId()%>" onclick="confirm('Are you sure')">Delete</a></td>
                <td><a href="/load_update_shift?shift_id=<%=shifts.getShiftId()%>">Update</a></td>
            </tr>
            <%}
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
