 <?php

include 'conn.php';
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "the_way_out";

$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$dte_date = '2018-02-26';
$b_start_time = '11:00:00';
$b_end_time = '14:00:00';

//checking Availability
//$response = array(); 

            $type = $_GET['item_type'];
           if ($type == 'checkAvailability'){

              checkAvailability($conn,$dte_date, $b_start_time, $b_end_time);
            }

           


       

      if (empty($_POST['dte_date']) === false AND empty($_POST['b_start_time'])=== false AND empty($_POST['b_end_time'])=== false) {

    //prepare data for inserting 
    $dte_date = htmlentities(trim($_POST['dte_date']));
    $dte_date = preg_replace("/[^0-9]/","", $dte_date);

    $b_start_time = htmlentities(trim($_POST['b_start_time']));
    $b_start_time = preg_replace("/[^0-9]/","", $b_start_time);

    $b_end_time = htmlentities(trim($_POST['b_end_time']));
    $b_end_time = preg_replace("/[^0-9]/","", $b_end_time);

              checkAvailability($conn,$dte_date, $b_start_time, $b_end_time);

              
                                
              }





     function checkAvailability($conn,$dte_date, $b_start_time, $b_end_time){

    $result = "SELECT sp_name, sp_location FROM two_swimming 
    where sp_id != (SELECT ts.sp_id FROM two_swimming ts JOIN two_booking tb ON ts.sp_id = tb.sp_id
		WHERE tb.dte_date = '" .$dte_date. "' AND tb.b_start_time <= '".$b_start_time. "' AND tb.b_end_time >= '" .$b_end_time. "')";


           $res = mysqli_query($conn,$result)
                      or die("Error: ".mysqli_error($conn));
        if($res->num_rows>0) {

      
         	// $response['error'] = false; 
          //   $response['message'] = "Swimming pools Available";


        while($row[] = $res->fetch_assoc()) {

 
			 $item = $row;
			 
			 $json = json_encode($item);
			 
			 }
 			 echo $json;
			
        }

    
      
    
    else
    {
         	// $response['error'] = false; 
          //   $response['message'] = "Swimming pools Are Available";


    	$res = mysqli_query($conn, "SELECT sp_name, sp_location FROM two_swimming");
    	if ($res->num_rows>0) {

    		    	//echo "All Swimming Pools Are Available : </br> </br>";

    		    	while($row[] = $res->fetch_assoc()) {

 
			 $item = $row;
			 
			  $json = json_encode($item);			 
			 }
 			  echo $json;
    	 }

	     } }
     
 
//echo json_encode($response);

?>
