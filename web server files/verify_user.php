<?php
require_once('connection.php');



if (!empty($_POST)){
    if (empty($_POST['user_name'] || empty($_POST['password'] ))){
        $response['success']=0;
        $message['message']="All fields must be filled out";
        die(json_encode($response));

    }



    $user_name = $_POST['name'];
    $name = "SELECT name FROM Users
    WHERE name =  '$user_name'";

    $user_password = "SELECT password FROM Users
    WHERE name = '$user_name'";
    $password_correct = password_verify($_POST['password'], $user_password);

    if(!$password_correct){
        $response['success']=0;
        $message['message']="Password is incorrect";
        die(json_encode($response));
    }
    else{
        $response['success']=1;
        $message['message']="You have been successfully logged in.";
        die(json_encode($response));
    }

}




?>