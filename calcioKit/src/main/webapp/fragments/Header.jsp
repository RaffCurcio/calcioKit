<link rel="stylesheet" type="text/css" href="styles/Header.css">
<link rel="stylesheet" type="text/css" href="styles/Navbar.css">
<header>
		<div id="logo">
			<img src="img/logo.jpg" alt="Logo del sito" id="ciao">
		</div>
	</header>
	<nav>
		<ul class="menu">
			<li><a href="Homepage.jsp">Home</a></li>
			<li><a href="Catalogo">Prodotti</a></li>
			<li><a href="#">Contatti</a></li>
			<li style="float:right">
			<div>
				<a href="#"><img src="./img/avatar.png" class="avatar"></a>
				<ul>
				<li><a href="Login.jsp">Login</a></li>
				</ul>
				<ul>
				<li><a href="Registrazione.jsp">Register</a></li>
				</ul>
			</div>
			</li>
			<li style="float:right">
			<div>
				<a href="ProdottiCarrello.jsp"><img src="./img/cart.png" class="cart"></a>
			</div>
			</li>
			<li style="float:right">
				<div>
					<form>
						<input type="text" name="search" placeholder="Cerca prodotti" class="searchBar">
						<a href="Cerca.jsp"><img src="./img/search.png" class="searchIcon"></a>
					</form>
				</div>
			</li>
		</ul>
	</nav>