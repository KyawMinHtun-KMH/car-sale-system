<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="jakarta.tags.core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="common/header.html"></c:import>
<meta charset="ISO-8859-1">
<title>Sign in Form</title>
</head>
<body>


<div class="container">

	<h2>Sign in Form</h2>
<form action="login" method="post">
	<input type="hidden" name="mode" value="LOGIN">
	
    
    
    
    
    
    <div class="mb-3">
      <label for="email" class="form-label">Email</label>
      <input type="email" name="email"  class="form-control" id="email" required="required">
      <div id="emailHelp" class="form-text">We never share your email with anyone else.</div>
    </div>
    
    <div class="mb-3">
      <label for="password" class="form-label">Password</label>
      <input type="password" name="password" class="form-control" id="password" required="required">
    </div>
    
   
    

    
     
    
    
    
    <button type="submit" class="btn btn-primary">Login</button>
  </form>
  
  Not have an account?<a href="user">Sign up Here</a>

</div>

<c:import url="common/footer.html"/>
</body>
</html>