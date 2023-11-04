<!DOCTYPE html>
<!---Coding By CodingLab | www.codinglabweb.com--->
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
  <%@ include file="voternavbar.jsp" %>
  <div id="main">
    <section class="container">
     
      <header>Update Voter</header>
      <form method="post" action="voterupdate" class="form">
        <div class="input-box">
          <label>Full Name</label>
          <input name="name" type="text" required="required" value="${v.name}" />
        </div>
        
         <div class="input-box">
            <label>Birth Date</label>
            <input type="date" name="dob" required="required" value="${v.dateofbirth}" />
          </div>

        <div class="input-box">
          <label>Email Address</label>
          <input type="text" name="email" required="required" value="${v.email}" />
        </div>
        
        <div class="input-box">
          <label>Password</label>
          <input type="password" name="pwd" required="required" value="${v.password}" />
        </div>
        
        <div class="input-box">
          <label>Location</label>
          <input type="text" name="location" required="required" value="${v.location}" />
        </div>

          <div class="input-box">
            <label>Phone Number</label>
            <input type="number" name="contact" required="required" value="${v.contact}" />
          </div>
        
        <button>Submit</button>
      </form>
    </section>
     </div>
  </body>
 
</html>