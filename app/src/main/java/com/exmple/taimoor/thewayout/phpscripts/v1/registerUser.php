<?php 
 
require_once '../includes/DbOperations.php';
 
$response = array(); 
 
if($_SERVER['REQUEST_METHOD']=='POST'){
    if(
        isset($_POST['txt_name']) and
            isset($_POST['txt_password']) and
                isset($_POST['txt_address']) and
                    isset($_POST['int_CNIC']) and
                         isset($_POST['int_phoneNumber'])
        ){
        //operate the data further 
 
        $db = new DbOperations(); 

        $result = $db->createUser(  $_POST['txt_name'],
                                    $_POST['txt_password'],
                                    $_POST['txt_address'],
                                    $_POST['int_CNIC'],
                                    $_POST['int_phoneNumber'],
                                    $_POST['bl_status']
                                    //$_POST['dte_createdDate']

                                );
        if($result == 1){
            $response['error'] = false; 
            $response['message'] = "User registered successfully";
        }elseif($result == 2){
            $response['error'] = true; 
            $response['message'] = "Some error occurred please try again";          
        }elseif($result == 0){
            $response['error'] = true; 
            $response['message'] = "Username already exists, please choose a different username";                     
        }
 
    }else{
        $response['error'] = true; 
        $response['message'] = "Required fields are missing";
    }
}else{
    $response['error'] = true; 
    $response['message'] = "Invalid Request";
}
// header('Content-type=application/json; charset=utf-8');
echo json_encode($response);