<!DOCTYPE html>
<html>
<head>
<title>Maglie da calcio - Sito di vendita</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="styles/Homepage.css">
<link rel="stylesheet" type="text/css" href="styles/Navbar.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>


</head>
<body>

	<jsp:include page="fragments/Header.jsp"/>
	<nav>
	
	<div class="menu-icon">
            <span class="fas fa-bars"></span>
     </div>
     <div class="nav-items">
            <li><a href="#">Home</a></li>
            <li><a href="#">Prodotti</a></li>
            <li><a href="#">Chi siamo</a></li>
         </div>
         <div class="search-icon">
            <span class="fas fa-search"></span>
         </div>
         <div class="cancel-icon">
            <span class="fas fa-times"></span>
         </div>
         <form action="#">
            <input type="search" class="search-data" placeholder="Search" required>
            <button type="submit" class="fas fa-search"></button>
         </form>
         <div class="user-icon">
				<li><a href="Login.jsp"><img src="./img/avatar.png" class="avatar"></a></li>
				<li><a href="ProdottiCarrello.jsp"><img src="./img/cart.png" class="cart"></a></li>
			</div>
	</nav>
	
<script>
         const menuBtn = document.querySelector(".menu-icon span");
         const searchBtn = document.querySelector(".search-icon");
         const cancelBtn = document.querySelector(".cancel-icon");
         const items = document.querySelector(".nav-items");
         const form = document.querySelector("form");
         menuBtn.onclick = ()=>{
           items.classList.add("active");
           menuBtn.classList.add("hide");
           searchBtn.classList.add("hide");
           cancelBtn.classList.add("show");
         }
         cancelBtn.onclick = ()=>{
           items.classList.remove("active");
           menuBtn.classList.remove("hide");
           searchBtn.classList.remove("hide");
           cancelBtn.classList.remove("show");
           form.classList.remove("active");
           cancelBtn.style.color = "#ff3d00";
         }
         searchBtn.onclick = ()=>{
           form.classList.add("active");
           searchBtn.classList.add("hide");
           cancelBtn.classList.add("show");
         }
      </script>
	<section>
		<!--<img src="immagine-sito.jpg" alt="Immagine del sito" />-->
		<div id="slideshow">
			<img src="img/image1.jpg"> <img src="img/image2.jpg"> <img
				src="img/image3.jpg"> <img src="img/image4.jpg"> <img
				src="img/image5.jpg">
		</div>

		<div id="BestSeller">
			<a href=""><img src="./img/BestSeller.png"></a>
		</div>
		<div id="BestSeller_Text">
			<p>Best seller</p>
		</div>
		<div id="OfferteDellaSettimana">
			<a href=""><img src="./img/OfferteDellaSettimana.jpg"></a>
		</div>
		<div id="OfferteDellaSettimana_Text">
				<p>Offerte della settimana</p>
		</div>
		<div id="UltimiArrivi">
			<a href=""><img src="./img/UltimiArrivi.jpg"></a>
		</div>
		<div id="UltimiArrivi_Text">
			<p>ULTIMI ARRIVI</p>
		</div>
	</section>
<script type="text/javascript" src="script/slideshow.js"></script>
<jsp:include page="fragments/Footer.jsp"/>

</body>
</html>