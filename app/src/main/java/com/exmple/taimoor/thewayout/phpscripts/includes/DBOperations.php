<?php 
 
    class DbOperations{
 
        private $con; 
 
        function __construct(){
 
            require_once dirname(__FILE__).'/DbConnect.php';
 
            $db = new DbConnect();
 
            $this->con = $db->connect();
 
        }
 
        /*CRUD -> C -> CREATE */
 
        public function createUser($txt_name, $txt_password, $txt_address, $int_CNIC, $int_phoneNumber, $bl_status){
            if($this->isUserExist($txt_name)){
                return 0; 
            }else{
                $dte_createdDate = date("y/m/d");
                //$password=$txt_password
                $password = md5($txt_password);
                $stmt = $this->con->prepare ("INSERT INTO `two_member` (`user_id`, `txt_name`, `txt_password`, `txt_address`, `int_CNIC`, `int_phoneNumber`, `bl_status`, `dte_createdDate`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?);");
                $stmt->bind_param ("sssssss", $txt_name, $password, $txt_address, $int_CNIC, $int_phoneNumber, $bl_status, $dte_createdDate);
 
                if($stmt->execute()){
                    return 1;
                }else{
                    return 2;
                }

            }
        }
 
        public function userLogin($txt_name, $txt_password){
            $password = md5($txt_password);
            $stmt = $this->con->prepare("SELECT user_id FROM two_member WHERE txt_name = ? AND txt_password = ?");
            $stmt->bind_param("ss",$txt_name,$password);
            $stmt->execute();
            $stmt->store_result(); 
            return $stmt->num_rows > 0; 
        }
 
        public function getUserByUsername($txt_name){
            $stmt = $this->con->prepare("SELECT * FROM two_member WHERE txt_name = ?");
            $stmt->bind_param("s",$txt_name);
            $stmt->execute();
            return $stmt->get_result()->fetch_assoc();
        }
         
 
        private function isUserExist($txt_name){
            $stmt = $this->con->prepare("SELECT user_id FROM two_member WHERE txt_name = ?");
            $stmt->bind_param("s", $txt_name);
            $stmt->execute(); 
            $stmt->store_result(); 
            return $stmt->num_rows > 0; 
        }
 
    }