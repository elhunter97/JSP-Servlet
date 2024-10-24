<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WINDOWS
  Date: 10/24/2024
  Time: 11:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo JSTL TAG</title>
</head>
<body>
<h1>1-C:out</h1>
<c:out value="${'This is true: 10>1'}"/>
<br/>
Tag: <c:out value="${'<atg>,&'}"/>
<br/>
<h2>C:SET</h2>
<c:set scope="request" var="greeting" value="Hello every body"/>
Greeting: <c:out  value="${greeting}"/>
<br/>
<h2>C:REMOVE</h2>
<c:remove scope="request" var="greeting"/>
Greeting: <c:out  value="${greeting}"/>
<br/>
<h2>C:Catch</h2>
<c:catch var="ex">
    <%
        int a = 100/0;
    %>
</c:catch>
<c:if test="${ex!=null}">
    Exception: ${ex}
    <br/>
    Message: ${ex.message}
</c:if>
<br/>
<h2>C:IF</h2>
<c:set var="salary" value="${2000*2}" />
<c:if test="${salary>3000}">
    <p>My salary is: <c:out value="${salary}"/></p>
</c:if>
<br/>
<h2>C:CHOOSE</h2>
<c:set var="salary" value="${2000*2}" />
<c:choose>
    <c:when test="${salary<=0}">
        Lương thấp quá
    </c:when>
    <c:when test="${salary>1000}">
        Lương ổn
    </c:when>
    <c:otherwise>
        Lương cao
    </c:otherwise>
</c:choose>
<br/>
<h2>For-each</h2>
<c:forEach var="i" begin="1" end="5">
    Item: ${i}
</c:forEach>
</body>
</html>
