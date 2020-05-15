<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form method="GET" action="/choice">
    <h1>${name} ${surname}</h1>
    <img height="42" width="42" src=${image}>
    <input type="hidden" value="${uname}" name="uname">
    <input type="submit" value="Yes" name="choice">
    <input type="submit" value="No" name="choice"><br>
</form>
<form action="/logout" method="POST">
    <input type="submit" value="LOGOUT">
</form>

</body>
</html>