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
    <p class="zagolovok2">Система управления студентами и их успеваемостью</p>

    <div class="row">
        <div class="col-sm-12">
            <p class="displist">Отображена успеваемость для выбранного студента:</p>
            <table class="table table-dark table-striped-columns">


                <thead>
                <th>
                    <th scope="col">Фамилия</th>
                    <th scope="col">Имя</th>
                    <th scope="col">Группа</th>
                    <th scope="col">Дата поступления</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input class="form-input" type="checkbox" value="${student.id}" name="idStudent"></td>
                    <td>${student.ser_name}</td>
                    <td>${student.name}</td>
                    <td>${student.group}</td>
                    <td>${student.date_in}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-6">

            <table class="table table-dark table-striped-columns">


                <thead Список дисциплин>
                <tr>
                    <th scope="col">Наименование дисциплины</th>
                    <th scope="col">Оценка</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${dm}" var = "dismark">
                    <tr>
                        <td>${dismark.nameD}</td>
                        <td>${dismark.nameM}</td>

                    </tr>
                </c:forEach>
                <td class="mark">Средняя оценка за семестр :</td>
                <td class="mark">${avg}</td>



                </tbody>
            </table>

        </div>

        <div class="col-sm-6">
            <form action="/student_progress" method="get">
            <select name="selectId" class="form-select termselect2"  placeholder="Выберите семестр">
                <c:forEach items="${terms}" var="t">
                    <option value="${t.id}"
                            <c:if test="${t.id == termFirst.id}">
                                selected
                            </c:if>
                    >${t.name}</option>
                </c:forEach>
            </select>

            <button class="btn btn-primary point" type="submit">Выбрать</button>
                <input type="hidden" name="progressStudentHidden" value="${student.id}">
            </form>
        </div>

    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>


</body>
</html>