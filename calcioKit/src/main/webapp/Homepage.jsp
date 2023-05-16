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

	<header>
		<div id="logo">
			<img src="img/logo.jpg" alt="Logo del sito" id="ciao">
		</div>
	</header>
	<nav>
		<ul>
			<li><a href="#">Home</a></li>
			<li><a href="#">Prodotti</a></li>
			<li><a href="#">Contatti</a></li>
			<li style = "float:right">
				<div id="user-cart">
					<i class='fas fa-user-circle' style='font-size: 24px; color: white'></i>
					<i class='fas fa-shopping-cart'
						style='font-size: 24px; color: white'></i>
				</div>
			</li>
			<li style = "float:right">
				<div id="search">
					<form>
						<input type="text" name="search" placeholder="Cerca prodotti">
						<button type="submit">Cerca</button>
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
	
</body>
</html>