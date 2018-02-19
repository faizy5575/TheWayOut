<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "the_way_out";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}


$sql = "SELECT user_id, txt_name, int_phoneNumber, txt_address FROM two_member WHERE bl_status=1";

$result = $conn->query($sql);

if ($result->num_rows >0) {
 
 
 while($row[] = $result->fetch_assoc()) {

 
 $tem = $row;
 
 $json = json_encode($tem);
 
 }
 
} else {
 echo "No Results Found.";
}

 echo $json;
$conn->close();
?>