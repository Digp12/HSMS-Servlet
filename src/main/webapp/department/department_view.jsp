<%@ page import="java.util.List" %>
<%@ page import="org.example.hospitalmanagementsystem.model.Department" %>
<%--  Created by IntelliJ IDEA.
  User: digvi
  Date: 18-12-2025
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Departments</title>
</head>
<body>
<%@ include file="../Dependancy.jsp" %>
<%@ include file="../navbar.jsp" %>




<div class=" justify-content-center pt-3">
    <%
        HttpSession session1 = request.getSession(false);

        if(session1 == null || session1.getAttribute("username") == null){
            session.setAttribute("loginFirst", "Login First");
            response.sendRedirect("AdminLogin.jsp");
        }
    %>
    <%if (request.getAttribute("updatemsg") != null) {
            String sc = (String) request.getAttribute("updatemsg");
            if (sc.equals("success")) {%>
    <div class="alert alert-success" role="alert">
        Department updated Succesfully
    </div>
    <%
    } else {%>
    <div class="alert alert-danger" role="alert">
        Department not updated
    </div>
    <%}
        }
        if(request.getAttribute("delmsg")!=null){
            String delmsg=(String)request.getAttribute("delmsg");
            if(delmsg.equals("success")){%>
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
                <th scope="col">Department Name</th>
                <th scope="col">Description</th>
                <th scope="col">Delete</th>
                <th scope="col">Update</th>
            </tr>
            </thead>
            <tbody>
            <%List<Department> d = (List<Department>) request.getAttribute("departments");
                if(d!=null){
                for (Department l : d) {%>
            <tr>
                <td><%=l.getD_id()%>
                </td>
                <td><%=l.getD_name()%>
                </td>
                <td><%=l.getDescriptin()%>
                </td>
                <td><a href="/deletedept?d_id=<%=l.getD_id()%>" class="btn btn-danger"  onclick="return confirm('Are you sure you want to delete this department?');">Delete</a></td>
                <td><a href="/updatedept?d_id=<%=l.getD_id()%>" class="btn btn-success">Edit</a></td>
            </tr>
                <%}
                }else{%>
                    <div class="alert alert-danger" role="alert">
                        First Add Departments
                    </div>
            <%}%>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
