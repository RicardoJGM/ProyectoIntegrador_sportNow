<?php
require 'conexion.php';

$respuesta['exito'] = false;
$respuesta['lista'] = null;

$sql = 'select * from videogames';
$result = mysqli_query($conexion, $sql);

$lista = array();
if($result){
  $respuesta['exito'] = true;

 while($row = mysqli_fetch_assoc($result)){
     $row['xbox'] = $row['xbox'] == '1';
     $row['playstation'] = $row['playstation'] == '1';
     $row['nintendo'] = $row['nintendo'] == '1';
     $row['pc'] = $row['pc'] == '1';

    $lista[] = $row;
 }

 $respuesta['lista'] = $lista;
}
 
 header('Content-type: application/json');
 echo json_encode($respuesta);
?>