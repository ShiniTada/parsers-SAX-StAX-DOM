
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Parsing results</title>
</head>
<body>
<table border="1" width="100%" cellpadding="5">
    <tr>
        <th rowspan="2">Id</th>
        <th rowspan="2">Tariff</th>
        <th rowspan="2">Operator</th>
        <th rowspan="2">Payroll</th>
        <th colspan="3">Call prices</th>
        <th colspan="2">Sms prices</th>
        <th colspan="3">Parameters</th>
        <th rowspan="2">Introduction date</th>
    </tr>
    <tr>
        <th>Inside the net</th>
        <th>Outside the net</th>
        <th>To stationary phone</th>
        <th>Inside the net</th>
        <th>Outside the net</th>
        <th>Favorite nums</th>
        <th>Billing</th>
        <th>Fee connection</th>
    </tr>
    <c:forEach var="elem" items="${ list }" varStatus="status">
        <tr>
            <td><c:out value="${ elem.id }"/> </td>
            <td><c:out value="${ elem.tariffName }"/> </td>
            <td><c:out value="${ elem.operatorName }"/> </td>
            <td><c:out value="${ elem.payroll }"/> </td>
            <td><c:out value="${ elem.callPrices.callPriceInsideTheNetwork }"/> </td>
            <td><c:out value="${ elem.callPrices.callPriceOutsideTheNetwork }"/> </td>
            <td><c:out value="${ elem.callPrices.callPriceToStationaryPhone }"/> </td>
            <td><c:out value="${ elem.smsPrices.smsPriceInsideTheNetwork }"/> </td>
            <td><c:out value="${ elem.smsPrices.smsPriceOutsideTheNetwork}"/> </td>
            <td><c:out value="${ elem.parameters.numberOfTheFavoriteNumbers }"/> </td>
            <td><c:out value="${ elem.parameters.billing.getValue() }"/></td>
            <td><c:out value="${ elem.parameters.feeConnection }"/> </td>
            <td>
                <fmt:setLocale value="en-EN"/>
                <fmt:formatDate value="${ elem.introductionDate }"/>
            </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
