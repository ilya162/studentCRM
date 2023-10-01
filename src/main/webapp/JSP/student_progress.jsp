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
        <a class="logo" href="/title"><img src="../resources/img\logo2.png" alt="logo"></a>




        <ul class="nav justify-content-center">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/title">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                         class="bi bi-house" viewBox="0 0 16 16">
                        <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5ZM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5 5 5Z"/>
                    </svg>
                    На главную</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/student">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                         class="bi bi-sign-turn-left" viewBox="0 0 16 16">
                        <path d="M11 8.5A2.5 2.5 0 0 0 8.5 6H7V4.534a.25.25 0 0 0-.41-.192L4.23 6.308a.25.25 0 0 0 0 .384l2.36 1.966A.25.25 0 0 0 7 8.466V7h1.5A1.5 1.5 0 0 1 10 8.5V11h1V8.5Z"/>
                        <path fill-rule="evenodd"
                              d="M6.95.435c.58-.58 1.52-.58 2.1 0l6.515 6.516c.58.58.58 1.519 0 2.098L9.05 15.565c-.58.58-1.519.58-2.098 0L.435 9.05a1.482 1.482 0 0 1 0-2.098L6.95.435Zm1.4.7a.495.495 0 0 0-.7 0L1.134 7.65a.495.495 0 0 0 0 .7l6.516 6.516a.495.495 0 0 0 .7 0l6.516-6.516a.495.495 0 0 0 0-.7L8.35 1.134Z"/>
                    </svg>
                    Назад</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Выход
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                         class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                              d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
                        <path fill-rule="evenodd"
                              d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                    </svg>
                </a>
            </li>
        </ul>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <p class="displist">Отображена успеваемость для выбранного студента:</p>
                <table class="table table-dark table-striped-columns tabdata">


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

                <table class="table table-dark table-striped-columns tabdata">


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

            <div class="col-sm-5">
                <form action="/student_progress" method="get">
                    <select name="selectId" class="form-select termselect2" >
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

</div>



<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>


</body>
</html>