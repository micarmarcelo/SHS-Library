<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head>
        <title>SHS Library Reservation System</title>
        
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import .css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="css/main-style.css"/>
        <link type="text/css" rel="stylesheet" href="css/registration-style.css"/>
        
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    
    <body>
        <!--Header-->
        <nav>
            <div class="nav-wrapper">
                <div class="logo-container">
                    <img id="dlsu-logo" src="res/dlsu-logo.png">
                    <div class="dlsu-text">
                        <font size="3"><span>De La Salle University - Manila</span></font>
                        <font size="2"><span>SHS Library Reservation System</span></font>
                    </div>
                </div>
            </div>
        </nav>
        
        <!--Forgot Password Container-->
        <div class="container">
            <h5>Forgot Password</h5>
            <h6>Enter the email address associated with your account to reset your password.</h6>
 
            <div class="row">
                <div class="input-field col s6">
                        <input placeholder="sample@dlsu.edu.ph" id="email" type="email" class="validate" required>
                        <label for="email">Email</label>
                </div>
            </div>
        </div>
        
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>

</html>