
<html>
<body>
	<h1>Add a Student</h1>
	<form action="add">

		Name: <input type="text" name="StudentName"> <br> Marks:<input
			type="text" name="Marks"> <br> City: <input type="text"
			name="City"> <br> Age: <input type="text" name="Age">
		<br>  <br>  <input type="submit" name="submit">

	</form>

	<h1>Top Students</h1>

	<form action="topstudents" >
		Age Group : <select name="AgeGroup">
			<option>10-20</option>
			<option>20-30</option>
			<option>30-60</option>
			<option>Other</option>
		</select> 
		<br>
		<br>
		City : <select name="City">
			<option>Banagalore</option>
			<option>Hyderabad</option>
			<option>Mumbai</option>
			<option>Delhi</option>
			<option>Other</option>
		</select> <br> <br> 
		<input type="submit" />
	</form>
</body>
</html>
