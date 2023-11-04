<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Admin Login</title>
    <link rel="stylesheet" href="./css/login_signup_style.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    />
  </head>

  <body>
    <div class="wrapper">
    <span class="blink">
	<h3 align=center style="color:red">${message}</h3>
	</span>
      <header>Admin Login</header>
      <form method="post" action="checkadminlogin">
        <div class="field email">
          <div class="input-area">
            <input name="username" type="text" placeholder="UserName" />
            <i class="icon fas fa-envelope"></i>
            <i class="error error-icon fas fa-exclamation-circle"></i>
          </div>
        </div>
        <div class="field password">
          <div class="input-area">
            <input name="password" type="password" placeholder="Password" />
            <i class="icon fas fa-lock"></i>
            <i class="error error-icon fas fa-exclamation-circle"></i>
          </div>
        </div>

        <input type="submit" value="Login" required />
      </form>
    </div>
  </body>
</html>
