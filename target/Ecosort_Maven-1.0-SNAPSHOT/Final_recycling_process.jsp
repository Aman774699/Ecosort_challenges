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
        <link rel="stylesheet" href="Final_page.css">
    </head>
    <body>
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
                        <li class="nav-item ms-3"style="font-weight: 600;">
                            <a class="nav-link active" aria-current="page" href="Recyclestatus.html">Recycling Hub</a>
                        </li>
                        <li class="nav-item ms-3" style="font-weight: 600;">
                            <a class="nav-link active" aria-current="page" href="Rewards.html">Rewards</a>
                        </li>
                        <li class="nav-item ms-3" style="font-weight: 600;">
                            <a class="nav-link active" aria-current="page" href="About_project.html.html">Notification</a>
                        </li>
                        <li class="nav-item dropdown ms-3 mr-3" style="font-weight: 600;">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Setting
                            </a>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="Edit_Profile.jsp">Edit Profile</a></li>
                                <li><a class="dropdown-item" href="Edit_Profile.jsp">About Project</a></li>
                                <li><a class="dropdown-item" href="Logout.jsp">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <%
            try {
                session = request.getSession();
                String email = session.getAttribute("Email").toString();
                Edit_profile$uploadimage EPU = new Edit_profile$uploadimage();
                GetSet_Edit_Profile GEP = new GetSet_Edit_Profile();
                GEP = EPU.fetchdata(email);
                request.setAttribute("name", GEP.getUsername());
                Registration$login RL=new Registration$login();
                Getset_Reg GR=new Getset_Reg();
                GR=RL.getdata(email);
                String gender=GR.getGender();
                if(gender.equals("Male"))
                {
                request.setAttribute("gender","Mr.");
                }
                else
                {
                 request.setAttribute("gender", "Mrs.");
            }
            }
            catch (Exception e)
            {
             out.print(e);
            }
        %>
        <div class="form-button-container">
            <form action="Get_Nearest_Recycling_center" method="post">
                <div class="box2" id="box1">
                    <p>Congratulations, <%=request.getAttribute("gender")%><%=request.getAttribute("name")%> ! Your item is reusable! &#x1F973;&#x1F389;</p>
                </div>
                <div class="container">
                    <div class="box" id="box1">
                        <p>Tap the below Button to Know the Nearest Recycling Center to your Location</p>
                    </div>
                    <div class="arrow"></div>
                    <div class="box" id="box2">
                        <p>Recycle Your Item's as Per Your Choice</p>
                    </div>
                    <div class="arrow"></div>
                    <div class="box" id="box3">
                        <p>Earn The Rewards Based on Quantity</p>
                    </div>
                </div>
                <input type="submit" class="form-button" value="Tap to know the nearest Recycling center">
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    </body>
</html>