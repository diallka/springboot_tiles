<!-- A rajouter pour activer formulaire Spring -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Veuillez vous inscrire</title>
</head>
<body>


          
	<h3>Inscription nouvel utilisateur</h3>
	
<%-- 							action="${pageContext.request.contextPath}/${lienSenregistrer}"  --%>
<c:url var="InscriptionUrl" value="/inscription" />
	<form:form action="${InscriptionUrl}" method="post" modelAttribute="user">
		<table>
			<tr>
<!-- 				path "id", valeur recuperée du modelAttribute -->
				<form:hidden path="id" />
				<td><form:label path="lastName">Nom</form:label></td>
				<td><form:input path="lastName" placeholder="saisir nom..." /></td>
			</tr>
			<tr>
				<td><form:label path="firstName">Prenom</form:label></td>
				<td><form:input path="firstName" placeholder="saisir prenom..." /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="age">Age</form:label></td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td><form:label path="country">Pays</form:label></td>
				<td><form:input path="country" /></td>
			</tr>
			<tr>
				<td><form:label path="latitude">Latitude</form:label></td>
				<td><form:input path="latitude" /></td>
			</tr>
			<tr>
				<td><form:label path="longitude">Longitude</form:label></td>
				<td><form:input path="longitude" /></td>
			</tr>
			<tr>
				<td><form:label path="ssoId">Identifiant</form:label></td>
				<td><form:input path="ssoId"
								placeholder="saisir identifiant..." /></td> 
			</tr>
			<tr>
				<td><form:label path="password">Mot de passe</form:label></td>
				<td><form:password path="password" placeholder="saisir mot de passe..." /></td>
			</tr>
<!-- 			autorise les metodes POST -->
			<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
			<tr>
			<td><input type="submit" value="valider"/></td>
			</tr>

		</table>
	</form:form>
	

</body>
</html>