<?php
$post = empty($_POST) ? json_decode(file_get_contents('php://input'), true) : $_POST; //ajusta a $_GET a necesidad

require 'conexion.php';

$respuesta['exito'] = false;

//$id     = !empty($post['id']) ? $post['id'] : -1; //Se valida que el id no venga vacio de lo contrario será -1
$clave  = $post['EventName'];
$StartDate  = $post['StartDate'];
$EndDate  = $post['EndDate'];
$StartTime  = $post['StartTime'];
$EndTime  = $post['EndTime'];
$EventAddress  = $post['EventAddress'];
$EventDesc  = $post['EventDesc'];
$EventSponsors  = $post['EventSponsors'];
$tipoEvento = $post["tipoEvento"];
$tipoActividad = $post["tipoActividad"];
$EventParticipants  = $post['EventParticipants']*1;
$municipioSeleccionado  = $post['municipioSeleccionado']*1;
$status  = $post['status']*1;

//insert into users values (null,"ricardoJGM","ricardo","garcia mejia","example@gmail.com","2023-12-06","123456","euiwaeoiwua",1);
//Validamos si el id es nuevo entonces se hará un insert y si es
$query = "INSERT INTO `events`(`id_events`, `event_id`, `event_startD`, `event_finishedD`,`startTime`,`endTime`, `id_localLocation`, `event_address`, `event_desc`, `event_sponsors`, `id_eventsTP`, `id_events_activityTP`, `event_currentP`, `event_maxP`, `id_user`, `id_status`) 
                       VALUES (null,'$clave','$StartDate','$EndDate','$StartTime','$EndTime',$municipioSeleccionado,'$EventAddress','$EventDesc','$EventSponsors', '$tipoEvento', '$tipoActividad', 0, $EventParticipants, 3, $status)";

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