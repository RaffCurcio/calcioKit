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

<script type="text/javascript" src="script/slideshow.js"></script>
</head>
<body>

	<jsp:include page="fragments/Header.jsp"/>	
 
		<div id="slider">
			<div id="img_slider">
				<img src="img/Slider1.jpg">
			</div>
		</div>
  
	<div id="categorie">
		<div id="BestSeller">
			<a href=""><img src="./img/BestSeller.png"></a>
			
			<div id="BestSeller_Text">
			<p>Best seller</p>
		</div>
		</div>
		
		<div id="UltimiArrivi" allign="bottom">
			<a href=""><img src="./img/UltimiArrivi.jpg"></a>
			
			<div id="UltimiArrivi_Text">
			<p>ULTIMI ARRIVI</p>
			</div>
		</div>
		<div id="OfferteDellaSettimana">
			<a href=""><img src="./img/OfferteDellaSettimana.jpg"></a>
			
			<div id="OfferteDellaSettimana_Text">
				<p>Offerte della settimana</p>
		</div>
		</div>

		</div>
		
		
		<jsp:include page="fragments/Footer.jsp"/>
</body>
</html>