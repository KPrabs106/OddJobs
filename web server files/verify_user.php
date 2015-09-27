<?php
require_once('connection.php');


$user_ID = $_POST['user_id'];
$user_name = $_POST['user_name'];
$user_email = $_POST['user_email'];
$password_correct = password_verify($_POST['password'], password_hash($_POST['password'], PASSWORD_DEFAULT));



?>adde verify user p