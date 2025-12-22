<%--  Created by IntelliJ IDEA.
  User: digvi
  Date: 20-12-2025
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assign Shift</title>


</head>
<body>
<%@ include file="../Dependancy.jsp" %>
<%@ include file="../navbar.jsp" %>
<div class="container mt-4">
    <%
        HttpSession session1 = request.getSession(false);

        if(session1 == null || session1.getAttribute("username") == null){
            session.setAttribute("loginFirst", "Login First");
            response.sendRedirect("AdminLogin.jsp");
        }
    %>
    <div class="row justify-content-center">
        <div class="col-lg-10">

            <div class="card shadow-sm">
                <div class="card-body">

                    <!-- HEADER -->
                    <h4 class="card-title mb-4">Assign Shifts</h4>
                    <%
                        String msg = (String) (request.getAttribute("msg"));
                        if (msg != null) {
                            if ("success".equals(msg)) {
                    %>
                    <div class="alert alert-success" role="alert">
                        Shift Assigned Succesfully
                    </div>
                    <% } else {%>
                    <div class="alert alert-danger" role="alert">
                        Something wend wrong during assigning Shift
                    </div>
                    <%
                            }
                        }
                    %>

                    <form action="/assign_shift" method="post">

                        <div class="row mb-3">
                            <div class="col-md-4">
                                <label for="date" class="form-label">Shift Date</label>
                                <input type="date" class="form-control" name="date" id="date"
                                       onchange="loadStaffs(this)" required>
                                <small class="text-danger" id="dateerr"></small>
                            </div>
                            <div class="col-md-4">
                                <label for="shift_type" class="form-label">Select Shift Type</label>
                                <select class="form-select" name="shift_type" id="shift_type" onchange="shifttime()"
                                        required>
                                    <option value="">--- Select ---</option>
                                    <option value="Morning">Morning</option>
                                    <option value="Evening">Evening</option>
                                    <option value="Night">Night</option>
                                </select>
                                <small class="text-danger" id="typerr"></small>
                            </div>
                            <div class="col-md-4">
                                <label for="staff" class="form-label">Select Staff</label>

                                <select class="form-select select2" name="staffId" id="staff" required>
                                    <option value="">--- Select ---</option>
                                </select>

                                <small class="text-danger" id="stafferr"></small>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-md-4">
                                <label for="start_time" class="form-label">Shift Start Time</label>
                                <input type="text" class="form-control" name="start_time" id="start_time" readonly
                                       required>
                            </div>

                            <div class="col-md-4">
                                <label for="end_time" class="form-label">Shift End Time</label>
                                <input type="text" class="form-control" name="end_time" id="end_time" readonly required>
                            </div>
                        </div>

                        <div class="text-center">
                            <button type="submit" class="btn btn-primary px-4">
                                Assign Shift
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/Js/validateshift.js"></script>
</body>
</html>
