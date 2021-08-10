<?php

include_once ("connection.php");

$jsonArray = array();

if(isset($_GET["id_producto"])){
    $id_producto = $_GET["id_producto"];
    $buscarID = "SELECT nombre_producto, distribuidor_producto, precio_producto, tamaño_producto
    FROM tbl_producto WHERE id_producto =$id_producto";

    $resultado = mysqli_query($connection, $buscarID) or die("Error ". mysqli_error($connection));

    if(mysqli_num_rows($resultado) > 0){
        $registros = mysqli_fetch_array($resultado);
        $jsonArray["tbl_producto"][] = $registros;
    }else{
        $resultadoVacio["nombre_producto"] = "...";
        $resultadoVacio["distribuidor_producto"] = "...";
        $resultadoVacio["precio_producto"] = "...";
        $resultadoVacio["tamaño_producto"] = "...";
        $jsonArray["tbl_producto"][] = $resultadoVacio;
        
        
        
        //$jsonArray["tbl_producto"] []= $registros;
        //echo "Datos no encontrados";
    }

    echo json_encode($jsonArray);
    mysqli_close($connection);

}
else{
    echo json_encode($jsonArray);
    mysqli_close($connection);
    echo "Datos no encontrados";
}





?>