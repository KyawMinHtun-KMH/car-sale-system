<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top opacity-75">
	<div class="container-fluid">

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active text-info"
					aria-current="page" href="home">Home</a></li>

				<li class="nav-item dropdown "><a
					class="nav-link dropdown-toggle text-info" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						Car Category </a>
					<ul class="dropdown-menu bg-dark p-3" aria-labelledby="navbarDropdown">
						<li><a class="border-bottom border-info dropdown-item text-info" href="car?brand=toyota"> Toyota</a></li>
						<li><a class="border-bottom border-info dropdown-item text-info" href="car?brand=ford"> Ford</a></li>
						<li><a class="border-bottom border-info dropdown-item text-info" href="car?brand=bmw"> Bmw</a></li>
						<li><a class="border-bottom border-info dropdown-item text-info" href="car?brand=honda"> Honda</a></li>
						
						<li><a class="dropdown-item text-info" href="car?brand=nissan"> Nissan</a></li>
					</ul></li>

				<c:if test="${fn:contains(user.role,'ROLE_ADMIN')}">
					<li class="nav-item"><a class="nav-link text-info" href="buyinglist">BuyingList</a>
				</c:if>
				</li>
				<c:if test="${fn:contains(user.role,'ROLE_ADMIN')}">
					<li class="nav-item"><a class="nav-link text-info" href="car?mode=SHOW_FORM">Add Car</a>
				</c:if>
				<li class="nav-item"><a class="nav-link text-info"
					href="login?mode=LOGOUT">LogOut</a></li>
			</ul>

		</div>
	</div>
</nav>