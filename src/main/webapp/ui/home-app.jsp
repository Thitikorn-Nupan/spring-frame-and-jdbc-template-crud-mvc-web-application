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
            <a class="nav-link active" href="home">Systems store the Customer's contact</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="home">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="views">Views Customer's contact</a>
        </li>
    </ul>
</div>

<div class="container mt-4" style="max-width: 600px;">
    <form class="form-control" action="create" method="post" >
        <div class="container mt-4 ">
            <p class="text-center mt-4 p-3 rounded" style="font-size: 30px;">Customer's contact Form</p>
        </div>
        <div class="row">

            <div class="col">
                <label class="form-label">firstname</label>
                <input class="form-control" type="text" placeholder="your firstname..." name="firstname" required>
            </div>

            <div class="col">
                <label class="form-label">age</label>
                <input class="form-control" type="number" placeholder="your age..." name="age" min="0" max="60" maxlength="2" required>
            </div>

            <div>
                <label class="form-label mt-1 mb-1">email</label>
                <input class="form-control" type="email" placeholder="your email... " name="email" required>
            </div>

            <div>
                <label class="form-label mt-1 mb-1">address</label>
                <input class="form-control" type="text" placeholder="your address..." name="address" required>
            </div>


            <div class="container text-center">
                <button class="btn btn-success mt-3 mb-3" type="submit" id="send">send</button>
                <button class="btn btn-warning mt-3 mb-3" type="reset" id="reset">reset</button>
            </div>

        </div>
    </form>
</div>

</body>
</html>
