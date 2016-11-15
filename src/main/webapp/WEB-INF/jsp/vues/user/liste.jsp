<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <div id="page-wrapper">
<h1>Liste Utilisateurs</h1>

${liste}
<br/>
	<c:forEach items="${liste}" var="user">
		${user.lastName } <br/>
	</c:forEach>
</div>