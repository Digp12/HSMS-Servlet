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
    <title>Add Staff Role</title>
    <style>
        .frm{
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
        <h1>Add Staff Role</h1>
        <%
            String msg= (String)(request.getAttribute("msg"));
            if ( msg!= null) {
                if ("success".equals(msg)) {%>
        <div class="alert alert-success" role="alert">
            Staff Role Added Succesfully
        </div>
        <% } else {%>
        <div class="alert alert-danger" role="alert">
            Staff Role not added
        </div>
        <%}
        }%>

        <form action="/addstaffrole" method="post" onsubmit="return isEmpty()">
            <div class="mb-3">
                <label for="role" class="form-label">Staff Role Name</label>
                <input type="text" name="role" id="name" class="form-control"
                       onmouseleave="validate(this.value)">
            </div>
            <div id="span" style="color:red;"></div>
            <button type="submit" id="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

</div>

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

    function isEmpty(){
        flag=true;
        input= document.getElementById('name')
        if(input.value==""){
            document.getElementById("span").innerHTML = "please enter input first";
            input.focus();
            flag=false
        }
        return flag;
    }
</script>
</body>
</html>
