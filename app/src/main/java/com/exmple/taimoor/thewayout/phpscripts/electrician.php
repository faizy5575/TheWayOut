 <?php
include 'conn.php';

// Create connection
$conn = new mysqli($server_name, $mysql_username, $mysql_password, $db_name);

if ($conn->connect_error) {
 
 die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT * FROM two_electrician";

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