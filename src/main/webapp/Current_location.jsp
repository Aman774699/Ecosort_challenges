<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Get Location</title>
</head>
<body>

<button onclick="getLocation()">Get Location</button>

<p id="demo"></p>
<form action="Loc">

<script>
function getLocation() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(showPosition);
  } else {
    document.getElementById("demo").innerHTML = "Geolocation is not supported by this browser.";
  }
}

function showPosition(position) {
  var latitude = position.coords.latitude;
  var longitude = position.coords.longitude;
  document.getElementById("demo").innerHTML = "Latitude: " + latitude + "<br>Longitude: " + longitude;
 
}
</script>
</form>
</body>
</html>
