<?php
require_once('connection.php');



if (!empty($_POST)){
    if (empty($_POST['user_name'] || empty($_POST['password'] ))){
        $response['success']=0;
        $message['message']="All fields must be filled out";
        die(json_encode($response));

    }

    $user_name = $_POST['name'];
    $password = password_hash($_POST['password'], PASSWORD_DEFAULT);

    checklogin = mysqli_query($link, "SELECT * FROM Users
    WHERE name = '" . $user_name . "' AND password ='" . $password ."'"));

    if(mysqli_num_rows ==1 ){
        $row = mysqli_fetch_array(checklogin);
        $user_name =$row['name'];
        $email = $row['email'];

        $_SESSION['Username'] = $user_name;
        $_SESSION['Email'] = $email;
        $_SESSION['LoggedIn'] =1 ;
    }
}





?>