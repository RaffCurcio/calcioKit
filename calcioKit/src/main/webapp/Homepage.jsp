<!DOCTYPE html>
<html>
<head>
<title>Maglie da calcio - Sito di vendita</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="styles/Homepage.css">

<link rel="stylesheet" type="text/css" href="styles/Navbar.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>



<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

 
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500;600&display=swap" rel="stylesheet">

<script type="text/javascript" src="script/slideshow.js"></script>
</head>
<body>

	<jsp:include page="fragments/Header.jsp"/>	
	
		<nav>
		<ul class="navbar">
			<li><a href="Homepage.jsp" class="active">Home</a></li>
			<li><a href="Catalogo">Prodotti</a></li>
			<li><a href="#">Contatti</a></li>
		</ul>
			<div class="main">
			<li>
			<form class="input-box">
					<input type="text" placeholder="search" class="searchBar">
					<a href="Cerca.jsp" class="button"><i class="ri-search-line"></i></a>
			</form>
			</li>
				<li><a href="#" class="cart"><i class="ri-shopping-cart-2-line"></i></a></li>
				<li><a href="#" class="cart2">Carrello</a></li>
         
				<a href="#" class="user"><i class="ri-user-fill"></i></a>
				<li><a href="Login.jsp">Login</a>
				<a href="Registrazione.jsp">Register</a><li>
			</div>
			
			<div class="toggle-btn">
				<a href=""><i class="ri-menu-line"></i></a>
			</div>
			
	</nav>
 
 
 
		<div id="slider">
			<div id="img_slider">
				<img src="img/Slider1.jpg">
			</div>
		</div>
  
	<div id="categorie">
		<div id="BestSeller">
			<a href=""><img src="./img/BestSeller.jpg"></a>
			
			<div id="BestSeller_Text">
			<p>Best seller</p>
		</div>
		</div>
		
		<div id="UltimiArrivi">
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
	<!-- 
		<jsp:include page="fragments/Footer.jsp"/>
		
		
		<script>
			const toggle_btn = document.querySelector('.toggle_btn');
			const toggle_BtnIcon = document.querySelector('.toggle_btn i');
			const dropDownMenu = document.querySelector('.main');
			
			toggle_btn.onclick() = function()
			{
				main.classList.toggle('open');
			}
			
			toggle_BtnIcon.classList = IsOpen
			? 'ri-menu-xmark'
			: 'ri-menu-line'
		</script>
		-->
</body>
</html>