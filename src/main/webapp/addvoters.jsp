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
  <%@ include file="adminnavbar.jsp" %>
  <div id="main">
    <section class="container">
     
      <header>Add Voter</header>
      <form method="post" action="insertvoter" class="form">
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
          <label>Email Address</label>
          <input type="text" name="email" placeholder="Enter email address" required />
        </div>
        
        <div class="input-box">
          <label>Password</label>
          <input type="password" name="pwd"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"  placeholder="Enter password" required />
        </div>
        
        <div class="input-box">
          <label>Location</label>
          <input type="text" name="location" placeholder="Enter Location" required />
        </div>

          <div class="input-box">
            <label>Phone Number</label>
            <input type="number" name="contact" pattern="[789][0-9]{9}" placeholder="Enter phone number" required />
          </div>
        
        
           <div class="gender-box">
          <h3>Status</h3>
          <div class="gender-option">
            <div class="gender">
              <input type="radio" id="check-active" name="status" value="Active" />
              <label for="check-active">Enable</label>
            </div>
            <div class="gender">
              <input type="radio" id="check-na" name="status" value="inactive" />
              <label for="check-na">Disable</label>
            </div>
          </div>
        </div>
        
        <button>Submit</button>
      </form>
    </section>
     </div>
  </body>
 
</html>