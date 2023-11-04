<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="./css/add.css" />
</head>
<body>
<%@ include file="adminnavbar.jsp" %>
<div id="main">
    <section class="container">
     
      <header>Add Election</header>
      <form method="post" action="insertelection" class="form">
        <div class="input-box">
          <label>Election Name</label>
          <input name="electionname" type="text" placeholder="Enter Election name" required />
        </div>
        
        <button>Submit</button>
      </form>
    </section>
     </div>
</body>
</html>