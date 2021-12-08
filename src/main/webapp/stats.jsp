<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Stats</title>
	</head>
	<body>
		<br>
		<br>
		<center>
			<h2>
			    <% if (request.getAttribute("raceId") == null || request.getAttribute("horsePlace") == null) { %>
			    <a href="/race/start">For bet on a horse, start a new race</a> <% } else { %>
			    Race #<span style="color: #FF0000;"><%= request.getAttribute("raceId") %></span>
			    <br>
			    <br>
			    The horse you are betting on takes <span style="color: #FF0000;">
			    <%= request.getAttribute("horsePlace") %>
			    </span> place
			    <% } %>
			</h2>
			<h3>
			    There were <span style="color: #FF0000;">
		 	    <%= request.getAttribute("racesCount") %>
			    </span> races in total
			</h3>
			<br>
			<br>
			<a href="/race/start">new race</a>
			<br>
			<br>
			<a href="/">back to menu</a>
		</center>
	</body>
</html>