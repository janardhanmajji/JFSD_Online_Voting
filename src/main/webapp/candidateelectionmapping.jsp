<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 

<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <!--<title>Registration Form in HTML CSS</title>-->
    <!---Custom CSS File--->
    <link rel="stylesheet" href="./css/add.css" />
  </head>
  <body>
  <%@ include file="adminnavbar.jsp" %>
  <div id="main">
    <section class="container">
     
      <header>Add Candidate</header>
      <form method="post" action="candidateelectionmappinginsert" class="form">
       
		        
		        <div class="input-box">
		    <label for="electionDropdown">Select Election:</label>
		    <select name="eid" required="required">
		        <option value="">--Select--</option>
		        <c:forEach var="e" items="${electiondata}">
		            <option value="${e.id}">${e.name}</option>
		        </c:forEach>
		    </select>
		</div>
		
		<div class="input-box">
		    <label for="candidateDropdown">Select Candidate:</label>
		    <select name="cid" required="required">
		        <option value="">--Select--</option>
		        <c:forEach var="c" items="${candidatedata}">
		            <option value="${c.id}">${c.candidate_name}</option>
		        </c:forEach>
		    </select>
		</div>

        
        <button>Submit</button>
      </form>
    </section>
     </div>
  </body>
 
</html>