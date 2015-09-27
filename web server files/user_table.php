<?php


$table = "CREATE TABLE Users (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL,

)";


if ($conn-->query($table) === TRUE) {
    echo "Table Users created successfully";
}
else {
    echo "Error creating table: " . $conn->error;








