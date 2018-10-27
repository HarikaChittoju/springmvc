<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="fu" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fu:form action="mobileupdate" method="post" modelAttribute="uu">
Mobile Id<fu:input path="mobId"/><br/>
Mobile Price<fu:input path="mobPrice"/><br/>
<input type="submit" value="Update Mobile" />
</fu:form>
</body>
</html>