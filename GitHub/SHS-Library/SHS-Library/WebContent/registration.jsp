<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        
        <!--Registration Container-->
        <div class="container">
            <h5>Create an account</h5>
            <div class="registration-container">
            <form action="RegisterServlet" method="post">
                <div class="row">
                    <div class="input-field col s5">
                      <input placeholder="Juan" id="first_name" name="first_name" type="text" class="validate" required>
                      <label for="first_name">First Name</label>
                    </div>
                    <div class="input-field col s5">
                      <input placeholder="Dela Cruz" id="last_name" name="last_name"  type="text" class="validate" required>
                      <label for="last_name">Last Name</label>
                    </div>
                    <div class="input-field col s2">
                      <input placeholder="A." id="middle_initial" name="middle_initial" type="text" class="validate" required>
                      <label for="last_name">Middle Initial</label>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col s6">
                        <input placeholder="Birthdate" id="birthday" name="birthday" type="date" class="datepicker">
                    </div>
                    <div class="col s6">
                        <div class="row" name="user_type" id="user_type">
                            <div class="col s6">
                                <input type="radio" name="type" value="student" id="student" />
                                <label for="student">Student</label>
                            </div>
                            <div class="col s6">
                                <input type="radio" name="type" value="employee" id="faculty" />
                                <label for="faculty">Faculty</label>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="input-field col s6">
                        <input placeholder="11xxxxxx" id="es_number" name="es_number" type="text" class="validate" onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="8" required>
                        <label for="es_number">ID Number</label>
                    </div>
                    <div class="input-field col s6">
                        <input placeholder="sample@dlsu.edu.ph" id="email" name="email" type="email" class="validate" required>
                        <label for="email">Email</label>
                    </div>
                </div>
                
                <div class="row">
                    <div class="input-field col s5">
                        <input id="password" name="password" type="password" class="validate" maxlength="16" required>
                        <label for="password">Password</label>
                    </div>
                    <i id="password_information" class="material-icons prefix col s1">information</i>
                    <div class="input-field col s6">
                        <input id="re-enter_password" type="password" class="validate" required>
                        <label for="email">Re-enter Password</label>
                    </div>
                </div>
                
                <label>Security Question 1</label>
                <select class="browser-default" name="id_question1" id="id_question1">
                    <option value="" disabled>Choose your option</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <div class="input-field col s12">
                  <input name="answer_question1" id="answer_question1" type="text" class="validate">
                  <label for="answer_question1">Answer for Security Question 1</label>
                </div>
                <label>Security Question 2</label>
                <select class="browser-default" name="id_question2" id="id_question2">
                    <option value="" disabled >Choose your option</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <div class="input-field col s12">
                  <input name="answer_question2" id="answer_question2" type="text" class="validate">
                  <label for="security_question2">Answer for Security Question 2</label>
                </div>
            </div>
            <button id="btn-register" class="btn waves-effect waves-light" type="submit" name="action">Register</button>
        </form>
        </div>
        
        
        
        
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script>
            $('#first_name').on('keypress', function (event) {
                var regex = new RegExp("^[a-zA-Z0-9]+$");
                var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
                if (!regex.test(key)) {
                   event.preventDefault();
                   return false;
                }
            });
            
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15 // Creates a dropdown of 15 years to control year
              });
        </script>
    </body>

</html>