function myfun() {

    var emailInput = document.getElementsByName("EMAIL")[0].value;

    if (!emailInput.toLowerCase().endsWith('@gmail.com')) {
        alert('Please enter a valid Gmail address.');
        return false; // Prevent form submission
    }
    return true;
}
function validatePassword() {
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    var passwordStrength = document.getElementById("passwordStrength");

    // Regular expressions to check for uppercase, lowercase, numeric, and special characters
    var upperCase = /[A-Z]/g;
    var lowerCase = /[a-z]/g;
    var numbers = /[0-9]/g;
    var specialChars = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;

    // Check if the password meets the criteria
    var isStrong = password.length >= 8 && password.match(upperCase) && password.match(lowerCase) && password.match(numbers) && password.match(specialChars);

    if (!isStrong) {
        passwordStrength.innerHTML = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character.";
        passwordStrength.style.color = "red";
    } else {
        passwordStrength.innerHTML = "";
    }

    // Check if passwords match
    if (password !== confirmPassword) {
        document.getElementById("confirmPasswordError").innerHTML = "Passwords do not match.";
    } else {
        document.getElementById("confirmPasswordError").innerHTML = "";
    }
}
