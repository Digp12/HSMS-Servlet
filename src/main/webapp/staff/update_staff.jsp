<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.hospitalmanagementsystem.model.Department" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.hospitalmanagementsystem.model.StaffRole" %>
<%@ page import="org.example.hospitalmanagementsystem.model.Staff" %>

<%--
  Created by IntelliJ IDEA.
  User: digvi
  Date: 19-12-2025
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Update Staff</title>
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

                    <h4 class="card-title mb-4">Update Staff</h4>


                    <form action="/updatestaff" method="post">
                    <%Staff staff = (Staff) request.getAttribute("staff");%>
                        <input type="hidden" name="staff_id" value="<%=staff.getStaff_id()%>" required>
                        <div class="row mb-3">
                            <div class="col-md-4">
                                <label for="staff_name" class="form-label">Staff Name</label>
                                <input  type="text" class="form-control" name="staff_name" id="staff_name"
                                       value="<%=staff.getName()%>" required>
                                <small class="text-danger" id="nameerr"></small>
                            </div>

                            <div class="col-md-4">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" name="email" id="email"
                                       value="<%=staff.getEmail()%>" required>
                                <small class="text-danger" id="emailerr"></small>
                            </div>

                            <div class="col-md-4">
                                <label for="phone" class="form-label">Phone</label>
                                <div class="input-group">
                                    <span class="input-group-text">+91</span>
                                    <input type="text" class="form-control" name="phone" id="phone"
                                           value="<%=staff.getPhone()%>" required>
                                </div>
                                <small class="text-danger" id="phonerr"></small>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-md-4">
                                <label for="department" class="form-label">Department</label>
                                <%
                                    List<Department> dept = (List<Department>) request.getAttribute("departments");
                                    if (dept != null) {
                                %>
                                <select id="department" class="form-select" id="department" name="department" required>
                                    <option value="<%=staff.getDepartment().getD_id()%>"><%=staff.getDepartment().getD_name()%>
                                    </option>
                                    <%for (Department department : dept) {%>
                                    <option value="<%=department.getD_id()%>"><%=department.getD_name()%>
                                    </option>
                                    <%
                                        }
                                    } else {
                                    %>
                                    <div class="alert alert-danger" role="alert">
                                        First Add Departments
                                    </div>
                                    <%}%>
                                </select>
                                <small class="text-danger" id="depterr"></small>
                            </div>

                            <div class="col-md-4">
                                <label for="staffrole" class="form-label">Staff Role</label>
                                <%
                                    List<StaffRole> staffrole = (List<StaffRole>) request.getAttribute("staffRoles");
                                    if (staffrole != null) {
                                %>
                                <select  class="form-select" name="staffrole" id="staffrole" required>
                                    <option value="<%=staff.getStaffRole().getSr_id()%>"><%=staff.getStaffRole().getSr_id()%>
                                    </option>
                                    <%for (StaffRole staffRole : staffrole) {%>
                                    <option value="<%=staffRole.getSr_id()%>"><%=staffRole.getRole()%>
                                    </option>
                                    <%
                                        }
                                    } else {
                                    %>
                                    <div class="alert alert-danger" role="alert">
                                        First Add Staff Roles
                                    </div>
                                    <%}%>
                                </select>
                                <small class="text-danger" id="strerr"></small>
                            </div>

                            <div class="col-md-4">
                                <label for="join_date" class="form-label">Joining Date</label>
                                <input type="date" class="form-control" name="join_date" id="join_date"
                                       value="<%=staff.getJoinDate()%>" required>
                                <small class="text-danger" id="dateerr"></small>
                            </div>
                        </div>

                        <div class="row mb-3">

                            <div class="col-md-6">
                                <label class="form-label d-block">Gender</label>

                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" id="male"
                                           value="Male" ${(staff.getGender()=="Male")? 'checked':''} required>
                                    <label for="male" class="form-check-label">Male</label>
                                </div>

                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" id="female"
                                           value="Female"  ${(staff.getGender()=="Female")? 'checked':''} required>
                                    <label for="female" class="form-check-label">Female</label>
                                </div>

                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" id="other"
                                           value="Other"  ${(staff.getGender()=="Other" )? 'checked':''} required>
                                    <label for="other" class="form-check-label">Others</label>
                                </div>

                                <small class="text-danger d-block" id="gendererr"></small>
                            </div>

                            <div class="col-md-6">
                                <label class="form-label d-block">Status</label>

                                <div class="form-check form-check-inline">
                                    <input id="active" class="form-check-input" type="radio" name="status" checked
                                           value="Active" ${(staff.getStatus()=="Active")? 'checked':''} required>
                                    <label for="active" class="form-check-label">Active</label>
                                </div>

                                <div class="form-check form-check-inline">
                                    <input id="deactive" class="form-check-input" type="radio" name="status"
                                           value="Deactive" ${(staff.getStatus()=="Deactive")? 'checked':''} required>
                                    <label for="deactive" class="form-check-label">Deactive</label>
                                </div>
                            </div>
                        </div>

                        <!-- ROW 4 : ADDRESS -->
                        <div class="row mb-4">
                            <div class="col-md-12">
                                <label for="address" class="form-label">Address</label>
                                <textarea class="form-control" rows="3" id="address"
                                          name="address"><%=staff.getAddress()%> required</textarea>
                                <small class="text-danger" id="adderr"></small>
                            </div>
                        </div>

                        <!-- ACTIONS -->
                        <div class="text-end">
                            <button type="submit" class="btn btn-primary px-4">
                                Update Staff
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../Js/staffvalidation.js">

</script>
</body>
</html>

