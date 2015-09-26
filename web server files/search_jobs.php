<?php

//sql to search jobs
$search_category = $_POST['search_category'];
$search_low_cost =$_POST['search_low_cost'];
$search_high_cost =$_POST['search_high_cost'];
$search_time = $_POST['search_time'];

$search = "SELECT title, user_id, category, location, time, cost FROM Jobs
WHERE category = 'search_category'
AND (cost BETWEEN search_low_price AND search_high_price)
AND time = search_time
";

$searchResult = $conn->query($search);
if ($searchResult->num_rows > 0) {
    // output data of each row
    while($row = $searchResult->fetch_assoc()) {
        echo "Title: " . $row["title"] . " - Name: " . $row["user_id"]. " - Job Category: " . $row["category"]. " - Location: " . $row["location"] . " - Time: " . $time["time"] . " - Location: " . " - Cost: ". $row["cost"]"<br>";
    }
}
else {
    echo "0 results";
}

>