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
	<h2 class="pt-3">Add New Car Form</h2>
	<form action="car" method="post" enctype="multipart/form-data">
	
	<input type="hidden" name="mode" value="CREATE">
	
	<div class="mb-3">
		<label for="brand" class="form-label">Select brand</label>
		<select name="brand" class="form-control" id="brand">
			<option value="toyota">Toyota</option>
			<option value="ford">Ford</option>
			<option value="bmw">BMW</option>
			<option value="nissan">Nissan</option>
			<option value="honda">Honda</option>
		</select>
	
	</div>
	
	
    <div class="mb-3">
      <label for="carImage" class="form-label">Select Image</label>
      <input type="file" name="carImage" class="form-control" id="carImage" required="required">
      
    </div>
    
    <div class="mb-3">
      <label for="model" class="form-label">Model</label>
      <input type="text" name="model" class="form-control" id="model" required="required">
    </div>
    
    <div class="mb-3">
      <label for="price" class="form-label">Price</label>
      <input type="text" name="price"  class="form-control" id="price" required="required">
    </div>
    
    <div class="mb-3">
      <label for="power" class="form-label">Power</label>
      <input type="text" name="power" class="form-control" id="power" required="required">
    </div>
    
    <div class="mb-3">
      <label for="topSpeed" class="form-label">TopSpeed</label>
      <input type="text" name="topSpeed" class="form-control" id="topSpeed" required="required">
    </div>
    
    <div class="mb-3">
      <label for="numbetOfSeats" class="form-label">Number OF Seats</label>
      <input type="number" name="numberOfSeats" class="form-control" id="numberOfSeats" required="required">
    </div>
    
    <div class="mb-3">
      <label for="stock" class="form-label">Stock</label>
      <input type="number" name="stock" class="form-control" id="stock" required="required">
    </div>
    
    
    
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
  </div>
	
	
	<c:import url="common/footer.html"/>
	
</body>
</html>