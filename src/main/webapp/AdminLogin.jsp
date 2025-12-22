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

                <form action="adminLogin" method="post">

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
                        String msg = (String) request.getAttribute("isLogin");
                        if (msg != null) {
                    %>
                    <div class="alert alert-danger text-center">
                        <%= msg %>
                    </div>
                    <%
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

</body>
</html>
