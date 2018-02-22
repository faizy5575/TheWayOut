<?php 
 
require_once '../includes/DbOperations.php';
 
$response = array(); 
 
if($_SERVER['REQUEST_METHOD']=='POST'){
    if(isset($_POST['txt_name']) and isset($_POST['txt_password'])){
        $db = new DbOperations(); 
 
        if($db->userLogin($_POST['txt_name'], $_POST['txt_password'])){
            $user = $db->getUserByUsername($_POST['txt_name']);
            $response['error'] = false; 
            $response['user_id'] = $user['user_id'];
            $response['txt_name'] = $user['txt_name'];
        }else{
            $response['error'] = true; 
            $response['message'] = "Invalid username or password";          
        }
 
    }else{
        $response['error'] = true; 
        $response['message'] = "Required fields are missing";
    }
}
 
echo json_encode($response);