<!DOCTYPE html>
<html>
<head>
<title>Maglie da calcio - Sito di vendita</title>
<link rel="stylesheet" type="text/css" href="styles/Homepage.css">
<link rel="stylesheet" type="text/css" href="styles/Navbar.css">


<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>

</head>
<body>

	<jsp:include page="fragments/Header.jsp"/>
	<nav>
		<ul class="menu">
			<li><a href="#">Home</a></li>
			<li><a href="#">Prodotti</a></li>
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
	


	<section>
		<!--<img src="immagine-sito.jpg" alt="Immagine del sito" />-->
		<div id="slideshow">
			<img src="img/image1.jpg"> <img src="img/image2.jpg"> <img
				src="img/image3.jpg"> <img src="img/image4.jpg"> <img
				src="img/image5.jpg">
		</div>

		<div>
			<h2>Best seller</h2>
			<ul>
				<li><a href="#">Maglia squadra X</a></li>
				<li><a href="#">Maglia squadra Y</a></li>
				<li><a href="#">Maglia squadra Z</a></li>
			</ul>
		</div>
		<div>
			<h2>Offerte della settimana</h2>
			<ul>
				<li><a href="#">Maglia squadra X</a></li>
				<li><a href="#">Maglia squadra Y</a></li>
				<li><a href="#">Maglia squadra Z</a></li>
			</ul>
		</div>
		<div>
			<h2>Ultimi arrivi</h2>
			<ul>
				<li><a href="#">Maglia squadra A</a></li>
				<li><a href="#">Maglia squadra B</a></li>
				<li><a href="#">Maglia squadra C</a></li>
			</ul>
		</div>
	</section>
<script type="text/javascript" src="script/slideshow.js"></script>
<jsp:include page="fragments/Footer.jsp"/>

</body>
</html>