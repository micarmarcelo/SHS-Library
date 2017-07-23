<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head>
        <title>SHS Library Reservation System</title>
        
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import .css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="css/material-details-style.css"/>
        
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

                 <ul id="nav-mobile" class="right">
                    <li>
                        <select class="browser-default">
                           <option value="" disabled selected>Search by: </option>
                           <option value="1">Author</option>
                           <option value="2">Title</option>
                           <option value="3">Publisher</option>
                       </select>
                    </li>
                    <li>
                        <div class="row">
                            <div class="input-field col s12">
                              <input id="last_name" type="text" class="validate">
                              <label for="last_name">Search</label>
                            </div>
                        </div>                     
                    </li>
                    <li><a href="badges.html">Literary Materials</a></li>
                    <li><a href="collapsible.html">Rooms</a></li>
                    <li>
                        <!-- Dropdown Trigger -->
                        <a class='dropdown-button' href='#' data-activates='dropdown1'><i class="material-icons prefix">settings</i></a>

                          <!-- Dropdown Structure -->
                        <ul id='dropdown1' class='dropdown-content'>
                            <li><a href="#!">Edit Profile</a></li>
                            <li><a href="login.html">Logout</a></li>
                        </ul> 
                    </li>
                </ul>

            </div>
        </nav>
        
        <!--Main-->
        <div class="container grey lighten-4" style="padding: 20px;">
            <div class="row">
                        <div class="col s1 center">
                            <img class="material-icon" src="res/magazine.png">
                            <p class=""><b>Magazine</b></p>
                        </div>
                        <div class="col s7">
                         
                        
                        	
                            <a id=${material.title }><b>${material.title }</b></a>
                            <p><b>Author/s: </b>${material.author}</p>
                            <p><b>Publisher/s: </b>${material.publisher}</p>
                            <p><b>Year: </b>2013</p>
                            <br>
                            <p><b>Location: </b><i>${material.location }</i></p>
                            <p><b>Tags: </b> <i> ${material.tags }</i></p>
                          <span style="display: flex;">
                            <p><b>Status: &nbsp;</b></p> 
                            <p id="status" style="color: red;"><b>${material.status}</b></p>
                            
                          </span>
                          <p><b>Date of Availability: </b><i>${material.availableDate}</i></p>
                        </div>
                        <div class="col s4">
                            <a class="waves-effect waves-light btn" href="#reserve-modal">Reserve</a>
                            <a class="waves-effect waves-light btn" href="#review-modal">Review Material</a>
                        </div>
            </div>
            
            <h6><b>Reviews:</b></h6>
            <p><b>Clarisse Cheng: </b>This is review #1.</p>
            <p><b>Micaella Marcelo: </b>This is review #2.</p>
        </div>
        
         <!--Reservation Modal Structure -->
          <div id="reserve-modal" class="modal">
            <div class="modal-content">
              <h4>Reserve Material</h4>
              <p>Are you sure you want to reserve material?</p>
            </div>
            <div class="modal-footer">
              <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Yes</a>
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">No</a>
            </div>
          </div>
        
        <!--Review Modal Structure -->
          <div id="review-modal" class="modal">
            <div class="modal-content">
              <h4>Review Material</h4>
              <div class="row">
                <form class="col s12" action="ReviewServlet" method="POST">
                  <div class="row">
                    <div class="input-field col s12">
                      <textarea id="textarea1" name="message" class="materialize-textarea"></textarea>
                      <input type="hidden" name="materialID" value="${material.materialID}">
                      <input name = "email" type="hidden" value= "${email}"/>
                      
                      <label for="textarea1">Write a review</label>
                    </div>
                  </div>
                  
                  <div class="modal-footer">
		              <button class="modal-action modal-close waves-effect waves-green btn-flat" type="submit" name="action">OK</button>
		                <button class="modal-action modal-close waves-effect waves-green btn-flat">Cancel</button>
		            </div>
		            
		           
                </form>
              </div>
            </div>
            
          </div>
        
        
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script>
            $(document).ready(function(){
                // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
                $('.modal').modal();
              });
        </script>
    </body>

</html>