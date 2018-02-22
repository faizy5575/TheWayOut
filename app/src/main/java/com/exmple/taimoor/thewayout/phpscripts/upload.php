<?php

$db_name = "the_way_out";
$mysql_username = "root";
$mysql_password = "";
$server_name = "";

$conn = mysqli_connect($server_name, $mysql_username, $mysql_password, $db_name);
 
 if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
 $DefaultId = 0;
 
 $ImageData = $_POST['image_path'];
 
 $ImageName = $_POST['image_name'];

 $GetOldIdSQL ="SELECT two_id FROM two_deals ORDER BY two_id ASC";
 
 $Query = mysqli_query($conn,$GetOldIdSQL);
 
 while($row = mysqli_fetch_array($Query)){
 
 $DefaultId = $row['two_id'];
 }
 
 $ImagePath = "uploads/$DefaultId.png";
 
 $ServerURL = "http://192.168.53.99:80/$ImagePath";
 
 $InsertSQL = "insert into two_deals (image, amount, dte_createdDate) values ('$ServerURL','$ImageName', CURDATE())";
 
 if(mysqli_query($conn, $InsertSQL)){

 file_put_contents($ImagePath,base64_decode($ImageData));

 echo "Your Deal Has Been Added.";
 }
 
 mysqli_close($conn);
 }else{
 echo "Not Uploaded";
 }

?>