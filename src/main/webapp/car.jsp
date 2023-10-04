<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<c:import url="common/header.html"></c:import>
</head>
<body>
	<c:import url="common/nav.jsp"></c:import>
	<div class="container p-5">
	
	
	<c:forEach var="car" items="${carList }">
	
	
			<c:url var="updateURL" value="car">
				<c:param name="mode" value="LOAD"></c:param>
				<c:param name="id" value="${car.id}"></c:param>
			</c:url>

			<c:url var="deleteURL" value="car">
				<c:param name="mode" value="DELETE"></c:param>
				<c:param name="id" value="${ car.id }"></c:param>
				<c:param name="brand" value="${car.brand }"></c:param>
			</c:url>

			<c:url var="buyURL" value="buyinglist">
				<c:param name="mode" value="CREATE"></c:param>
				<c:param name="id" value="${ car.id }"></c:param>
				<c:param name="brand" value="${car.brand }"></c:param>
			</c:url>

			

			<div class="row mt-4">
				<div class="col-sm-6">
					<img alt="carimg/hondalogo.png" src="carimg/${car.carImage }"
						class="img-fluid" style="width: 100%; height: 320px">
				</div>
				<div class="col-sm-6">
					<div class="card">

						<ul class="list-group">
							<li class="list-group-item list-group-item-dark"><strong>Model
									: </strong>${car.id}</li>
							<li class="list-group-item"><strong>Price : </strong>${car.price }
							</li>
							<li class="list-group-item list-group-item-dark"><strong>Power
									: </strong>${car.power }</li>
							<li class="list-group-item"><strong>Top Speed : </strong>${car.topSpeed }
							</li>
							<li class="list-group-item list-group-item-dark"><strong>Number
									Of Seats : </strong>${car.numberOfSeats }</li>
							<li class="list-group-item"><strong>Stock Amount :
							</strong>${car.stock }</li>
						</ul>

						<div class="card-body">
							<c:if test="${fn:contains(user.role,'ROLE_ADMIN')}">
								<a href="${ updateURL }"
									class="card-link btn btn-outline-success">Update</a>
									
									<!-- Button trigger modal -->
								<button type="button" class="btn btn-primary"
									data-bs-toggle="modal" data-bs-target="#deleteModal">
									Delete</button>
									
									<!-- Modal -->
								<div class="modal fade" id="deleteModal" tabindex="-1"
									aria-labelledby="deleteModal" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="deleteModal">Comfirm Deleteion</h5>
												<button type="button" class="btn-close"
													data-bs-dismiss="modal" aria-label="Close"></button>
											</div>
											<div class="modal-body">Are you sure you want to delete ${car.id}</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-bs-dismiss="modal">Cancel</button>
													
											<a href="${ deleteURL }"
									class="card-link btn btn-outline-success">Delete</a>	
											
												
											</div>
										</div>
									</div>
								</div>
									
								

								
								<!--<a href="${ deleteURL }"
									class="card-link btn btn-outline-danger">Delete</a>  -->

							</c:if>

							<c:if test="${fn:contains(user.role,'ROLE_USER')}">
								<a href="${ buyURL }" class="card-link btn btn-outline-success">Buy</a>
							</c:if>


						</div>


					</div>



				</div>

			</div>

	</c:forEach>

	</div>
	<c:import url="common/footer.html"></c:import>
	
	
</body>
</html>