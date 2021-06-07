<?php

    $mysql = new mysqli(
        "localhost",
        "root",
        "",
        "blinkid",
        "3308"
    );

    if($mysql->connect_error){
        die("Failed to connect" . $mysql->connect_error);
    }else{
        echo "Succesfully";
    }

?>