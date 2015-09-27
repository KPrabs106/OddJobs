<?php
require_once('connection.php');


$user_ID = $_POST['user_id'];
$user_name = $_POST['user_name'];
$user_email = $_POST['user_email'];
$user_password = "SELECT password FROM Users
WHERE name = '$user_name'";
$password_correct = password_verify($_POST['password'], $user_password);



?>