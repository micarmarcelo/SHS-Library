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
				$("a.reserve").click(function(){
					// get id of the clicked material
					var materialID = $(this).attr("id");
					// set value of hidden input to the id
					$('#hiddeninput-material').val(materialID);
					
					// submit form automatically
					$('#reserve-material-form').submit();

				});
				
			});
		</script> 
		
		<script>	
			$(document).ready(function(){
				$("a.view-material").click(function(){
					// get id of the clicked material
					var materialID = $(this).attr("id");
					// set value of hidden input to the id
					$('#hiddeninput-viewmaterial').val(materialID);
					// submit form automatically
					$('#view-material-form').submit();

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
                            <li><a href="login.html">Logout</a></li>
                        </ul> 
                    </li>
                    </form>
                </ul>
            </div>
        </nav>
        
        <!--Main-->
        
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
                
                <!--AVAILABLE BOOK SAMPLE-->
                <!--<div class="col s4 m4 l4">
                    <div class="card">
                        <div class="card-image waves-effect waves-block waves-light green lighten-5" style="padding: 20px;">
                          <img class="activator" src="http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png" style="height: 200px; width: 180px; margin-left: 20%;">
                        </div>
                        <div class="card-content">
                          <span class="card-title activator grey-text text-darken-4">To Kill A Mockingbird<i class="material-icons right">more_vert</i></span>
                          <span>
                            <a href="#">More details</a>
                            <p style="float: right; color: green;"><b>Available</b></p>
                          </span>
                        </div>
                        
                       
                        <div class="card-reveal">
                          <span class="card-title grey-text text-darken-4"><b>To Kill A Mockingbird</b><i class="material-icons right">close</i></span>
                          <p><i>823.914</i></p>
                          <p><i>R797c</i></p>
                          <p><b>Author/s: </b>Harper Lee</p>
                          <p><b>Publisher/s: </b>J.B. Lippincott</p>
                          <p><b>Year: </b>1960</p>
                          <p><b>Tags: </b> <i>Southern Gothic, Coming-of-Age Fiction, Bildungsroman</i></p>
                          <span style="display: flex;">
                            <p><b>Status: &nbsp;</b></p> 
                            <p id="status" style="color: green;"><b>Available</b></p>
                          </span>
                          <p><b>Reservation Date: </b>June 3, 2017</p>
                          <p><b>Return Date: </b>June 10, 2017</p>
                        </div>
                    </div>
                </div>-->
                
                <!--NOT AVAILABLE THESIS SAMPLE
                <div class="col s4 m4 l4">
                    <div class="card">
                        <div class="card-image waves-effect waves-block waves-light green lighten-5" style="padding: 20px;">
                          <img class="activator" src="res/thesis.png" style="height: 200px; width: 180px; margin-left: 20%;">
                        </div>
                        <div class="card-content">
                          <span class="card-title activator grey-text text-darken-4">Thesis Material<i class="material-icons right">more_vert</i></span>
                          <span>
                            <a href="#">More details</a>
                            <p style="float: right; color: red;"><b>Not Available</b></p>
                          </span>
                        </div>
                        
                        <div class="card-reveal">
                          <span class="card-title grey-text text-darken-4"><b>Thesis Material</b><i class="material-icons right">close</i></span>
                          <p><i>123.456</i></p>
                          <p><i>A123c</i></p>
                          <p><b>Author/s: </b>Arceo, Patrick; Cheng, Clarisse; Marcelo, Micaella</p>
                          <p><b>Publisher/s: </b>Peradilla, Marnel</p>
                          <p><b>Year: </b>2017</p>
                          <p><b>Tags: </b> <i>Secure Development, Machine Project, Ayoko Na</i></p>
                          <span style="display: flex;">
                            <p><b>Status: &nbsp;</b></p> 
                            <p id="status" style="color: red;"><b>Not Available</b></p>
                          </span>
                          <p><b>Date of Availability: </b>June 23, 2017</p>
                        </div>
                    </div>
                </div>-->
                
            
                <!--Sample of Available Book Material-->
                <c:forEach var = "c" items = "${materials}">
	                
					    <div class="col s12">
		                    <div class="row grey lighten-4 material-container">
		                    <c:choose>
								  <c:when test="${c.tags=='Magazine'}">
								    <div class="col s1 material-type center">
			                            <img class="material-icon" src="res/magazine.png">
			                            <p class=""><b>Magazine</b></p>
			                        </div>
								  </c:when>
								  <c:when test="${c.tags=='Thesis'}">
								    <div class="col s1 material-type center">
			                            <img class="material-icon" src="res/thesis.png">
			                            <p class=""><b>Thesis</b></p>
			                        </div>
								  </c:when>
								  <c:otherwise>
			                        <div class="col s1 material-type center">
			                            <img class="material-icon" src="res/book.png">
			                            <p class=""><b>Book</b></p>
			                        </div>
								  </c:otherwise>
								</c:choose>
		                        <div class="col s10">
		                            <a href="#" class="view-material" id="${c.materialID }"><b>${c.title}</b></a>
		                            <p><b>Author/s: </b>${c.author}</p>
		                            <p><b>Publisher/s: </b>${c.publisher}</p>
		                            <p><b>Year: </b>${c.year}</p>
		                            <br>
		                            <p><b>Location: </b><i>${c.location}</i></p>
		                            <!-- <p><b>Tags: </b> <i>text rdacontent, computer rdamedia, computer disc rdacarrier, stock market</i></p> -->
		                            <span style="display: flex;">
		                            <p><b>Status: &nbsp;</b></p> 
		                            <p id="status" style="color: green;"><b>${c.status}</b></p>
		                          </span>
		                          <p><b>Reservation Date: </b>${c.reservationDate}</p>
		                          <p><b>Return Date: </b>${c.returnDate}</p>
		                          	<br>
                            		<a href="#" id="${c.materialID}" class="reserve"><b>Reserve</b></a>
		                        </div>
		                    </div>
		                </div>
                </c:forEach>
                
                <c:forEach var = "c" items = "${material}">
	                
					    <div class="col s12">
		                    <div class="row grey lighten-4 material-container">
		                    <c:choose>
								  <c:when test="${c.tags=='Magazine'}">
								    <div class="col s1 material-type center">
			                            <img class="material-icon" src="res/magazine.png">
			                            <p class=""><b>Magazine</b></p>
			                        </div>
								  </c:when>
								  <c:when test="${c.tags=='Thesis'}">
								    <div class="col s1 material-type center">
			                            <img class="material-icon" src="res/thesis.png">
			                            <p class=""><b>Thesis</b></p>
			                        </div>
								  </c:when>
								  <c:otherwise>
			                        <div class="col s1 material-type center">
			                            <img class="material-icon" src="res/book.png">
			                            <p class=""><b>Book</b></p>
			                        </div>
								  </c:otherwise>
								</c:choose>
		                        <div class="col s10">
		                            <a href="#" class="view-material" id="${c.materialID }"><b>${c.title}</b></a>
		                            <p><b>Author/s: </b>${c.author}</p>
		                            <p><b>Publisher/s: </b>${c.publisher}</p>
		                            <p><b>Year: </b>${c.year}</p>
		                            <br>
		                            <p><b>Location: </b><i>${c.location}</i></p>
		                            <!-- <p><b>Tags: </b> <i>text rdacontent, computer rdamedia, computer disc rdacarrier, stock market</i></p> -->
		                            <span style="display: flex;">
		                            <p><b>Status: &nbsp;</b></p> 
		                            <p id="status" style="color: green;"><b>${c.status}</b></p>
		                          </span>
		                          <p><b>Reservation Date: </b>${c.reservationDate}</p>
		                          <p><b>Return Date: </b>${c.returnDate}</p>
		                          	<br>
                            		<a href="#" id="${c.materialID}" class="reserve"><b>Reserve</b></a>
		                        </div>
		                    </div>
		                </div>
                </c:forEach>
                <!-- 
                Sample of Available Book Material
                <div class="col s12">
                    <div class="row grey lighten-4 material-container">
                        <div class="col s1 material-type center">
                            <img class="material-icon" src="res/book.png">
                            <p class=""><b>Book</b></p>
                        </div>
                        <div class="col s10">
                            <a id="item1"><b>The Impact of terror attacks in Asia to the Philippine stock market</b></a>
                            <p><b>Author/s: </b>Chen, Davian; Lim, Belinda Jane; Rempillo, Alexandre Miguel; Sanchez, Bianca Isabel</p>
                            <p><b>Publisher/s: </b>Lee, Bruce</p>
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
                    </div>
                </div>
                
                Sample for Unavailable Thesis Material
                <div class="col s12">
                    <div class="row grey lighten-4 material-container">
                        <div class="col s1 material-type center">
                            <img class="material-icon" src="res/thesis.png">
                            <p class=""><b>Thesis</b></p>
                        </div>
                        <div class="col s10">
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
                    </div>
                </div>
                
                Sample for Unavailable Magazine
                <div class="col s12">
                    <div class="row grey lighten-4 material-container">
                        <div class="col s1 material-type center">
                            <img class="material-icon" src="res/magazine.png">
                            <p class=""><b>Magazine</b></p>
                        </div>
                        <div class="col s10">
                            <a id="item2"><b>Feature and magazine writing : action, angle and anecdotes</b></a>
                            <p><b>Author/s: </b>Summer, David</p>
                            <p><b>Publisher/s: </b>Travolta, John</p>
                            <p><b>Year: </b>2013</p>
                            <br>
                            <p><b>Location: </b><i>123.456; A123c</i></p>
                            <p><b>Tags: </b> <i>feature writing, journalism</i></p>
                          <span style="display: flex;">
                            <p><b>Status: &nbsp;</b></p> 
                            <p id="status" style="color: red;"><b>Not Available</b></p>
                          </span>
                          <p><b>Date of Availability: </b>July 19, 2017</p>
                        </div>
                    </div>
                </div>
                 -->
                 <!-- Modal Structure -->
          <div id="modal1" class="modal">
            <div class="modal-content">
              <h4>Reserve Material</h4>
              <p>Are you sure you want to reserve material?</p>
            </div>
            <div class="modal-footer">
              <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Yes</a>
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">No</a>
            </div>
          </div>
            </div>        
        </div>
        
	        <!-- HIDDEN FORMS -->
	     <form id = "reserve-material-form" action = "ReserveServlet" method = "POST">
			<input name="materialID" type="hidden" id="hiddeninput-material">
		 </form>
		 <form id = "view-material-form" action = "ViewMaterialServlet" method = "POST">
			<input name= "materialID" type="hidden" id="hiddeninput-viewmaterial">
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