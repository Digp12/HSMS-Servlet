<%@ page import="org.example.hospitalmanagementsystem.model.Salary" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.hospitalmanagementsystem.model.Staff" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../Dependancy.jsp" %>
<html>
<head>
    <title>Add Salary</title>
</head>
<body>
<%@ include file="../navbar.jsp" %>

<div class="container mt-4">
    <%
        HttpSession session1 = request.getSession(false);

        if(session1 == null || session1.getAttribute("username") == null){
            session.setAttribute("loginFirst", "Login First");
            response.sendRedirect("AdminLogin.jsp");
        }
    %>
    <%
        if (request.getAttribute("check") != null) {
            String sc = (String) request.getAttribute("check");
            if (sc.equals("success")) {
    %>
    <div class="alert alert-success" role="alert">
        Already exist
    </div>
    <%
        }
        }%>
    <div class="row justify-content-center">
        <div class="col-lg-10">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h4 class="card-title mb-4">Add Salary</h4>

                    <%-- Error/Success Message Handling --%>
                    <%
                        String error = request.getParameter("error");
                        if (error != null) {
                    %>
                    <div class="alert alert-danger">
                        Error: <%= error.equals("MissingFields") ? "Please fill all fields." : "Invalid data format." %>
                    </div>
                    <% } %>

                    <form action="addSalary" method="post">

                        <div class="row mb-4">
                            <div class="col-md-6">
                                <label class="form-label">Select Staff Name :</label>
                                <%
                                    List<Staff> staffs = (List<Staff>) request.getAttribute("AllStaff");
                                    if (staffs != null && !staffs.isEmpty()) {
                                %>
                                <select class="form-select" name="staffname" required>
                                    <option value="">--- Select ---</option>
                                    <% for (Staff staff : staffs) { %>
                                    <option value="<%= staff.getStaff_id() %>">
                                        <%= staff.getName() %>
                                    </option>
                                    <% } %>
                                </select>
                                <% } else { %>
                                <div class="alert alert-warning mt-2">
                                    No staff found. Please add staff members first.
                                </div>
                                <% } %>
                            </div>

                            <div class="col-md-6">
                                <label class="form-label" for="bsalary">Basic Salary</label>
                                <input type="number" class="form-control" name="salary" id="bsalary" required min="1">
                            </div>
                        </div>

                        <div class="row mb-4">
                            <div class="col-md-6">
                                <label class="form-label" for="yearMonth">Month-Year</label>
                                <input type="month" class="form-control" name="yearMonth" id="yearMonth" required>
                            </div>
                        </div>

                        <div class="text-center">
                            <button type="submit" class="btn btn-primary px-4">Add Salary</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../Js/staffvalidation.js"></script>
</body>
</html>