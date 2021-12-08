<%@ page import="java.util.List" %>
<%@ page import="ua.konstantynov.test4.entities.Race" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>RACE LIST</title>
	</head>
	<body>
		<br>
		<br>
		<center>
		    <h3>Race list</h3>
		    <% List<Race> raceList = (List) request.getAttribute("raceList"); %>
            <% for (Race race : raceList) { %>
               <p>Race #<a style="color: #FF0000"
               href="/race/<%= race.getIdentifier() %>"><%= race.getIdentifier() %></a>
                  Time = <span style="color: #FF0000;"><%= race.getDateTime() %></span>
                  Betting on #<span style="color: #FF0000;"><%= race.getHorseNumber() %></span>
                  Horses count = <span style="color: #FF0000;"><%= race.getHorseCount() %></span></p>
            <% } %>
        <br>
        <h3><a href="/">back to menu</a></h3>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <form method="post" action="/list">
        Enter "Accept" to clear the results
        <br>
        <input type="text" name="clear" placeholder="Accept">
        <button type="submit">CLEAR</button>
        </form>
		</center>
	</body>
</html>