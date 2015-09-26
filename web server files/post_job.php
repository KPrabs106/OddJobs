<?php
require_once('connection.php');

// sql to add a job

$job_title = $_POST['title'];
$job_ID = $_POST['user_id'];
$job_category = $_POST['category'];
$job_location = $_POST['location'];
$job_time = $_POST['time'];
$job_cost = $_POST['cost'];
$job_details = $_POST['details'];


$add_job ="INSERT INTO Jobs (title, user_id, category, location, time, cost, details)
VALUES (job_title, job_ID, job_category, job_location, job_time, job_cost, job_details)";


if ($conn-->query($addJob) === TRUE) {
    echo "Job successfully added!";
}
else{
    echo "Error: " . $sql . "<br>" . $conn->error;
}


?>