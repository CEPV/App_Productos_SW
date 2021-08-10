<?php

    //variables de conexion
    $host = 'localhost';
    $username = 'root';
    $password = '';
    $dbname ='bd_producto';

    //Realizar la conexion
    
    $connection = mysqli_init();
    mysqli_real_connect($connection,$host,$username,$password, $dbname);
    
    mysqli_set_charset($connection, 'utf8');

    if (mysqli_connect_error($connection)){
        die('Error en la conexion'. mysqli_connect_error().
        mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT));
    }
    
    //if(mysqli_connect_errno($connection)){
    //    die('Error de Conexion MYSQL: '. mysqli_connect_error());
    //}
    //
    //else{
    //echo'Conexion exitosa';
    //}

?>