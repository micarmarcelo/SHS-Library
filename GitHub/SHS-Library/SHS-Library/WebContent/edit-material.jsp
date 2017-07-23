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
                    <li><a href="#literary-materials-container" id="literary-materials">Literary Materials</a></li>
                    <li><a href="#reserve-rooms-container" id="reserve-rooms">Rooms</a></li>
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
        
        <div class="container">          
              <h5>Edit</h5>
              
              <div class="row">
                    <div class="col s12">
                        <input id="title" type="text" class="validate" value="${material.title }">
                        <label for="title">Title</label>
                    </div>
              </div>
              <div class="row">
                    <div class="col s6">
                        <input id="author" type="text" class="validate" value="<%=request.getAttribute("author") %>">
                        <label for="author">Author/s</label>
                    </div>
                    <div class="col s6">
                        <input id="publisher" type="text" class="validate" value="<%=request.getAttribute("publisher") %>">
                        <label for="publisher">Author/s</label>
                    </div>
              </div>
              <div class="row">
                    <div class="col s2">
                        <input id="year" type="number" class="validate" value="<%=request.getAttribute("year") %>">
                        <label for="year">Year</label>
                    </div>
                    <div class="col s4">
                        <input id="location" type="text" class="validate" value="<%=request.getAttribute("location") %>">
                        <label for="location">Location</label>
                    </div>
                    <div class="col s3">
                        <label>Status</label>
                        <select class="browser-default status">
                            <option value="" disabled selected>Select Status</option>
                            <option value="1" selected="selected">Available</option>
                            <option value="2">Not Available</option>
                        </select>
                    </div>
                    <div class="col s3">
                        <label>Category</label>
                        <select class="browser-default status">
                            <option value="" disabled selected>Select Category</option>
                            <option value="1" selected="selected">Book</option>
                            <option value="2">Thesis</option>
                            <option value="2">Magazine</option>
                        </select>
                    </div>
              </div>
              <div class="row">
                    <div class="col s12">
                        <input id="tags" type="text" class="validate" value="<%=request.getParameter("tags") %>">
                        <label for="tags">Tag/s</label>
                    </div>
              </div>
                <br>
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat" style="background-color: #00330e; color: white;">Save</a>
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat" style="background-color: #00330e; color: white;">Cancel</a>
            </div>

        
 
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>

    </body>

</html>