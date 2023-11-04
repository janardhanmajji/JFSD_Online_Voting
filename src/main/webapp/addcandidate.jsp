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
      <form method="post" action="insertcandidate" class="form" enctype="multipart/form-data">
        <div class="input-box">
          <label>Full Name</label>
          <input name="name" type="text" placeholder="Enter full name" required />
        </div>
        
        <div class="gender-box">
          <h3>Gender</h3>
          <div class="gender-option">
            <div class="gender">
              <input type="radio" value="MALE" id="check-male" name="gender" checked />
              <label for="check-male">male</label>
            </div>
            <div class="gender">
              <input type="radio" value="FEMALE" id="check-female" name="gender" />
              <label for="check-female">Female</label>
            </div>
            <div class="gender">
              <input type="radio" value="OTHERS" id="check-other" name="gender" />
              <label for="check-other">prefer not to say</label>
            </div>
          </div>
        </div>
        
         <div class="input-box">
            <label>Birth Date</label>
            <input type="date" name="dob" placeholder="Enter birth date" required />
          </div>

        <div class="input-box">
          <label>Party Name</label>
          <input type="text" name="partyname" placeholder="Enter Party Name" required />
        </div>
        
        <div class="input-box">
          <label>Location</label>
          <input type="text" name="location" placeholder="Enter Location" required />
        </div>
        
         <div class="input-box">
            <label>Party Symbol</label>
            <input type="file" id="myFile" name="productimage">
          </div> 
          
        
        
        <button>Submit</button>
      </form>
    </section>
     </div>
  </body>
 
</html>