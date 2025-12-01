<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Servlet - Crear Usuario</title>
</head>
<body>
    <h1>Crud Cliente - My Taxi Travel</h1>
    <hr>
    <form action="ServletUsuario" method="POST">
        <h1>Rol Administrador - Crear Usuario</h1>
        <p><label>Nombre: </label><input type="text" name="user_name" maxlength="50" required></p>
        <p><label>Primer Apellido: </label><input type="text" name="user_lastname" maxlength="50" required></p>
        <p><label>Segundo Apellido: </label><input type="text" name="user_second_lastname" maxlength="50" required></p>
        <p><label>Edad: </label><input type="number" name="user_age" max="100" required></p>
        <p><label>Numero de identificacion: </label><input type="number" name="user_id_number" max="10000000000" required></p>
        <p><label>Email: </label><input type="email" name="user_email" maxlength="255" required></p>
        <p><label>Sexo: </label><input type="text" name="user_sex" maxlength="10" required></p>
        <p><label>Url documento identidad: </label><input type="text" name="user_document" required></p>
        <p><label>Numero de telefono: </label><input type="text" name="user_number_phone" maxlength="10" required></p>
        <p><label>Fecha Nacimiento: </label><input type="date" name="user_birthday" required></p>
        <p><label>Contraseña: </label><input type="password" name="user_password" maxlength="60" required></p>
        <button type="submit">Crear un nuevo usuario</button>
    </form>

    <h1>¿Deseas ver los registros de los usuarios?</h1>
    <form action="ServletUsuario" method="GET">
        <button type="submit">Mostrar Usuarios</button>
    </form>

</body>
</html>