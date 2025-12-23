<%@ page import="org.example.hospitalmanagementsystem.model.Department" %><%--
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
<%
    HttpSession session1 = request.getSession(false);
    if(session1 == null || session1.getAttribute("username") == null){
        session.setAttribute("loginFirst", "Login First");
        response.sendRedirect("AdminLogin.jsp");
    }
%>

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
        <%
            if (request.getAttribute("dept") != null) {
                Department d = (Department) request.getAttribute("dept");
        %>
        <form action="/update_dept" method="post" onsubmit="return isEmpty()">
            <div class="mb-3">
                <label for="d_id" class="form-label">Department Id</label>
                <input type="hidden" name="d_id" value="<%=d.getD_id()%>" required>
            </div>
            <div class="mb-3">
                <label for="d_name" class="form-label">Department Name</label>
                <input type="text" name="d_name" id="d_name" class="form-control"
                       oninput="validate(this.value)" value="<%=d.getD_name()%>" required>
            </div>
            <div class="mb-3">
                <label for="d_desc" class="form-label">Description</label>
                <textarea name="d_desc" id="desc" oninput="validate(this.value)" class="form-control" rows="3" cols="8" required>
                    <%=d.getDescriptin()%>
                </textarea>
            </div>
            <div id="span" style="color:red;"></div>
            <button type="submit" id="submit" class="btn btn-primary">Update Department</button>
        </form>
    </div>

</div>
<%} else {%>
    <div class="alert alert-danger" role="alert">
         Department not found
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
        input = document.getElementById('d_name')
        if (input.value == "") {
            document.getElementById("span").innerHTML = "please enter input first";
            input.focus();
            flag = false
        }
        txt = document.getElementById('desc').value();
        if (txt == "") {
            document.getElementById("span").innerHTML = "please enter input first";
           txt.focus();
            flag = false
        }
        return flag;
    }
</script>
</body>
</html>
