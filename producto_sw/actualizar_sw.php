<?php

include_once("connection.php");
$jsonArray = array();

if(isset($_GET["id_producto"])){
    $id_producto = $_GET["id_producto"];
    $nombre_producto = $_GET["nombre_producto"];
    $distribuidor_producto = $_GET["distribuidor_producto"];
    $precio_producto = $_GET["precio_producto"];
    $tamaño_producto = $_GET["tamaño_producto"];

    $actualizar = "UPDATE tbl_producto SET nombre_producto='$nombre_producto', distribuidor_producto='$distribuidor_producto', precio_producto=$precio_producto, tamaño_producto='$tamaño_producto'
    WHERE id_producto=$id_producto;";

    $resultado = mysqli_query($connection, $actualizar) or die ("Error ".mysqli_error($connection));
    $jsonArray["tbl_producto"][] = $resultado;

    echo json_encode($jsonArray);
    mysqli_close($connection);

}
else{
    echo json_encode($jsonArray);
    mysqli_close($connection);
}





?>