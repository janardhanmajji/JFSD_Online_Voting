<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vote Page</title>
    <link rel="stylesheet" href="./css/add.css" />
</head>
<body>
    <%@ include file="voternavbar.jsp" %>
    <div id="main">
        <section class="container">
            <form method="post" action="finalvote" class="form" >
                <div class="input-box">
                    <label for="electionDropdown">Select Election:</label>
                    <select id="electionDropdown" name="selectedElection">
                        <c:forEach var="option" items="${options}">
                            <option value="${option.id}">${option.name}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <button type="submit">Continue</button>
            </form>
        </section>
    </div>
</body>
</html>
