<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="common/header.html" />
<title>Car shop</title>
</head>
<body>
	
	
	
	<c:import url="common/nav.jsp"></c:import>
	
	
	<!-- Carousel -->
<div id="demo" class="carousel slide mt-5 pt-5" data-bs-ride="carousel">

  <!-- Indicators/dots -->
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
  </div>

  <!-- The slideshow/carousel -->
  <div class="carousel-inner h-25">
    <div class="carousel-item active">
      <img src="img/carsoule1.jpg" alt="Los Angeles" class="d-block w-100">
    </div>
    <div class="carousel-item">
      <img src="img/carsoule2.jpg" alt="Chicago" class="d-block w-100">
    </div>
    <div class="carousel-item">
      <img src="img/carsoule3.jpg" alt="New York" class="d-block w-100">
    </div>
  </div>

  <!-- Left and right controls/icons -->
  <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
    <span class="carousel-control-next-icon"></span>
  </button>
</div>
	
	
	<div class="container mt-3 p-5">
		<div class="row pt-4">
			<div class="col">
				<div class="card border-dark rounded text-center" style="width: 18rem;">
					<img src="img/toyotalogo.png" class="card-img-top" alt="toyota">
					<div class="card-body">

						<a href="car?brand=toyota" class="btn btn-outline-info">Toyota</a>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card border-dark rounded text-center" style="width: 18rem;">
					<img src="img/fordlogo.png" class="card-img-top" alt="Ford">
					<div class="card-body">

						<a href="car?brand=ford" class="btn btn-outline-info">Ford</a>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card border-dark rounded text-center" style="width: 18rem;">
					<img src="img/bmwlogo.png" class="card-img-top" alt="BMW">
					<div class="card-body">

						<a href="car?brand=bmw" class="btn btn-outline-info">BMW</a>
					</div>
				</div>
			</div>

		</div>
		<div class="row mt-5 p-md-5">
			<div class="col ms-5">
				<div class="card border-dark rounded text-center" style="width: 18rem;">
					<img src="img/hondalogo.png" class="card-img-top" alt="toyota">
					<div class="card-body">

						<a href="car?brand=honda" class="btn btn-outline-info">Honda</a>
					</div>
				</div>
			</div>
			<div class="col ms-5">
				<div class="card border-dark rounded text-center" style="width: 18rem;">
					<img src="img/nissanlogo.png" class="card-img-top" alt="Ford">
					<div class="card-body">

						<a href="car?brand=nissan" class="btn btn-outline-info">Nissan</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<c:import url="common/footer.html" />
</body>
</html>