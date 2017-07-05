<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head>
        <title>ADMIN - SHS Library Reservation System</title>
        
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import .css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="css/main-style.css"/>
        <link type="text/css" rel="stylesheet" href="css/admin-style.css"/>
        
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
        
        <div class="container">
            <!--Administrator Action Tabs-->
            <div class="row">
                <div class="col s12 action-tab">
                  <ul class="tabs">
                    <li class="tab col s6"><a href="#test1">Create Library Manager/Staff account</a></li>
                    <li class="tab col s6"><a href="#test3">Unlock account</a></li>
                  </ul>
                </div>
            </div>
            <div id="test1">
                <div class="tab-containerdivs">
                <form action="CreateStaffServlet" method="post">
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
                        <div class="input-field col s6">
                            <input placeholder="sample@dlsu.edu.ph" id="email" name="email" type="email" class="validate" required>
                            <label for="email">Email</label>
                        </div>
                     
                        <div class="col s6">
                            <div class="row" id="user_type">
                                <div class="col s6">
                                    <input name="type" type="radio" value="manager" id="manager" />
                                    <label for="manager">Library Manager</label>
                                </div>
                                <div class="col s6">
                                    <input name="type" type="radio" value="staff" id="staff" />
                                    <label for="staff">Library Staff</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s5">
                            <input id="password" type="password" name="password" 	class="validate" maxlength="8" required>
                            <label for="email">Password</label>
                        </div>
                        <i id="password_information" class="material-icons prefix col s1">information</i>
                        <div class="input-field col s6">
                            <input id="re-enter_password" type="password" class="validate" required>
                            <label for="email">Re-enter Password</label>
                        </div>
                    </div>
                </div>

                <button id="btn-create_user" class="btn waves-effect waves-light" type="submit" name="action">Create User Account</button>
           </form>
            </div>
            
        </div>
        
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
    
    </body>

</html>