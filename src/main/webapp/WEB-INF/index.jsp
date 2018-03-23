<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns:m="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="Login form; charset=UTF-8" />
    <link href="css/index.css" rel="stylesheet">
</head>
<body>

<h1>
    <form action="index" method="GET">
        <div align="center">
            <p><strong>Login:</strong>
                <input maxlength="25" size="40" name="login"></p>
            <p><strong>Password:</strong>
                <input type="password" maxlength="25" size="40" name="password"></p>
            <input type="submit"  name="Submit" value="Submit"/>
        </div>
    </form>

</h1>

</body>

</html>
