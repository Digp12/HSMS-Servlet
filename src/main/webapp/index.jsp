<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@ include file="Dependancy.jsp" %>
</head>
<body>
<%@ include file="navbar.jsp" %>
<h1 class="text-center mt-1">Hospital Management System</h1>
<div class="container-fluid mx-auto mt-4">
    <div class="row mx-auto justify-content-center">
        <!--department-->
        <div class="col-3 m-2 card text-center ">
            <div class="card-body">
                <h5 class="card-title">Add Departments</h5>
                <p class="card-text">Add Hospital Departments</p>
                <a href="/department/Add_dept.jsp" class="btn btn-primary">Add Department</a>
            </div>
        </div>

        <div class="col-3 m-2 card text-center">
            <div class="card-body">
                <h5 class="card-title">View Departments</h5>
                <p class="card-text">View All Hospital Departments</p>
                <a href="/viewdept" class="btn btn-primary">Show Departments</a>
            </div>
        </div>

        <!---Staff Role--->
        <div class="col-3 m-2 card text-center">
            <div class=" card-body">
                <h5 class="card-title"> Add Staff Roles</h5>
                <p class="card-text">Add Hospital Staff Roles</p>
                <a href="/staffrole/add_staffrole.jsp" class="btn btn-primary">Add Staff Role</a>
            </div>
        </div>
    </div>

    <div class="row mx-auto justify-content-center">
        <div class="col-3 m-2 card text-center">
            <div class="card-body">
                <h5 class="card-title">View Staff Roles</h5>
                <p class="card-text">View All Hospital Staff Roles</p>
                <a href="/viewstaffrole" class="btn btn-primary">Show Staff Roles</a>
            </div>
        </div>

        <!--staff-->
        <div class="col-3 m-2 card text-center">
            <div class="card-body">
                <h5 class="card-title">Add Hospital Staff</h5>
                <p class="card-text">Add New Hospital Staff</p>
                <a href="/loadadd_staff" class="btn btn-primary">Add New Staff</a>
            </div>
        </div>

        <div class="col-3 m-2 card text-center">
            <div class="card-body">
                <h5 class="card-title">View Hospital Staff</h5>
                <p class="card-text">View All Hospital Staff</p>
                <a href="/viewstaff" class="btn btn-primary">Show All Staff</a>
            </div>
        </div>
    </div>

    <div class="row mx-auto justify-content-center">
        <!--Shifts-->
        <div class="col-3 m-2 card text-center ">
            <div class="card-body">
                <h5 class="card-title">Assign Shifts</h5>
                <p class="card-text">Assign shifts to staff</p>
                <a href="/shifts/assign_shift.jsp" class="btn btn-primary">Assign Shift</a>
            </div>
        </div>

        <div class="col-3 m-2 card text-center">
            <div class="card-body">
                <h5 class="card-title">View Shifts </h5>
                <p class="card-text">View All Assigned Shifts</p>
                <a href="/viewdept" class="btn btn-primary">Show Shifts</a>
            </div>
        </div>

        <!---Salary--->
        <div class="col-3 m-2 card text-center">
            <div class=" card-body">
                <h5 class="card-title">Add Salary</h5>
                <p class="card-text">Add Salaries for this month</p>
                <a href="/loadSal" class="btn btn-primary">Add Salary</a>
            </div>
        </div>
    </div>

    <div class="row mx-auto justify-content-center">
        <!--department-->
        <div class="col-3 m-2 card text-center ">
            <div class="card-body">
                <h5 class="card-title">View Salary</h5>
                <p class="card-text">View All Given Salary</p>
                <a href="/viewSalary" class="btn btn-primary">Add Department</a>
            </div>
        </div>

    </div>




</div>



</body>
</html>