<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Buy Ticket</title>
</head>
<body>
<h1>VR</h1>
<form:errors path="ticket" />
<form:form modelAttribute="ticket" name="ticketForm" action="./ticket" method="post">	
	<input id="name" name="name" type="text"  value="" />
	<input id="train" name="train" type="text" value="" />
	<input id="from" name="from" type="text" value="" />
	<input id="to" name="to" type="text"   value="" />
	<input type="submit" value="Buy!" />
</form:form>

<c:if test="${empty ticket}">
	<p id="noticket">No ticket</p>
</c:if>

</body>
</html>