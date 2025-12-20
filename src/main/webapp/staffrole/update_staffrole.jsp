<%@ page import="org.example.hospitalmanagementsystem.model.StaffRole" %><%--
  Created by IntelliJ IDEA.
  User: digvi
  Date: 18-12-2025
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: digvi
  Date: 18-12-2025
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../Dependancy.jsp" %>
<html>
<head>
    <title>Title</title>
    <style>
        .frm {
            display: flex;
            align-items: center;
            justify-content: center;
        }
    </style>
</head>
<body>
<%@ include file="../navbar.jsp" %>

<div class="row frm pt-3 ">
    <div class="col-6 card pt-5">
        <h1>Update Department</h1>
        <%if (request.getAttribute("staffRole") != null) {
                StaffRole d = (StaffRole) request.getAttribute("staffRole");
        %>
        <form action="/update_staffrole" method="post" onsubmit="return isEmpty()">
            <div class="mb-3">
                <label for="sr_id" class="form-label">Staff Role Id</label>
                <input type="text" name="sr_id" class="form-control"
                       onfocusout="validate(this.value)" value="<%=d.getSr_id()%>" readonly>
            </div>
            <div class="mb-3">
                <label for="sr_name" class="form-label">Staff Role</label>
                <input type="text" name="sr_name" id="name" class="form-control"
                       onfocusout="validate(this.value)" value="<%=d.getRole()%>">
            </div>
            <div id="span" style="color:red;"></div>
            <button type="submit" id="submit" class="btn btn-primary">Update Staff Role</button>
        </form>
    </div>
</div>
<%} else {%>
<div class="alert alert-danger" role="alert">
    Staff Role not found
</div>
<%}%>
<script>
    function validate(va) {
        reg = /^[A-Za-z0-9' ']+$/;
        if (!reg.test(va) || va == "") {
            document.getElementById("span").innerHTML = "please enter valid input Name";
            document.getElementById("submit").disabled = true;
        } else {
            document.getElementById("span").innerHTML = ""
            document.getElementById("submit").disabled = false;
        }
    }

    function isEmpty() {
        flag = true;
        input = document.getElementById('sr_name')
        if (input.value == "") {
            document.getElementById("span").innerHTML = "please enter input first";
            input.focus();
            flag = false
        }
        return flag;
    }
</script>
</body>
</html>
