
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Employee Home</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lato:wght@300&display=swap" rel="stylesheet">
<link rel="stylesheet" href="EmployeeHomepage.css">

</head>
<body>

<a class="btn btn-primary" href="logout">Logout</a>

<hr
Welcome : <%=request.getAttribute("username")%>
</hr>





<script src="./EmployeeHomepage.js" crossorigin="anonymous"></script>

</body>
</html>