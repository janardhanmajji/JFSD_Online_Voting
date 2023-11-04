<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CANDIDATES LIST</title>
<link rel="stylesheet" type="text/css" href="./css/viewallvoters.css" />

</head>
<body>
<%@ include file="adminnavbar.jsp" %>
	<section>
  <!--for demo wrap-->
  <h1>CANDIDATES LIST</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>ID</th>
          <th>Candidate NAME</th>
          <th>Party Name</th>
          <th>Gender</th>
          <th>Location</th>
          <th>Image</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
      <c:forEach items="${candidatedata}"  var="cd"> 
        <tr>
          <td><c:out value="${cd.id}" /></td>
          <td><c:out value="${cd.candidate_name}" /> </td>
          <td><c:out value="${cd.party_name}" /> </td>
          <td><c:out value="${cd.gender}" /></td>
          <td><c:out value="${cd.location}" /></td>
          <td>
          <img src='displayprodimage?id=${cd.id}' width="40%" height="40%"> 
          </td>
        </tr>
        </c:forEach> 
      </tbody>
    </table>
  </div>
</section>



</body>
</html>