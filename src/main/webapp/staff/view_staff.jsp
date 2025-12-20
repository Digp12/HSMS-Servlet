<%--
  Created by IntelliJ IDEA.
  User: digvi
  Date: 19-12-2025
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.hospitalmanagementsystem.model.Staff" %>
<%@ page import="java.util.List" %>
<%--  Created by IntelliJ IDEA.
  User: digvi
  Date: 18-12-2025
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>All Staff</title>
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
                <th scope="col">Email</th>
                <th scope="col">Phone</th>
                <th scope="col">address</th>
                <th scope="col">Gender</th>
                <th scope="col">Join Date</th>
                <th scope="col">Status</th>
                <th scope="col">Department</th>
                <th scope="col">Staff Role</th>
                <th scope="col">Update</th>
                <th scope="col"> Delete</th>
            </tr>
            </thead>
            <tbody>
            <%List<Staff> staf = (List<Staff>) request.getAttribute("staffs");
                if (staf != null) {
                    for (Staff staff : staf) {%>
            <tr>
                <td><%=staff.getStaff_id()%>
                </td>
                <td><%=staff.getName()%>
                </td>
                <td><%=staff.getEmail()%>
                </td>
                <td><%=staff.getPhone()%>
                </td>
                <td><%=staff.getAddress()%>
                </td>
                <td><%=staff.getGender()%>
                </td>
                <td><%=staff.getJoinDate()%>
                </td>
                <td><%=staff.getStatus()%>
                </td>
                <td><%=staff.getDepartment().getD_name()%>
                </td>
                <td><%=staff.getStaffRole().getRole()%>
                </td>
                <td><a href="/deletestaff?staff_id=<%=staff.getStaff_id()%>" class="btn btn-danger"  onclick="confirm('Are you sure you want to delete staff')">Delete</a></td>
                <td><a href="/loadupdatestaff?staff_id=<%=staff.getStaff_id()%>" class="btn btn-danger"  >Edit</a></td>
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
