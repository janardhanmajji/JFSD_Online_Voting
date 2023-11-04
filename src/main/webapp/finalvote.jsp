<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>VOTE</title>
    <link rel="stylesheet" type="text/css" href="./css/viewallvoters.css" />
</head>
<body>
<%@ include file="voternavbar.jsp" %>
<section>
    <!--for demo wrap-->
    <h1>VOTE</h1>

    <form action="saveParty" method="post">
    <div class="tbl-content">
        <table border="1">
            <thead>
                <tr>
                 <th>Select</th>
                    <th>Party Name</th>
                    <th>Party Leader</th>
                    <!-- Add more columns as needed -->
                   
                </tr>
            </thead>
       
            <tbody>
                <c:forEach var="candidate" items="${candidatedata}">
                    <tr>
                    <td><input type="radio" name="selectedparty" value="${candidate.party_name}" /></td>
                        <td>${candidate.party_name}</td>
                        <td>${candidate.candidate_name}</td>
                        <!-- Add more columns as needed -->
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
         </div>

        <br>

        <input class="submit" type="submit" value="Submit Vote">
    </form>
</section>
</body>
</html>
