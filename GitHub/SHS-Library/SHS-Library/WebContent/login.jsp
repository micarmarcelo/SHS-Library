
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <title>SHS Library Reservation System</title>
        
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import .css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="css/login-style.css"/>
        
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    </head>
    
    <body>
        <div class="row">
            
            <div class="col s6 l8 register-container">
                <div class="logo-container">
                    <img id="dlsu-logo" src="res/dlsu-logo.png">
                    <div class="dlsu-text"><font size="3">De La Salle University - Manila</font><br><font size="2">Senior High School</font></div>
                </div>
                
                <h3>Welcome</h3>
                
                <h5 style="color: lightgray;">Register for an SHS library account here.</h5>
                
                <br>
                
                <h6 style="color: lightgray;">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</h6>
                
                <br><br>
                
                <a href="register.jsp" class="btn waves-effect waves-green btn-register">Register Here</a>
               <!--  <button  name="action">Register Here</button> -->
                
            </div>

            <div class="col s6 l4 grey lighten-4 login-container">
                <div class="row">
                    <h5>Or login to your account</h5>
                    
                    <br>
                    <form action = "LogInServlet" method = "post" style = "margin-right:20px;">
                    <div class="input-field username">
                        <input id="email" name="email" type="text" class="validate">
                        <label for="email">Email</label>
                    </div>
                    
                    <div class="input-field password">
                        <input id="password" name="password" type="password" class="validate">
                        <label for="password">Password</label>
                    </div>
                    
                    <h6>Forgot your password? <a id="forgot-password">Click here.</a></h6> 
                    
                    <br>
                    
                    <button class="btn waves-effect waves-green btn-login" type="submit" name="action">Login</button>
                    </form>
                </div>
            </div>

        </div>
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
</html>