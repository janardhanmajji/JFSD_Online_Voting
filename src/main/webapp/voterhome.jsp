<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Voter Home</title>
 <style>
     

      .card {
        background-color: #3498db;
        margin-left:20%;
        align-items: center;
        justify-content: center;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        overflow: hidden;
        width: 300px;
        text-align: center;
        color: #fff;
        transition: background-color 0.3s ease, transform 0.3s ease; /* Added transform for scaling effect */
      }

      .card:hover {
        background-color: #2980b9;
        transform: scale(1.05); /* Scale the card on hover */
      }

      .card h1 {
        margin-bottom: 10px;
        font-size: 1.8em;
      }

      .card h2 {
        margin-bottom: 10px;
        font-size: 1.5em;
      }

      .card p {
        margin: 5px 0;
        font-size: 1.2em;
      }
    </style>
</head>
<body>
	<%@ include file="voternavbar.jsp" %>
	<div style = "padding-top: 10px;padding-right: 10px;">
	<p style="text-align: right;font-size: 15pt">Hi ${vname}</p>
	</div>
	
	 <div class="card">
      <h1 style="color:Black;">Personal Information</h1>
      <p>Name: ${vname}</p>
      Contact: ${voter.contact}
      <p>City: Example City</p>
      <p>Country: Example Country</p>
      <p>Contact: +123456789</p>
      <p>City: Example City</p>
      <p>Country: Example Country</p>
    </div>
</body>
</html>