<?php
	if($_SERVER['REQUEST_METHOD']=="POST"){
		//Get data
        $em = isset($_POST['em']) ? $_POST['em'] : "";
		$email = isset($_POST['email']) ? $_POST['email'] : "";
		$pass = isset($_POST['pass']) ? $_POST['pass'] : "";
		$name = isset($_POST['name']) ? $_POST['name'] : "";

		if(!empty($email) && !empty($pass) && !empty($name)){
            $server_name = "localhost";
            $username = "root";
            $password = "";
            $dbname = "mobile";
            $conn = new mysqli($server_name, $username, $password, $dbname);
            if ($conn->connect_error) {
                die("Connection failed". $conn->connect_error);
            }
            $sql = "Update user SET name='$name', password='$pass',email='$email' where user.email='$em'";
            $stmt = $conn->prepare($sql);
            $stmt->bindParam(":Name", $name);
            $stmt->bindParam(":Email", $email);
            $stmt->bindParam(":Password", $pass);
            if ($conn->query($sql)===TRUE) {
                echo "New record created successfully";
            }else{
                echo "Error: ".$sql . "<br>".$conn->error;
            }
            $conn->close();
        } else {
		    echo "Error: Wrong Entries";
        }
	}


?>