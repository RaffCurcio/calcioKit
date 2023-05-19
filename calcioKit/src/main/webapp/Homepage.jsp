<!DOCTYPE html>
<html>
<head>
<title>Maglie da calcio - Sito di vendita</title>
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
</head>
<body>

	<jsp:include page="fragments/Header.jsp"/>	
	
	<section>
		<!--<img src="immagine-sito.jpg" alt="Immagine del sito" />-->
		<div id="slideshow">
			<img src="img/image1.jpg"> <img src="img/image2.jpg"> <img
				src="img/image3.jpg"> <img src="img/image4.jpg"> <img
				src="img/image5.jpg">
		</div>

		<div id="BestSeller">
			<a href=""><img src="./img/BestSeller.png"></a>
			<p>Best seller</p>
		</div>
		
		<div id="OfferteDellaSettimana">
			<a href=""><img src="./img/OfferteDellaSettimana.jpg"></a>
			<p>Offerte della settimana</p>
		</div>
		
		<div id="UltimiArrivi">
			<a href=""><img src="./img/UltimiArrivi.jpg"></a>
			<p>ULTIMI ARRIVI</p>
		</div>
		
	</section>
<script type="text/javascript" src="script/slideshow.js"></script>
<jsp:include page="fragments/Footer.jsp"/>

</body>
</html>