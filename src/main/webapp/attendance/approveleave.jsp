<%@ page import="org.example.hospitalmanagementsystem.model.Staff" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: digvi
  Date: 22-12-2025
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Approve Leave</title>
</head>
<body>
<%@ include file="../Dependancy.jsp" %>
<%@ include file="../navbar.jsp" %>

<div class="mt-3 row justify-content-center">
    <div class="col-lg-8">
        <div class="card shadow-sm">
            <div class="card-body">
                <h4 class="card-title mb-4">Approve Leave</h4>
                <%if (request.getAttribute("staffList") != null) {
                    if(request.getAttribute("msg")!=null){
                %>
                <div class="alert alert-success" role="alert">
                    Leave Approved...!
                </div>
                <%}%>
                <form action="/approve" method="post">
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <label class="form-label">Select Staff Name :</label>
                            <%List<Staff> staffs = (List<Staff>) request.getAttribute("staffList");
                                if (staffs != null && !staffs.isEmpty()) {%>
                            <select class="form-select select2" name="staffname" id="staff" required>
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
                            <label class="form-label" for="date">Leave Date</label>
                            <input type="date" class="form-control" name="date" onchange="datevalidate(this)" id="date"
                                   required>
                            <small class="text-danger" id="dateerr"></small>
                        </div>
                    </div>

                    <div class="text-center">
                        <button type="submit" class="btn btn-primary px-4">Approve Leave</button>
                    </div>
                </form>
            </div>

        </div>
    </div>

</div>
<%
    }

%>
<script>
    $(window).ready(function () {
        $('#staff').select2({
            width: '100%'
        });
    });
    function datevalidate(input) {
        document.getElementById("dateerr").innerHTML = ""
        let date = input.value;
        let d = new Date(date + "T00:00:00");
        let cur_date = new Date();
        cur_date.setHours(0, 0, 0, 0);
        if (d <= cur_date) {
            document.getElementById("dateerr").innerHTML = "please select future date";
            input.focus()
        }
    }
</script>
</body>
</html>
