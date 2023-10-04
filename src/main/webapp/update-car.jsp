<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:import url="common/header.html"></c:import>
<title>Insert title here</title>
</head>
<body>
	<c:import url="common/nav.jsp"></c:import>
	<div class="container pt-5">
	<h2 class="pt-3">Update Car ID : ${car.id }</h2>
	<form action="car" method="post" enctype="multipart/form-data">
	
	<input type="hidden" name="mode" value="UPDATE">
	<input type="hidden" name="id" value="${car.id }">
	
	
    <div class="mb-3">
      <label for="carImage" class="form-label">Select Image</label>
      <input type="file" name="carImage" value="${car.carImage }" class="form-control" id="carImage">
      
    </div>
    
    <div class="mb-3">
		<label for="brand" class="form-label">Select brand</label>
		<select name="brand" class="form-control" id="brand">
			<option value="toyota" ${car.brand == 'toyota' ? 'selected' : ''}>Toyota</option>
			<option value="ford" ${car.brand == 'ford' ? 'selected' : ''}>Ford</option>
			<option value="bmw" ${car.brand == 'bmw' ? 'selected' : ''}>BMW</option>
			<option value="nissan" ${car.brand == 'nissan' ? 'selected' : ''}>Nissan</option>
			<option value="honda" ${car.brand == 'honda' ? 'selected' : ''}>Honda</option>
		</select>
	
	</div>
    
    <div class="mb-3">
      <label for="model" class="form-label">Model</label>
      <input type="text" name="model" value="${car.model }" class="form-control" id="model" required="required">
    </div>
    
    <div class="mb-3">
      <label for="price" class="form-label">Price</label>
      <input type="text" name="price"  value="${car.price }" class="form-control" id="price" required="required">
    </div>
    
    <div class="mb-3">
      <label for="power" class="form-label">Power</label>
      <input type="text" name="power" value="${car.power }" class="form-control" id="power" required="required">
    </div>
    
    <div class="mb-3">
      <label for="topSpeed" class="form-label">TopSpeed</label>
      <input type="text" name="topSpeed" value="${car.topSpeed }" class="form-control" id="topSpeed" required="required">
    </div>
    
    <div class="mb-3">
      <label for="numbetOfSeats" class="form-label">Number Of Seats</label>
      <input type="number" name="numberOfSeats" value="${car.numberOfSeats }" class="form-control" id="numberOfSeats" required="required">
    </div>
    
    <div class="mb-3">
      <label for="stock" class="form-label">Stock</label>
      <input type="number" name="stock" value="${car.stock }" class="form-control" id="stock" required="required">
    </div>
    
    
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
  </div>
  
  <c:import url="common/footer.html"></c:import>
</body>
</html>