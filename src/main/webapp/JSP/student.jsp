
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список студентов</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="../resources/styles/styles.css">
</head>
<body>

<div class="container main">
    <nav class="navbar">
        <a href="/title"><img src="../resources/img/logo2.png" alt="logo"></a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>


        <ul class="nav justify-content-center">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/student">Студенты</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/disciplines">Дисциплины</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/term">Семестры</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Выход</a>
            </li>
        </ul>
    </nav>


</div>
<p class="zagolovok2">Система управления студентами и их успеваемостью</p>

<div class="container">
    <div class="row">
        <div class="col-sm-6 leftbut">
            <div class="d-grid gap-3 col-5 mx-auto">
                <input type="submit"  class="btn btn-primary buttons" value="Просмотреть успеваемость выбранного" onclick="progressStudents()" >
                <input type="submit"  class="btn btn-primary buttons" value="Модифицировать выбранного" onclick="modifyStudents()" >

            </div>
        </div>

        <div class="col-sm-6 rightbut">
            <div class="d-grid gap-3 col-5 mx-auto">
                <button class="btn btn-primary buttons" type="button"><a href="/student_create">Создать студента</a>
                </button>
                <input type="submit" class="btn btn-primary buttons" value="Удалить выбранных студентов" onclick="deleteStudents()" >

            </div>
        </div>


    </div>

    <table class="table table-dark table-striped-columns tabdata">


        <thead>
        <tr>
            <th scope="col"></th>
            <th scope="col">Фамилия</th>
            <th scope="col">Имя</th>
            <th scope="col">Группа</th>
            <th scope="col">Дата поступления</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="st">
            <tr>
                <th scope="row">
                    <div>
                        <input class="form-check-input" type="checkbox" value="${st.id}" name="idStudent" aria-label="...">
                    </div>
                </th>
                <td>${st.ser_name}</td>
                <td>${st.name}</td>
                <td>${st.group}</td>
                <td>${st.date_in}</td>
            </tr>
        </c:forEach>


        </tbody>
    </table>
</div>
<form id = "deleteStudentForm" action="/deleteStudent" method="post">
    <input type="hidden" id="deleteStudentHidden" name="deleteStudentHidden">
</form>
<form id = "modifyStudentForm" action="/student_modify" method="get">
    <input type="hidden" id="modifyStudentHidden" name="modifyStudentHidden">
</form>
<form id = "progressStudentForm" action="/student_progress" method="get">
    <input type="hidden" id="progressStudentHidden" name="progressStudentHidden">
</form>

<script src="../resources/js/functions.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>


</body>
</html>