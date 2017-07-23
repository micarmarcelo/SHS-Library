<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <script src="js/jquery-3.0.0.min.js"></script>
        <script>	
			$(document).ready(function(){
				$("a.delete-icon").click(function(){
					// get id of the clicked material
					var materialID = $(this).attr("id");
					// set value of hidden input to the id
					$('#hiddeninput-material').val(materialID);
					
					// submit form automatically
					$('#delete-material-form').submit();

				});
				
			});
		</script> 
		
		<script>	
			$(document).ready(function(){
				$("a.edit-icon").click(function(){
					// get id of the clicked material
					var materialID = $(this).attr("id");
					// set value of hidden input to the id
					$('#hiddeninput-material').val(materialID);
					
					// submit form automatically
					$('#edit-material-form').submit();

				});
				
			});
		</script> 
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
                    <form action = "SearchServlet" method = "post">
                    <li>
                        <select name="filter" class="browser-default">
                           <option value="" disabled selected>Search by: </option>
                           <option value="1">Author</option>
                           <option value="2">Title</option>
                           <option value="3">Publisher</option>
                       </select>
                    </li>
                    <li>
                        <div class="row">
                            <div class="input-field col s12">
                              <input id="search" name="search" type="text" class="validate">
                              <label for="search">Search</label>
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
                            <li><a href="LogOutServlet">Logout</a></li>
                        </ul> 
                    </li>
                    <input type = "hidden" name="userType" value="<%= session.getAttribute("type") %>">
                    </form>
                </ul>

            </div>
        </nav>
        
        <!--Main-->
        <div id="literary-materials">
            <!--Filter-->
            <div class="row filter-container">
                <div class="col s1">
                    <p>Categories: </p>
                </div>
                <div class="col s4">
                    <form action="#" name="filter-form">
                        <div class="row">
                            <div class="col s4">
                                <p>
                                  <input type="checkbox" id="books" />
                                  <label for="books">Books</label>
                                </p>
                            </div>
                            <div class="col s4">
                                <p>
                                  <input type="checkbox" id="magazines"/>
                                  <label for="magazines">Magazines</label>
                                </p>
                            </div>
                            <div class="col s4">
                                <p>
                                  <input type="checkbox" id="thesis"/>
                                  <label for="thesis">Thesis</label>
                                </p>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <!--Books/Magazines/Thesis/etc-->
            <div class="container">
                <div class="row  materials-container">


                    <!--Sample of Available Book Material-->
                    <c:forEach var = "c" items = "${material}">
                    <div class="col s12">
                        <div class="row grey lighten-4 material-container">
                            <div class="col s1 material-type center">
                                <img class="material-icon" src="res/book.png">
                                <p class=""><b>Book</b></p>
                            </div>
                            <div class="col s8">
                                <a id="item1"><b>${c.title}</b></a>
                                <p><b>Author/s: </b>${c.author }</p>
                                <p><b>Publisher/s: </b>${c.publisher}</p>
                                <p><b>Year: </b>2016</p>
                                <br>
                                <p><b>Location: </b><i>123.456; A123c</i></p>
                                <p><b>Tags: </b> <i>text rdacontent, computer rdamedia, computer disc rdacarrier, stock market</i></p>
                                <span style="display: flex;">
                                <p><b>Status: &nbsp;</b></p> 
                                <p id="status" style="color: green;"><b>Available</b></p>
                              </span>
                              <p><b>Reservation Date: </b>June 3, 2017</p>
                              <p><b>Return Date: </b>June 10, 2017</p>
                            </div>
                            <div class="col s1">
                                <a id="${c.materialID }" class="edit-icon" href="editMaterial.jsp"><i class="material-icons">mode_edit</i></a>
                            </div>
                            
                            <div class="col s1">
                                <a id="${c.materialID }" class="delete-icon" href="#delete1"><i class="material-icons">delete</i></a>
                            </div>
                        </div>
                    </div>
                    </c:forEach>

                    <!--Sample for Unavailable Thesis Material-->
                    <!-- <div class="col s12">
                        <div class="row grey lighten-4 material-container">
                            <div class="col s1 material-type center">
                                <img class="material-icon" src="res/thesis.png">
                                <p class=""><b>Thesis</b></p>
                            </div>
                            <div class="col s8">
                                <a id="item2"><b>Computer aided system for sheet metal pattern development application : an object-oriented approach</b></a>
                                <p><b>Author/s: </b>Salvador, Florante</p>
                                <p><b>Publisher/s: </b>Peradilla, Marnel</p>
                                <p><b>Year: </b>1990</p>
                                <br>
                                <p><b>Location: </b><i>123.456; A123c</i></p>
                                <p><b>Tags: </b> <i>Computer design and construction, Computer systems, Computer-aided design, 	Computer input-output equipment -- Design -- Data processing</i></p>
                              <span style="display: flex;">
                                <p><b>Status: &nbsp;</b></p> 
                                <p id="status" style="color: red;"><b>Not Available</b></p>
                              </span>
                              <p><b>Date of Availability: </b>June 23, 2017</p>
                            </div>
                            <div class="col s1">
                                <a id="edit1" class="edit-icon" href="#edit1"><i class="material-icons">mode_edit</i></a>
                            </div>
                            <div class="col s1">
                                <a id="delete2" class="delete-icon" href=""><i class="material-icons">delete</i></a>
                            </div>
                        </div>
                    </div>    -->
                    
                </div>        
            </div>
        </div>
         
        
        
        <a class="btn-floating btn-large waves-effect waves-light red btn-add" href="#add"><i class="material-icons">add</i></a>
        
        <!-- Add Material Modal Structure -->
          <div id="add" class="modal">
            <div class="modal-content">
              <h5>Add</h5>
              <form action="AddMaterialServlet" method="POST">
              <div class="row">
                    <div class="col s12">
                        <input id="title" name="title" type="text" class="validate">
                        <label for="title">Title</label>
                    </div>
              </div>
              <div class="row">
                    <div class="col s6">
                        <input id="author" name="author" type="text" class="validate">
                        <label for="author">Author/s</label>
                    </div>
                    <div class="col s6">
                        <input id="publisher" name="publisher" type="text" class="validate">
                        <label for="publisher">Publisher/s</label>
                    </div>
              </div>
              <div class="row">
                    <div class="col s2">
                        <input id="year" type="number" name="year" class="validate">
                        <label for="year">Year</label>
                    </div>
                    <div class="col s4">
                        <input id="location" type="text" name="location" class="validate">
                        <label for="location">Location</label>
                    </div>
                    <div class="col s3">
                        <label>Status</label>
                        <select name="status" class="browser-default status">
                            <option value="" disabled selected>Select Status</option>
                            <option value="Available">Available</option>
                            <option value="Not Available">Not Available</option>
                        </select>
                    </div>
                    <div class="col s3">
                        <label>Category</label>
                        <select name="tags" class="browser-default status">
                            <option value="" disabled selected>Select Category</option>
                            <option value="Book">Book</option>
                            <option value="Thesis">Thesis</option>
                            <option value="Magazine">Magazine</option>
                        </select>
                    </div>
                    
              </div>
              <div class="row">
                    <div class="col s12">
                        <input id="tags" type="text" class="validate">
                        <label for="tags">Tag/s</label>
                    </div>
              </div>
            </div>
            <div class="modal-footer">
              <button type="submit" name="action" class="modal-action modal-close waves-effect waves-green btn-flat">Save</button>
              <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Cancel</a>
            </div>
            </form>
          </div>
        
            <!-- Delete Modal Structure -->
          <div id="delete1" class="modal">
            <div class="modal-content">
              <h5>Delete</h5>
              <p>Are you sure you want to delete item?</p>
            </div>
            <div class="modal-footer">
              <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Yes</a>
              <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">No</a>
            </div>
          </div>
          
          <form id = "delete-material-form" action="DeleteMaterialServlet" method = "POST">
			<input name="materialID" type="hidden" id="hiddeninput-material">
		 </form>
		 
		 <form id = "edit-material-form" action="EditMaterialServlet" method = "POST">
			<input name="materialID" type="hidden" id="hiddeninput-material">
		 </form>
 
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