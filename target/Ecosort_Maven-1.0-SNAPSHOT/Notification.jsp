<%@page import="com.entity.GetSet_Edit_Profile"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import=" javax.servlet.http.HttpSession"%>
<%@page import="java.io.*"%>
<%@page  import="Crud_operation.Edit_profile$uploadimage" %>
<%@page  import="Crud_operation.Registration$login" %>
<%@page  import="com.entity.Getset_Reg"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <style>
            .navbar-custom {
                background-color:#37FF92;
            }

            .rounded-image {
                border-radius: 10px;
                height: 100%;
            }


            .custom-file-input::-webkit-file-upload-button {
                visibility: hidden;
                display: none;
            }

            .custom-file-input::before {
                content: 'Select File';
                display: inline-block;
                background: #36a942;
                color: white;
                padding: 6px 12px;
                outline: none;
                white-space: nowrap;
                cursor: pointer;
                border: 1px solid transparent;
                border-radius: 4px;
            }

            .custom-file-input:hover::before {
                background: #36a942;
                color: white;
            }

            .navbar-brand {
                margin-right: 30px; /* Adjust as needed */
            }

            .nav-item.dropdown {
                margin-left: 100px; /* Adjust as needed */
            }
            .navbar-nav .dropdown-menu {
                margin-right: -30px; /* Adjust as needed */
                background-color:  #37FF92;
                margin-top: 30px;
            }
            .ms-auto1{
                margin-left: 360px
            }
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }
            body {
                background: #f6f6f6;
                color: #444;
                font-family: 'Roboto', sans-serif;
                font-size: 16px;
                line-height: 1;
            }
            .container {
                max-width: 1100px;
                padding: 0 20px;
                margin:0 auto;
            }
            .panel {
                margin: 100px auto 40px;
                max-width: 500px;
                text-align: center;
            }
            .button_outer {
                background: #00000033;
                border-radius:30px;
                text-align: center;
                height: 50px;
                width: 370px;
                display: inline-block;
                transition: .2s;
                position: relative;
                overflow: hidden;
            }
            .btn_upload {
                padding: 17px 30px 12px;
                color: #fff;
                text-align: center;
                position: relative;
                display: inline-block;
                overflow: hidden;
                z-index: 3;
                white-space: nowrap;
            }
            .btn_upload input {
                position: absolute;
                width: 100%;
                left: 0;
                top: 0;
                width: 100%;
                height: 105%;
                cursor: pointer;
                opacity: 0;
            }
            .file_uploading {
                width: 100%;
                height: 10px;
                margin-top: 10px;
                background: #ccc;
            }
            .file_uploading .btn_upload {
                display: none;
            }
            .processing_bar {
                position: absolute;
                left: 0;
                top: 0;
                width: 0;
                height: 100%;
                border-radius: 30px;
                background:#83ccd3;
                transition: 3s;
            }
            .file_uploading .processing_bar {
                width: 100%;
            }
            .success_box {
                display: none;
                width: 50px;
                height: 50px;
                position: relative;
            }
            .success_box:before {
                content: '';
                display: block;
                width: 9px;
                height: 18px;
                border-bottom: 6px solid #fff;
                border-right: 6px solid #fff;
                -webkit-transform:rotate(45deg);
                -moz-transform:rotate(45deg);
                -ms-transform:rotate(45deg);
                transform:rotate(45deg);
                position: absolute;
                left: 17px;
                top: 10px;
            }
            .file_uploaded .success_box {
                display: inline-block;
            }
            .file_uploaded {
                margin-top: 0;
                width: 50px;
                background:#83ccd3;
                height: 50px;
            }
            .uploaded_file_view {
                max-width: 300px;
                margin: 40px auto;
                text-align: center;
                position: relative;
                transition: .2s;
                opacity: 0;
                border: 2px solid #ddd;
                padding: 15px;
            }
            .file_remove{
                width: 30px;
                height: 30px;
                border-radius: 50%;
                display: block;
                position: absolute;
                background: #aaa;
                line-height: 30px;
                color: #fff;
                font-size: 12px;
                cursor: pointer;
                right: -15px;
                top: -15px;
            }
            .file_remove:hover {
                background: #222;
                transition: .2s;
            }
            .uploaded_file_view img {
                max-width: 100%;
            }
            .uploaded_file_view.show {
                opacity: 1;
            }
            .error_msg {
                text-align: center;
                color: #f00
            }
            .mt-3 {
                margin-top: -2rem!important;
            }
            a {
                color: #000;
                text-decoration: auto;
            }
        </style>
        <script>
            function submitRecyclingForm() {
                document.getElementById("recyclingForm").submit();
            }
        </script>
    </head>
    <body>
        <%
            try {
                session = request.getSession();
                String email = session.getAttribute("Email").toString();
                Edit_profile$uploadimage EPU = new Edit_profile$uploadimage();
                GetSet_Edit_Profile GEP = new GetSet_Edit_Profile();
                GEP = EPU.fetchdata(email);
                request.setAttribute("name", GEP.getUsername());
                Registration$login RL = new Registration$login();
                Getset_Reg GR = new Getset_Reg();
                GR = RL.getdata(email);
                String gender = GR.getGender();
                if (gender.equals("Male")) {
                    request.setAttribute("gender", "Mr.");
                } else {
                    request.setAttribute("gender", "Mrs.");
                }
            } catch (Exception e) {
                out.print(e);
            }
        %>
        <nav class="navbar navbar-expand-lg navbar-light navbar-custom" style="font-size: larger;">
            <div class="container-fluid">
                <a class="navbar-brand me-5" href="#"><img src="Media/Ecosort_updated.png" width="150px" height="70px" class="col-md-6 rounded-image"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent" >
                    <ul class="navbar-nav ms-auto1 mb-2 mb-lg-0 " >
                        <li class="nav-item ms-3" style="font-weight: 600;">
                            <a class="nav-link active" aria-current="page" href="Home_page.jsp">Home</a>
                        </li>
                        <form id="recyclingForm" action="Get_Nearest_Recycling_center" method="post">

                            <li class="nav-item ms-3" style="font-weight: 600;">
                                <a class="nav-link active" aria-current="page" href="#" onclick="submitRecyclingForm()">RecycleHub</a>
                            </li>
                        </form>
                        <li class="nav-item ms-3" style="font-weight: 600;">
                            <a class="nav-link active" aria-current="page" href="Rewards.html">Rewards</a>
                        </li>
                        <li class="nav-item ms-3" style="font-weight: 600;">
                            <a class="nav-link active" aria-current="page" href="Notification.html">Notification</a>
                        </li>
                        <li class="nav-item dropdown ms-3 mr-3" style="font-weight: 600;">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <%=request.getAttribute("gender")%><%=request.getAttribute("name")%>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="Edit_Profile.jsp">Edit Profile</a></li>
                                <li><a class="dropdown-item" href="About_project.html">About Project</a></li>
                                <li><a class="dropdown-item" href="Logout.jsp">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        </div>
            
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    </body>
</html>