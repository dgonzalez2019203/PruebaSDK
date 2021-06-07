<?php

    if($_SERVER['REQUEST_METHOD'] == 'POST'){

        require_once("db.php");

        $documentId = $_POST['documentId'];
        $firstName = $_POST['firstName'];
        $secondName = $_POST['secondName'];
        $firstLasName = $_POST['firstLasName'];
        $secondLasName = $_POST['secondLasName'];
        $birthDate = $_POST['birthDate'];
        $age = $_POST['age'];
        $birthPlace = $_POST['birthPlace'];
        $expeditionDate = $_POST['expeditionDate'];
        $expirationDate = $_POST['expirationDate'];
        $address = $_POST['address'];
        $nationality = $_POST['nationality'];
        $shipper = $_POST['shipper'];
        $sex = $_POST['sex'];
        $civilStatus = $_POST['civilStatus'];
        $textMRX = $_POST['textMRX'];
        $optionalFieldOne = $_POST['optionalFieldOne'];
        $optionalFieldSecond = $_POST['optionalFieldSecond'];
        $imgFront = $_POST['imgFront'];
        $imgLater = $_POST['imgLater'];
        $documentTyoe = $_POST['documentTyoe'];

        
        $query = "call Sp_AddData('$documentId', '$firstName', '$secondName', '$firstLasName', '$secondLasName', '$birthDate',  '$age', '$birthPlace', '$expeditionDate', '$expirationDate', '$address', '$nationality', '$shipper', '$sex', '$civilStatus', '$textMRX', '$optionalFieldOne', '$optionalFieldSecond', '$imgFront', '$imgLater', '$documentTyoe')";
        $result = $mysql->query($query);

        if($result === TRUE){
            echo "The user was create succesfully";
        }else{
            echo "Error";
        }


        $mysql->close();
    }
?>