<%@ page contentType="text/html; charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Assignment3</title>
</head>
<body>

<form action="MyServlet" method="POST">
feed URL£º<input type="text" name="url" />
<input type="submit" value="add subscription" />
</form>
</br>

<c:forEach items="${feed}" var="big">
<div>
<b><a href="${big.getLink()}">${big.getTitle()}</a></b>
<ul>
    <c:forEach items="${big.getMessages()}" var="item">
    <li>${item.getTitle()}</li>
    </c:forEach>
</ul>
</div>
</c:forEach>

</body>
</html>