<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Voter</title>
<link rel="stylesheet" type="text/css" href="./css/viewallvoters.css" />

</head>
<body>
<%@ include file="adminnavbar.jsp" %>
	<section>
  <!--for demo wrap-->
  <h1>VOTERS LIST</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>ID</th>
          <th>NAME</th>
          <th>LOCATION</th>
          <th>CONTACT</th>
          <th>ACTION</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
      <c:forEach items="${voterdata}"  var="voter"> 
        <tr>
          <td><c:out value="${voter.id}" /></td>
          <td><c:out value="${voter.name}" /> </td>
          <td><c:out value="${voter.location}" /></td>
          <td><c:out value="${voter.contact}" /></td>
          <td>
			<a href='<c:url value="deletevoter/${voter.id}"></c:url>'>Delete</a>
		  </td>
		  </tr>
        </c:forEach> 
      </tbody>
    </table>
  </div>
</section>



</body>
</html>