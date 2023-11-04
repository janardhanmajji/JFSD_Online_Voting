<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Vote Count</title>
    <link rel="stylesheet" type="text/css" href="./css/votecount.css" />
</head>
<body>
    <%@ include file="adminnavbar.jsp" %>
    <div id="main">
        <section class="container">
            <h2>Vote Count</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>Candidate Name</th>
                        <th>Vote Count</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="voteCount" items="${voteCountList}">
                        <tr>
                            <td>${voteCount[0]}</td> <!-- Assuming voteCount[0] contains the candidate name -->
                            <td>${voteCount[1]}</td> <!-- Assuming voteCount[1] contains the vote count -->
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <c:set var="maxVotes" value="${0}" />
            <c:set var="winnerParty" value="" />

            <c:forEach var="voteCount" items="${voteCountList}">
                <c:if test="${voteCount[1] > maxVotes}">
                    <c:set var="maxVotes" value="${voteCount[1]}" />
                    <c:set var="winnerParty" value="${voteCount[0]}" />
                </c:if>
            </c:forEach>

            <p>The party with the highest votes is ${winnerParty} with ${maxVotes} votes!</p>
        </section>
    </div>
</body>
</html>
