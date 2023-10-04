<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%>
    <%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="common/header.html"/> 
<meta charset="ISO-8859-1">
<title>Buying List</title>
<link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css">
         <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
         <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
         <script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>
</head>
<body>
	<c:import url="common/nav.jsp"/>
	<div class="container mt-5 p-5">
                <table id="example" class="table table-striped" style="width:100%">
                    <thead>
                        <tr>
                            <th>Email</th>
                            <th>Model</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="buylist" items="${buyingList }">
                        <tr>
                            <td>${buylist.email }</td>
                            <td>${buylist.model }</td>
                            
                        </tr>
                        </c:forEach>
                        
                    </tbody>
                    <tfoot>
                        <tr>
                            <th>Email</th>
                            <th>Model</th>

                        </tr>
                    </tfoot>
                </table>
           
        </div>
        <!-- Bootstrap core JS-->
        <c:import url="common/footer.html"/>

        <script>
            $(document).ready(function () {
                 $('#example').DataTable();
            });
        </script>

</body>
</html>