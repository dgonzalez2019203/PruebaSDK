<?php

    if($_SERVER['REQUEST_METHOD'] == 'POST'){

        require_once("db.php");

        $sexDesc = $_POST['sexDesc'];


        
        $query = "call Sp_AddSex('$sexDesc')";
        $result = $mysql->query($query);

        if($result === TRUE){
            echo "The user was create succesfully";
        }else{
            echo "Error";
        }


        $mysql->close();
    }
?>