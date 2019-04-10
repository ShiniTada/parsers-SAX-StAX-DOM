<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>
            Parsing XML
        </title>
    </head>
    <body>
    <form action="Controller" method="POST" enctype="multipart/form-data">
        <input type="hidden" name="command" value="parse"/>
        <input type="file" name="file" id="upload" accept=".xml"/><br/>
        <br>
            <label> Введите парсер(DOM, SAX, StAX) :
            <input type="text" name="parser" size="10"/><br/>
            </label>
        <br>
        <input type="submit" value="OK"/><br/>

    </form>
    </body>
</html>