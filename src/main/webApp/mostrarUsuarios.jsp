<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Servlet - Lectura de usuarios</title>
</head>
<body>
    <h1>Lectura de usuarios</h1>
    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>Primer Apellido</th>
            <th>Segundo Apellido</th>
            <th>Edad</th>
            <th>Numero de identificacion</th>
            <th>Email</th>
            <th>Sexo</th>
            <th>Documento de identidad</th>
            <th>Numero de celular</th>
            <th>Fecha de nacimiento</th>
            <th>Calificacion media</th>
            <th>Historial viajes</th>
            <th>Contraseña</th>
        </tr>

        <c:forEach var="item" items="${listaUsuarios}">
            <tr>
                <td>${item.nombre}</td>
                <td>${item.primerApellido}</td>
                <td>${item.segundoApellido}</td>
                <td>${item.edad}</td>
                <td>${item.numeroIdentificacion}</td>
                <td>${item.email}</td>
                <td>${item.sexo}</td>
                <td>${item.documentoIdentidad}</td>
                <td>${item.numeroTelefono}</td>
                <td>${item.fechaNacimiento}</td>
                <td>${item.calificacionMedia}</td>
                <td>${item.historialViajes}</td>
                <td>${item.contrasena}</td>

            </tr>
        </c:forEach>
    </table>

</body>
</html>


