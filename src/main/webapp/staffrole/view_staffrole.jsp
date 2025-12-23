<%@ page import="java.util.List" %>
<%@ page import="org.example.hospitalmanagementsystem.model.StaffRole" %>
<%--
  Created by IntelliJ IDEA.
  User: digvi
  Date: 18-12-2025
  Time: 14:23
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
    <title>All Departments</title>
</head>
<body>
<%@ include file="../Dependancy.jsp" %>
<%@ include file="../navbar.jsp" %>


<div class=" justify-content-center pt-3">
    <%
        if (request.getAttribute("staffrrolemsg") != null) {
            String sc = (String) request.getAttribute("staffrrolemsg");
            if (sc.equals("success")) {%>
    <div class="alert alert-success" role="alert">
        Staff Role updated Succesfully
    </div>
    <% session.removeAttribute("staffrrolemsg");
    } else {%>
    <div class="alert alert-danger" role="alert">
        Staff Role not updated
    </div>
    <%}
    }
    %>

    <div class="container  p-4">

        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Staff Role</th>
                <th scope="col">Delete</th>
                <th scope="col">Update</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<StaffRole> d = (List<StaffRole>) request.getAttribute("staffRoles");
                if(d!=null){
                    for (StaffRole l : d) {%>
            <tr>
                <td><%=l.getSr_id()%>
                </td>
                <td><%=l.getRole()%>
                </td>
                <td><a href="/deletestaffrole?sr_id=<%= l.getSr_id()%>" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this staffrole')">Delete</a></td>
                <td><a href="/updatestaffrole?sr_id=<%=l.getSr_id()%>" class="btn btn-success" >Edit</a></td>
            </tr>
            <%}}else{%>
            <div class="alert alert-danger" role="alert">
                First Add Staff Roles
            </div>
            <%}%>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
