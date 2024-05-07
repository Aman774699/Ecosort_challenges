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

        <form action="EnterOtp.jsp" method="post">
            <input type="text" class="otp-input" name="OTP" required>
            <br>
            <button type="submit" class="submit-btn">Submit</button>
        </form>
    </div>
    <%
        try{
          int value=Integer.parseInt(request.getParameter("OTP"));
         session=request.getSession();
         int otp=(int)session.getAttribute("OTP");
         if(value==otp)
         {
         request.setAttribute("Email", request.getParameter("email"));
         response.sendRedirect("Enter_NewPassword.jsp");
        }
        else
        {
        out.println("wrong Otp");
        }
          
        }
        catch(Exception e)
        {
           
        }
    %>
</body>
</html>
