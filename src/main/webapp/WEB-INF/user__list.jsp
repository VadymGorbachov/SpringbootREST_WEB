<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>User of list</title>
    <link href="css/user__list.css" rel="stylesheet">
</head>
<body>
<h3>
    <div align="center">
    <form action="/crud/del" method="POST">
            <input type="submit"   value="Delete"/>
            <br>
            <table>
               <caption>List of users</caption>
                <br><br><br>
                <tr>
                    <td>Id</td>
                    <td>Login</td>
                    <td>Password</td>
                    <td>Firstname</td>
                    <td>Lastname</td>
                    <td></td>
                </tr>
            <c:forEach items="${list}" var="user">
                <tr>
                    <td><c:out value="${user.getId()}"/></td>
                    <td><c:out value="${user.getLogin()}"/></td>
                    <td><c:out value="${user.getPassword()}"/></td>
                    <td><c:out value="${user.getFirstname()}"/></td>
                    <td><c:out value="${user.getLastname()}"/></td>
                    <td><input type="checkbox" id="${user.getId()}" name="Check" value="${"ок"}"  ></td>
                </tr>
                <br>
            </c:forEach>
            </table>
        </form>
    </div>
</h3>

<script>

    function onSomeClick() {
        sendData('localhost:8080/crud/del', document.forms[0]);
    }

    function onSubmit(e) {
        e.preventDefault()
        sendData('/crud/del', e.target);
    }

    function sendData(url, form) {
        var formData  = new FormData(form);
        console.log(formData.get('text1'))

        fetch(url, {
            method: 'POST',
            body: formData
        }).then(function (response) {
            console.log('do somthing after send!')
        });
    }
    </script>
</body>
</html>
