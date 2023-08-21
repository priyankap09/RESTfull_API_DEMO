<h1>Register new user</h1>

<form enctype="multipart/form-data" method="post" >
	<input name="username" placeholder="Enter username"><br><br>
	
	<input type="password" name="password" placeholder="Enter password"><br><br>
	
	<input name="mobno" placeholder="Enter mobile no.">	<br><br>
	
	<input type="email" name="emailid" placeholder="Enter email id"><br><br>
	
	<input type="file" name="images" ><br><br>
	
	<input type="submit" value="Register" formaction="saveUserData"><br><br>
	
	<span style="color:red; font-size: larger">${message}</span>
	
</form>