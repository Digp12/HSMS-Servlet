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
        <h1>Add Department</h1>
        <%
            String msg= (String)(request.getAttribute("msg"));
            if ( msg!= null) {
                if ("success".equals(msg)) {%>
        <div class="alert alert-success" role="alert">
            Department Added Succesfully
        </div>
        <% } else {%>
        <div class="alert alert-danger" role="alert">
            Department not added
        </div>
        <%}
          }%>

        <form action="/adddept" method="post" onsubmit="return isEmpty()">
            <div class="mb-3">
                <label for="d_name" class="form-label">Department Name</label>
                <input type="text" name="d_name" id="name" class="form-control"
                        onfocusout="validate(this.value)">
            </div>
            <div class="mb-3">
                <label for="desc" class="form-label" >Description</label>
                <textarea name="d_desc" id="desc" onmouseout="validate(this.value)" class="form-control" rows="3" cols="8">
                </textarea>
            </div>
            <div id="span" style="color:red;"></div>
            <button type="submit" id="submit" class="btn btn-primary">Add Staff Role</button>
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
        txt=document.getElementById('desc').value();
        if(txt==""){
            document.getElementById("span").innerHTML = "please enter input first";
           txt.focus();
            flag=false
        }
        return flag;
    }


</script>


</body>
</html>
