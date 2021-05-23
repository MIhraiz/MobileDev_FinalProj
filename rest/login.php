<?php

	$pass = "";
	$email = "";
	if(isset($_GET['email']) && isset($_GET['pass']) ){
		$pass = $_GET['pass'];
		$email = $_GET['email'];
        if(!empty($pass) && !empty($email)){
            $server_name = "localhost";
            $username = "root";
            $password = "";
            $dbname = "mobile";

            $conn = new mysqli($server_name, $username, $password, $dbname);
            if ($conn->connect_error) {
                die("Connection failed: " . $conn->connect_error);
            } else {
                $sql = "select * from user where password='$pass' AND email='$email'";
                $result = $conn->query($sql);
                $data = "";
                if ($result->num_rows > 0) {
                    // output data of each row
                    while($row = $result->fetch_assoc()) {
                        $data.= $row["email"] . ",".$row["name"] . ",".$row["password"] . ",";
                    }
                    echo $data;
                } else {
                    echo "Failed";
                }
                $conn->close();
            }
              } else {
            echo "Failed";
        }
	} else {
        echo "Failed";
    }

?>