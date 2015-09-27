<?php
require_once('connection.php');

// sql to add a job

$user_ID = $_POST['user_id'];
$user_name = $_POST['user_name'];
$user_email = $_POST['user_email'];
$hash_password = password_hash($_POST['password'], PASSWORD_DEFAULT);

$add_user ="INSERT INTO Users (id, name, email, password)
VALUES (user_ID, user_name, user_email, hash_password)";


if ($conn-->query($add_user) === TRUE) {
    echo "User successfully added!";
}
else{
    echo "Error: " . $sql . "<br>" . $conn->error;
}


?>