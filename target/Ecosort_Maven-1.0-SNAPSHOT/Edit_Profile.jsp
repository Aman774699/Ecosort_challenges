<%@page import="java.util.Base64"%>
<!DOCTYPE html>
<%@page  import="Crud_operation.Edit_profile$uploadimage" %>
<%@page import="com.entity.GetSet_Edit_Profile"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import=" javax.servlet.http.HttpSession"%>
<%@page import="java.io.*"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Profile Update</title>
        <link rel="stylesheet" href="Edit_profile.css">
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
                request.setAttribute("Mob", GEP.getMobileNO());
                request.setAttribute("Email", GEP.getEmail());
                request.setAttribute("Location", GEP.getLocation());
//                     request.setAttribute("profilepicture", GEP.getFilePath());
                byte photo[] = GEP.getProfilepicture();
                String photobase = Base64.getEncoder().encodeToString(photo);
                request.setAttribute("photo", "data:image/jpeg;base64," + photobase);
                
            } catch (Exception e) {
                out.print(e);
            }
        %>
        <header>
            <h1>Profile Update</h1>
        </header>
        <section class="element.style" style="margin-right: 520px">
            <form action="Update_Profile_picture" method="post">
                <div class="container">
                    <div class="profile-container">
                        <div class="profile-picture">
                            <img src="<%=request.getAttribute("photo")%>" alt="Profile Picture" id="profile-img">
                            <input type="file" id="profile-img-upload" name="UserProfile"accept="image/*">
                            <label for="profile-img-upload" id="profile-img-label">Upload Picture</label>
                        </div>
                        </form>
                        </section>  
                        <section style="margin-left: 568px;margin-top: -344px;width: 490px;">
                            <div class="profile-details">
                                <form action="Update_Profile_picture" method="post">
                                    <label for="username">Username:</label>
                                    <input type="text" id="username" name="username" value=" <%=request.getAttribute("name")%>">

                                    <label for="email">Email:</label>
                                    <input type="email" id="email" name="email" value="<%=request.getAttribute("Email")%>" readonly>

                                    <label for="email">Mobile No.</label>
                                    <input type="text" id="email" name="Mobile" value="<%=request.getAttribute("Mob")%>">

                                    <label for="bio">Location:</label>
                                    <textarea id="bio" name="Location" rows="4"><%=request.getAttribute("Location")%></textarea>


                                    <button type="submit">Update Profile</button>
                                </form>
                            </div>
                            <section>
                                </div>
                                </div>

                                <!--        <script>
                                            // Display selected image filename when a new image is selected
                                            document.getElementById('profile-img-upload').addEventListener('change', function () {
                                                var filename = this.value.split('\\').pop();
                                                document.getElementById('profile-img-label').innerText = filename;
                                            });
                                        </script>-->
                                </body>
                                </html> 