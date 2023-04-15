<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value="/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/css/style-views.css" />" rel="stylesheet">
    <link href="<c:url value="/img/java-logo.png" />" rel="icon">
    <title>Customer Form</title>
</head>

<body>

<div class="container">
    <ul class="nav nav-tabs" id="">
        <li class="nav-item">
            <a class="nav-link active" href="home">Systems store the Customer</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="home">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="views">Views customer</a>
        </li>
    </ul>
</div>

<div class="container mt-4" style="max-width: 960px">
    <div class="row">
        <table class="table table-striped">

            <thead>
            <tr>
                <th>ID</th>
                <th>Firstname</th>
                <th>Age</th>
                <th>Email</th>
                <th>Address</th>
                <th class="text-center">Choose</th>
            </tr>
            </thead>

            <tbody class="" style="font-size: 28px;">
            <c:forEach var="customer" items="${customerList}">
                <tr class="mt-2">
                    <td>${customer.id}</td>
                    <td>${customer.firstname}</td>
                    <td>${customer.age}</td>
                    <td>${customer.email}</td>
                    <td>${customer.address}</td>
                    <td class="text-center">
                        <a href="editeById/${customer.id}" class="btn btn-warning btn-xs"> Edit</a>
                        <a href="deleteById/${customer.id}" class="btn btn-danger btn-xs"> Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>

</body>
</html>
