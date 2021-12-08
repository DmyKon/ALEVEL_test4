<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="ua.konstantynov.test4.entities.Race" %>
<%@ page import="ua.konstantynov.test4.entities.Horse" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>RACE RESULT</title>
	</head>
	<body>
		<br>
		<br>
		<center>
		    <h3>Race result</h3>
		    <% Race race = (Race) request.getAttribute("race"); %>
		    <p>Race #<span style="color: #FF0000;"><%= race.getIdentifier() %></span>
		    Time = <span style="color: #FF0000;"><%= race.getDateTime() %></span>
		    Horses count = <span style="color: #FF0000;"><%= race.getHorseCount() %></span>
		    Betting on = <span style="color: #FF0000;"><%= race.getHorseNumber() %></span></p>
                <% for (Horse horse : race.getHorses()) {
                    if (race.getHorseNumber() == horse.getNumber()) { %>
                    <h3><b>Place #<span style="color: #FF0000;"><%= horse.getPlace() %></span>
                    Horse #<span style="color: #FF0000;"><%= horse.getNumber() %></span></b></h3>
                    <% } else { %>
                        <p>Place #<span style="color: #FF0000;"><%= horse.getPlace() %></span>
                        Horse #<span style="color: #FF0000;"><%= horse.getNumber() %></span></p>
                    <% }
                } %>
            <br>
            <a href="/list">back to list</a>
		</center>
	</body>
</html>