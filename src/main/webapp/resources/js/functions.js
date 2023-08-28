function deleteStudents() {
    var checkedCheckboxs =
        document.querySelectorAll('input[name=idStudent]:checked')
    if (checkedCheckboxs.length == 0) {
        alert("Выберите хотябы одного студента!!!")
        return;
    }
    // "1 2 5 7" - string
    var ids = ""
    for (var i = 0; i < checkedCheckboxs.length; i++) {
        ids = ids + checkedCheckboxs[i].value + ",";
    }
    ids = ids.substring(0, ids.length - 1);


    document.getElementById("deleteStudentHidden").value = ids;
    document.getElementById('deleteStudentForm').submit();
}

function modifyStudents() {
    var checkedCheckboxs =
        document.querySelectorAll('input[name=idStudent]:checked')
    if (checkedCheckboxs.length == 0 || checkedCheckboxs.length > 1) {
        alert("Выберите  одного студента!!!")
        return;
    }
    // "1 2 5 7" - string
    var ids = ""
    for (var i = 0; i < checkedCheckboxs.length; i++) {
        ids = ids + checkedCheckboxs[i].value + ",";
    }
    ids = ids.substring(0, ids.length - 1);


    document.getElementById("modifyStudentHidden").value = ids;
    document.getElementById('modifyStudentForm').submit();
}

function progressStudents() {
    var checkedCheckboxs =
        document.querySelectorAll('input[name=idStudent]:checked')
    if (checkedCheckboxs.length == 0 || checkedCheckboxs.length > 1) {
        alert("Выберите  одного студента!!!")
        return;
    }
    // "1 2 5 7" - string
    var ids = ""
    for (var i = 0; i < checkedCheckboxs.length; i++) {
        ids = ids + checkedCheckboxs[i].value + ",";
    }
    ids = ids.substring(0, ids.length - 1);


    document.getElementById("progressStudentHidden").value = ids;
    document.getElementById('progressStudentForm').submit();
}
function modifyDiscipline() {
    var checkedCheckboxs =
        document.querySelectorAll('input[name=idDiscipline]:checked')
    if (checkedCheckboxs.length == 0 || checkedCheckboxs.length > 1) {
        alert("Выберите однy дисциплину!!!")
        return;
    }
    // "1 2 5 7" - string
    var ids = ""
    for (var i = 0; i < checkedCheckboxs.length; i++) {
        ids = ids + checkedCheckboxs[i].value + ",";
    }
    ids = ids.substring(0, ids.length - 1);


    document.getElementById("modifyDisciplineHidden").value = ids;
    document.getElementById('modifyDisciplineForm').submit();
}
function deleteDiscipline() {
    var checkedCheckboxs =
        document.querySelectorAll('input[name=idDiscipline]:checked')
    if (checkedCheckboxs.length == 0) {
        alert("Выберите хотябы одну дисциплину!!!")
        return;
    }
    // "1 2 5 7" - string
    var ids = ""
    for (var i = 0; i < checkedCheckboxs.length; i++) {
        ids = ids + checkedCheckboxs[i].value + ",";
    }
    ids = ids.substring(0, ids.length - 1);


    document.getElementById("deleteDisciplineHidden").value = ids;
    document.getElementById('deleteDisciplineForm').submit();
}
function changeTerm() {
    var checkedCheckboxs =
        document.querySelectorAll('input[name=idTerm]:checked')
    if (checkedCheckboxs.length == 0) {
        alert("Выберите один семестр!!!")
        return;
    }
    // "1 2 5 7" - string
    var ids = ""
    for (var i = 0; i < checkedCheckboxs.length; i++) {
        ids = ids + checkedCheckboxs[i].value + ",";
    }
    ids = ids.substring(0, ids.length - 1);


    document.getElementById("changeTermHidden").value = ids;
    document.getElementById('changeTermForm').submit();
}

function deleteTerm() {
    var checkedCheckboxs =
        document.querySelectorAll('input[name=idTerm]:checked')

    // "1 2 5 7" - string
    var ids = ""
    for (var i = 0; i < checkedCheckboxs.length; i++) {
        ids = ids + checkedCheckboxs[i].value + ",";
    }
    ids = ids.substring(0, ids.length - 1);


    document.getElementById("deleteTermHidden").value = ids;
    document.getElementById('deleteTermForm').submit();
}

