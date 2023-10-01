<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Система управления студентами и их успеваемостью</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="../resources/styles/styles.css">


</head>
<body>

<div class="container loginform">

    <h2 class="login_header" >Система управления студентами и их успеваемостью</h2>


    <form action="/login" method="post">
        <div class="mb-3">

            <input type="text" class="form-control" placeholder="Введите логин" name="login">
        </div>
        <div class="mb-3">

            <input type="password" class="form-control" placeholder="Введите пароль" name="password">
        </div>

        <button type="submit" class="btn btn-primary butenter">Войти</button>
    </form>

</div>
<c:if test="${Error =='loginError'}">
    <h2 class="login_error">Введён не правильный логин или пароль!</h2>
</c:if>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>