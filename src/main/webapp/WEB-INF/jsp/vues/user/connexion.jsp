<!-- A rajouter pour activer formulaire Spring -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE HTML>
<html><head><meta charset="UTF-8"><title>Spring MVC - Tutorial 1: Data List</title></head>
<body>
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
	<h3>Authentification</h3>
	
	<form:form method="post" modelAttribute="util">
		<table>
				<td><form:label path="login">Identifiant</form:label></td>
				<td><form:input path="login"
						placeholder="saisir identifiant..." /></td>
			</tr>
			<tr>
				<td><form:label path="mdp">Mot de passe</form:label></td>
				<td><form:password path="mdp" placeholder="saisir mot de passe..." /></td>
			</tr>
			<tr>
			<td><input type="submit" value="${lienSeconnecter}"/></td>
			</tr>

		</table>
	</form:form>
	
	  </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
</body>
</html>