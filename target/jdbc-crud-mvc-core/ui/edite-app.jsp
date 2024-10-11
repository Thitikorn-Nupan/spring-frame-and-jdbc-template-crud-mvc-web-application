<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value="/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/css/style-home.css" />" rel="stylesheet">
    <link href="<c:url value="/img/java-logo.png" />" rel="icon">
    <title>Customer Form</title>
</head>

<body>

<div class="container">
    <ul class="nav nav-tabs" id="">
        <li class="nav-item">
            <a class="nav-link active" href="">Systems store the Customer</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="home">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="views">Views customer</a>
        </li>
    </ul>
</div>

<div class="container mt-4" style="max-width: 600px;">
    <form class="form-control" action="/jdbc_crud_mvc_core_war/edite" method="post" >
        <div class="container mt-4 ">
            <p class="text-center mt-4 p-3 rounded" style="font-size: 30px;">Edite Form ID : ${customer.id}</p>
        </div>
        <div class="row">

            <div class="col">
                <label class="form-label">firstname</label>
                <input class="form-control" type="text" value="${customer.firstname}" name="firstname" required>
            </div>

            <div class="col">
                <label class="form-label">age</label>
                <input class="form-control" type="number"  value="${customer.age}" name="age" min="0" max="60" maxlength="2" required>
            </div>

            <div>
                <label class="form-label mt-1 mb-1">email</label>
                <input class="form-control" type="email" value="${customer.email}" name="email" required>
            </div>

            <div>
                <label class="form-label mt-1 mb-1">address</label>
                <input class="form-control" type="text" value="${customer.address}" name="address" required>
            </div>


            <div class="container text-center">
                <input  type="hidden"  name="id" value="${customer.id}">
                <%--      if u has to use value u can use attribute hidden (ซ้อนปุ่ม ไม่ซ้อนค่า)      --%>
                <button class="btn btn-success mt-3 mb-3" type="submit" id="send">send</button>
            </div>

        </div>
    </form>
</div>

</body>
</html>
