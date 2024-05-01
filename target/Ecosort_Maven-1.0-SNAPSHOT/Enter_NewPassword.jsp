<!DOCTYPE html>
<%@page import="Crud_operation.Registration$login" %> %>
<html lang="en">

    <head>
        <link rel="stylesheet" href="Login$Registration.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {
                background-image: url('Media/Home.png');
                background-size: cover;

                /*background-position: center center*/
                /*background-position: center left;*/
                background-position:  200px center;
                margin: 0;
                height: 100vh;
                display: flex;
                align-items: center;
                justify-content: flex-start;
            }

            .container {
                width: 70%;
                max-height: 540px;
                max-width: 500px;
                margin-left: 70px;
                margin-top: -123px
            }

            .card {
                border-radius: 1rem;
            }
            .bg-white {
                background-color: #e6dede!important;
            }
            .element.style {
                border-radius: 15px;
                background-color: #e6dede!important;
            }
            img, svg {
                vertical-align: middle;
                border-radius: 1.45rem;
                width: 35%;
            }
        </style>
    </head>

    <body>
        <div class="mask d-flex align-items-center h-100 gradient-custom-3">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                        <div class="card background-image" style="border-radius: 15px; background-color: #e6dede!important;">
                            <div class="card-body p-4">
                                <h2 class="text-uppercase text-center mb-3 mt-3 text-primary">
                                    <img src="Media/Ecosort_updated.png" width="100px" height="50px"></h2>
                                <form method="post" action="Enter_NewPassword" onsubmit="return myfun();">
                                    <div class="mb-3">
                                        <label class="form-label" for="form3Example4cg" required>New Password</label>
                                        <input minlength="5" required type="password" name="PASSWORD"
                                               class="form-control form-control-lg" />
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label" for="form3Example4cdg" required>Conform New password</label>
                                        <input minlength="5" required type="password" name="CONFORM_PASSWORD"
                                               class="form-control form-control-lg" />
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <button type="submit"
                                                class="btn btn-success btn-block btn-lg gradient-custom-4 text-body ">Change Password</button>
                                    </div>

                                    <p class="text-center text-muted mt-3 mb-0"> <a href="index.html"
                                                                                    class="fw-bold text-body"><u>Login here</u></a></p>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%
//        try{
//             String password=request.getParameter("PASSWORD");
//              String email=(session.getAttribute("Email")).toString();
//             Registration$login reg=new Registration$login();
//             
//             if(reg.updatepassword(email, password))
//             {
//                 
//             }
//             
//            }
//            catch(Exception e)
//            {
//            
//            }
        %>
    </body>

</html>
