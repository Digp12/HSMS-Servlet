<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container">


    <div class="row justify-content-center align-items-center vh-100 flex-column">

        <!-- Main Heading -->
        <h1 class="text-center mb-4 text-primary">
            HOSPITAL STAFF MANAGEMENT
        </h1>

        <div class="col-md-4">
            <%
                String msg1 = (String) session.getAttribute("loginFirst");
                if(msg1 != null){
            %>
            <div class="alert alert-danger text-center">
                <%= msg1 %>
            </div>
            <%
                }
            %>
            <div class="card shadow p-4">
                <h3 class="text-center mb-4">Admin Login</h3>

                <form id="form" method="post">

                    <div class="mb-3">
                        <label class="form-label d-block">Login Type</label>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="logintype"
                                   onchange="loginType(this.value)" id="admin" value="admin" required>
                            <label for="admin" class="form-check-label">Admin</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" onchange="loginType(this.value)"
                                   name="logintype" id="user" value="user" required>
                            <label for="user" class="form-check-label">User</label>
                        </div>
                        <small class="text-danger d-block" id="typeerr"></small>
                    </div>

                    <div class="mb-3">
                        <input type="text"
                               name="adminName"
                               class="form-control"
                               placeholder="Admin Name"
                               required>
                    </div>

                    <div class="mb-3">
                        <input type="password"
                               name="password"
                               class="form-control"
                               placeholder="Password"
                               required>
                    </div>
                    <%
                        String masg = (String) request.getAttribute("isLogin");
                        if (masg != null) {
                    %>
                    <div class="alert alert-danger text-center">
                        <%= masg %>
                    </div>
                    <%
                        }
                        if (request.getParameter("msg") != null) {
                            String msg = request.getParameter("msg");
                            if (msg.equals("checkin")) {%>
                    <div class="alert alert-warning">
                        Your check-in has been recorded successfully.
                    </div>
                    <%
                        }
                        if (msg.equals("checkout")) {
                    %>
                    <div class="alert alert-warning">
                        Your check-out has been recorded successfully.
                    </div>
                    <%
                            }
                        }

                        if (request.getParameter("error") != null) {
                            if (request.getParameter("error").equals("not logged in")) {%>
                    <div class="alert alert-warning">
                        Before Marking Attendance You need to login first
                    </div>

                    <%
                            }
                        }
                    %>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary">
                            Login
                        </button>
                    </div>

                </form>
            </div>
        </div>

    </div>
</div>


<script>
    function loginType(type) {
        let form = document.getElementById("form")
        if (type == "user") {
            form.setAttribute('action', 'userlogin')
        } else {
            form.setAttribute('action', 'adminLogin')
        }
    }
</script>
</body>
</html>
