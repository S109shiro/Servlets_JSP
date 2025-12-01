<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Servlet - Crear Usuario</title>
</head>
<body>
    <h1>Crud Cliente</h1>
    <hr>
    <form action="ServletUsuario" method="POST">
        <h1>Crear Usuario</h1>
        <p><label>Nombre: </label><input type="text" name="user_name"></p>
        <p><label>Primer Apellido: </label><input type="text" name="user_lastname"></p>
        <p><label>Segundo Apellido: </label><input type="text" name="user_second_lastname"></p>
        <p><label>Edad: </label><input type="number" name="user_age"></p>
        <p><label>Numero de identificacion: </label><input type="number" name="user_id_number"></p>
        <p><label>Email: </label><input type="email" name="user_email"></p>
        <p><label>Sexo: </label><input type="text" name="user_sex"></p>
        <p><label>Url documento identidad: </label><input type="text" name="user_document"></p>
        <p><label>Numero de telefono: </label><input type="text" name="user_number_phone"></p>
        <p><label>Fecha Nacimiento: </label><input type="date" name="user_birthday"></p>
        <p><label>Contraseña: </label><input type="password" name="user_password"></p>
        <button type="submit">Crear un nuevo usuario</button>
    </form>

    <form action="ServletUsuario" method="GET">
        <button type="submit">Mostrar Usuarios</button>
    </form>

</body>
</html>