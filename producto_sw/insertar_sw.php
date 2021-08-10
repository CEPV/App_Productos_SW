<?php

//incluir la clase de conexion
include_once("connection.php");

//se crea el array que contendra la informacion ya sea para trasladar o recepcionar
$jsonArray = array();

//Definimos los campos que seran utilizados
if(isset($_GET["nombre_producto"]) && isset($_GET["distribuidor_producto"]) && isset($_GET["precio_producto"]) 
&& isset($_GET["tamaño_producto"])){
    
    //Declarar variables que definirarn los datos a insertar
    $nombre_producto = $_GET["nombre_producto"];
    $distribuidor_producto = $_GET["distribuidor_producto"];
    $precio_producto = $_GET["precio_producto"];
    $tamaño_producto = $_GET["tamaño_producto"];

    //Declaracion de la consulta realizada
    $insertar = "INSERT INTO tbl_producto(nombre_producto, distribuidor_producto, precio_producto, tamaño_producto)
                VALUES ('{$nombre_producto}', '{$distribuidor_producto}', {$precio_producto}, '{$tamaño_producto}');";

    //Obtenemos el resultado de la conexion y la consulta que se fue a realizar en la base de datos
    $resultado = mysqli_query($connection, $insertar) or die('Error '. mysqli_error($connection));

    //Agregar el resultado como dato al array
    $jsonArray["tbl_producto"] = $resultado;

    //Asignacion del arreglo al JSON para la estructura a manipular
    echo json_encode($jsonArray);
    mysqli_close($connection);

}
else{
    json_encode($jsonArray);
    mysqli_close($connection);
    echo 'Datos no Insertados';


}



?>