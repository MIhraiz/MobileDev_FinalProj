<?php
if ($_SERVER['REQUEST_METHOD'] == "POST") {
    //Get data
    $email = isset($_POST['email']) ? $_POST['email'] : "";
    $passs = isset($_POST['passs']) ? $_POST['passs'] : "";
    $myname = isset($_POST['myname']) ? $_POST['myname'] : "";

    $server_name = "localhost";
    $username = "root";
    $password = "";
    $dbname = "mobile";
    $conn = new mysqli($server_name, $username, $password, $dbname);
    if ($conn->connect_error) {
        die("Connection failed" . $conn->connect_error);
    }
    $sql = "INSERT INTO `user`VALUES ('$myname','$email' ,'$passs')";

    if ($conn->query($sql) === TRUE) {
        echo "New record created successfully";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }
    $conn->close();

}


?>