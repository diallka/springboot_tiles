<!-- A rajouter pour activer formulaire Spring -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Taglig pour la jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  <div id="page-wrapper">
  			<br/>
            <!-- Page Heading -->
			<div class="row">
				<div class="col-lg-12" align="center">
						<ol class="breadcrumb">
							<li class="active  text-uppercase"><i class="fa fa-dashboard"></i> dashboard Map</li>
						</ol>
				</div>
			</div>
          
            <c:forEach items="${utilisateurs}" var="util">
			<table border="1">
				<tr>
					<td>${util.nom}</td>
					<td> ${util.prenom}</td>
					<td> ${util.email}</td>
					<td><a href="${pageContext.request.contextPath}/modifier?id=${util.id}">Modifier</a></td>
					<td><a href="${pageContext.request.contextPath}/supprimer/${util.id}">Supprimer</a></td>
				</tr>
			</table>
		</c:forEach>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
  

  
