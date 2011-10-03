<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Ticket</title>
</head>
<body>
<h1>VR Ticket</h1>

<c:if test="${not empty ticket}">
	<p id="name">${ticket.name}</p>
	<p id="train">${ticket.train}</p>
	<p id="from">${ticket.from}</p>
	<p id="to">${ticket.to}</p>
	<p id="seatnumber">${ticket.seatnumber}</p>
</c:if>

</body>
</html>