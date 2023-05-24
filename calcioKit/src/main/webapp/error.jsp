<!DOCTYPE html>
<html lang="en">
<head>
<title>Error</title>
<link rel="stylesheet" type="text/css" href="styles/error.css">

</head>
<body>

	<jsp:include page="fragments/Header.jsp" />

	<div class="container">
		<h1>Error</h1>
		<p>${errorMessage}
			<%
			String errorMessage = (String) request.getAttribute("javax.servlet.error.message");
				if (errorMessage == null) {
					errorMessage = "Page not found.";
				}
				out.println(errorMessage);
			%>
		</p>
	</div>

	<jsp:include page="fragments/Footer.jsp" />

</body>
</html>
