<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>START</title>
</head>
<body>
	<center>
	    <br>
    	<br>
        <h2>Enter race parameters</h2>
        <br>
		<form method="post" action="/stats">
			<div>Horses count:</div>
			<input type="number" name="count" min="1" max="1000" placeholder="1-1000">
			<br>
			<br>
			<div>Horse number:</div>
			<input type="number" name="number" min="1" max="1000" placeholder="1-1000">
			<br>
			<br>
			<br>
			<button type="submit">START</button>
			<br>
			<br>
            <br>
            <a href="/">back to menu</a>
		</form>
	</center>
</body>