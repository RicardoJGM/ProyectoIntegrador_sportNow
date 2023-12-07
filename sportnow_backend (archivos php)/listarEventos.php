<?php
require 'conexion.php';

$respuesta['exito'] = false;
$respuesta['lista'] = null;

$sql = 'select * from events';
$result = mysqli_query($conexion, $sql);

$lista = array();
if($result){
  $respuesta['exito'] = true;

 while($row = mysqli_fetch_assoc($result)){
    $lista[] = $row;
 }

 $respuesta['lista'] = $lista;
}
 
 header('Content-type: application/json');
 echo json_encode($respuesta);
?>