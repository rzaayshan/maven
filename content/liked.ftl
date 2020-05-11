<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
</head>
<body>

    <table border="1">
        <tbody>
        <#list users as user>
        <form action="/messeges/${user.id}" method="GET">
            <tr>
                <td>${user.name}</td>
                <td><img height="42" width="42" src=${user.image} ></td>
                <td><input type="submit" value="Messeges"></td>
                <td><input type="hidden" name="id" value=${user.id}></td>
            </tr>
        </form>
        </#list>
        </tbody>
    </table>

</body>
</html>
