<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Система управления студентами и их успеваемостью</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="../resources/styles/styles.css">
</head>
<body>


<nav class="navbar navbar-expand-lg .bg-body">
    <div class="container main">
        <a href="/login"><img src="../resources/img/logo2.png" alt="logo"></a>


    </div>
</nav>
<p class="zagolovok2">Система управления студентами и их успеваемостью</p>

<div class="container loginform">
    <form action="/login" method="post">
        <div class="mb-3">
            <label class="form-label"></label>
            <input type="text" class="form-control" placeholder="Введите логин" id="" name="login" aria-describedby="">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label"></label>
            <input type="password" class="form-control" placeholder="Введите пароль" id="exampleInputPassword1"
                   name="password">
        </div>

        <button type="submit" class="btn btn-primary butenter">Войти</button>
    </form>

</div>
<c:if test="${Error =='loginError'}">
    <h2 class="login_error">Введен не правильный логин или пароль!</h2>
</c:if>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>
</body>
</html>