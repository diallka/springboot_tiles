<!-- A rajouter pour activer formulaire Spring -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Veuillez vous inscrire</title>
</head>
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
	<h3>Inscription nouvel utilisateur</h3>
	
							<!-- action="${pageContext.request.contextPath}/${lienSenregistrer}"  -->
	<form:form method="post" modelAttribute="util">
		<table>
			<tr>
				<!-- path "id", valeur recuper�e du modelAttribute -->
				<form:hidden path="id" />
				<td><form:label path="nom">Nom</form:label></td>
				<td><form:input path="nom" placeholder="saisir nom..." /></td>
			</tr>
			<tr>
				<td><form:label path="prenom">Prenom</form:label></td>
				<td><form:input path="prenom" placeholder="saisir prenom..." /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="login">Identifiant</form:label></td>
				<td><form:input path="login"
						placeholder="saisir identifiant..." /></td>
			</tr>
			<tr>
				<td><form:label path="mdp">Mot de passe</form:label></td>
				<td><form:password path="mdp" placeholder="saisir mot de passe..." /></td>
			</tr>
			<tr>
			<td><input type="submit" value="${lienSenregistrer}"/></td>
			</tr>

		</table>
	</form:form>
	
	  </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
  
</body>
</html>