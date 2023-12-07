<?php
$post = empty($_POST) ? json_decode(file_get_contents('php://input'), true) : $_POST; //ajusta a $_GET a necesidad

require 'conexion.php';

$respuesta['exito'] = false;

//$id     = !empty($post['id']) ? $post['id'] : -1; //Se valida que el id no venga vacio de lo contrario será -1
$clave  = $post['clave'];
$nombre = $post['nombre'];

$apellidos = $post['apellidos'];

$id_firebase = $post['id_firebase'];
$email   = $post['email'];
$password = $post['password'];
$date = $post['date'];
$estado = $post['estado']*1;

//insert into users values (null,"ricardoJGM","ricardo","garcia mejia","example@gmail.com","2023-12-06","123456","euiwaeoiwua",1);
//Validamos si el id es nuevo entonces se hará un insert y si es
$query = "insert into users values 
                           (null,
                            '$clave',
                            '$nombre',
                            '$apellidos',
                            '$email',
                            '$date',
                            '$password',
                            '$id_firebase',
                            $estado)";

$res = mysqli_query($conexion, $query);

if ($res){
    $respuesta['exito'] = true;
    $respuesta['msj'] = "Se han guardado los datos";
}else{
    $respuesta['msj'] = 'Error al guardar los datos: ' . mysqli_error($conexion);
}

header('Content-type: application/json');
echo json_encode($respuesta);
?>