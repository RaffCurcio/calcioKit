<!DOCTYPE html>
<html>
<head>
<title>Maglie da calcio - Sito di vendita</title>
<link rel="stylesheet" type="text/css" href="styles/Homepage.css">
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
		</ul>
		<form id="ricerca">
			<input type="text" name="search" placeholder="Cerca prodotti">
			<button type="submit">Cerca</button>
		</form>
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
	<script type="text/javascript">
		var slideshow = document.getElementById('slideshow');
		var images = slideshow.getElementsByTagName('img');
		var currentImageIndex = 0;
		var intervalTime = 5000;

		function nextImage() {
			images[currentImageIndex].classList.remove('active');
			currentImageIndex = (currentImageIndex + 1) % images.length;
			images[currentImageIndex].classList.add('active');
		}

		images[currentImageIndex].classList.add('active');
		setInterval(nextImage, intervalTime);
	</script>
</body>
</html>
