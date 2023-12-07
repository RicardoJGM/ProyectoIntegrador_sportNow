<?php
$post = empty($_POST) ? json_decode(file_get_contents('php://input'), true) : $_POST; //ajusta a $_GET a necesidad

require 'conexion.php';

$respuesta['exito'] = false;

$id     = !empty($post['id']) ? $post['id'] : -1; //Se valida que el id no venga vacio de lo contrario será -1

$nombre = $post['nombre'];

$precio = trim($post['precio']);
$precio *= 1.0;

$xbox   = $post['xbox'] == true ? 1 : 0; //operador ternario
$playstation = $post['playstation'] == true ? 1 : 0;
$nintendo = $post['nintendo'] == true ? 1 : 0;
$pc     = $post['pc'] == true ? 1 : 0;
$estado = $post['estado'];

//Validamos si el id es nuevo entonces se hará un insert y si es
$query = "delete from videogames where 
                nombre = '$nombre' and
                precio = $precio and
                estado = '$estado' and
                xbox = $xbox and 
                playstation = $playstation and
                nintendo = $nintendo and
                pc = $pc and
                id = $id";



$res = mysqli_query($conexion, $query);

if ($res){
    $respuesta['exito'] = true;
    $respuesta['msj'] = "Se ha borrado el registro exitosamente";
}else{
    $respuesta['msj'] = 'Error al borrar el registro: ' . mysqli_error($conexion);
}

header('Content-type: application/json');
echo json_encode($respuesta);
?>