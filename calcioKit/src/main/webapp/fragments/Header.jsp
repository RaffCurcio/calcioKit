<link rel="stylesheet" type="text/css" href="styles/Header.css">
<link rel="stylesheet" type="text/css" href="styles/Navbar.css">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="styles/Homepage.css">

<link rel="stylesheet" type="text/css" href="styles/Navbar.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>

<link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">

<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

<link rel="preconnect" href="https://fonts.googleapis.com"> 
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500;600&display=swap" rel="stylesheet">
<header class="top">
		<div id="headerLogo">
			<img id="logo" src="img/logo.png" alt="Logo del sito">
		</div>
	</header>
	<nav>
		<ul class="navbar">
			<li><a href="Homepage.jsp" class="active">Home</a></li>
			<li><a href="Catalogo">Prodotti</a></li>
			<li><a href="#">Contatti</a></li>
		</ul>
			
			<div class="main">
			<form class="input-box">
					<input type="text" placeholder="search" class="searchBar">
					<a href="Cerca.jsp" class="button"><i class="ri-search-line"></i></a>
			</form>
			
				<li><a href="Cart.jsp" class="cart"><i class="ri-shopping-cart-2-line"></i></a></li>
				
				<%
				if (session.getAttribute("cliente") == null) {
				%>
				<a href="#" class="user"><i class="ri-user-fill"></i></a>
				<a href="Login.jsp">Login</a>
				<a href="Registrazione.jsp">Register</a>
				<%
				} else {
				%>
				<a href="#" class="user"><i class="ri-user-fill" style = "color:green"></i></a>
				<a href="logout">Logout</a>
				<%
				}
				%>
				
				<div class="bx bx-menu" id="menu-icon"></div>
			</div>
		
	</nav>
	
