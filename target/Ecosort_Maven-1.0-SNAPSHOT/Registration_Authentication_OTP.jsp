<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>OTP Validation</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                display: flex;
                align-items: center;
                justify-content: center;
                height: 100vh;
            }

            .otp-form {
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 20px;
                text-align: center;
                max-width: 400px;
                width: 100%;
            }

            .otp-input {
                width: 300px;
                height: 50px;
                font-size: 18px;
                text-align: center;
                margin: 10px;
                border: 1px solid #ddd;
                border-radius: 5px;
                outline: none;
            }

            .submit-btn {
                background-color: #4caf50;
                color: #fff;
                padding: 10px 20px;
                font-size: 16px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <div class="otp-form">
            <h2>OTP Validation</h2>
            <p>Enter the OTP sent to your email.</p>
            |   <form action="Registration_Authentication_OTP.jsp" method="post">
                <input type="text" class="otp-input" name="OTP" required>
                <br>
                <button type="submit" class="submit-btn">Submit</button>
            </form>
        </div>
        <%
            try {
                int value = Integer.parseInt(request.getParameter("OTP"));
                session = request.getSession();
                int otp = (int) session.getAttribute("OTP");
                String fullname, Email, Gender;
                String password, conformpassword, Mobile_No;
                if (value == otp) {
                    fullname = session.getAttribute("FULLNAME").toString();
                    Email = session.getAttribute("EMAIL").toString();
                    Gender = session.getAttribute("GENDER").toString();
                    Mobile_No = session.getAttribute("MOBILE_NO").toString();
                    password = session.getAttribute("PASSWORD").toString();
                    conformpassword = session.getAttribute("CONFIRM_PASSWORD").toString();
                    request.setAttribute("FULLNAME", fullname);
                    request.setAttribute("EMAIL", Email);
                    request.setAttribute("GENDER", Gender);
                    request.setAttribute("MOBILE_NO", Mobile_No);
                    request.setAttribute("PASSWORD", password);
                    request.setAttribute("CONFIRM_PASSWORD", conformpassword);
                    response.sendRedirect("New_Registration");
                } else {
                    out.println("wrong Otp");
                }
            } catch (Exception e) {

            }
        %>
    </body>
</html>
