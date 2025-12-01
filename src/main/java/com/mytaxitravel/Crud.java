package com.mytaxitravel;

import Entidades.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Crud {
    // Metodo que crea un registro en la tabla de usuarios pasando parametros al metodo.
    public boolean crearUsuario(Usuario persona){
        String query = "insert into usuario (nombre, primer_apellido, segundo_apellido, edad, numero_identificacion, email, sexo, documento_identidad, numero_telefono, fecha_nacimiento, calificacion_media, historial_viajes, contrasena) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            Connection conexion = ConexionDB.conectar();
            PreparedStatement preparacion = conexion.prepareStatement(query);
            preparacion.setString(1, persona.getNombre());
            preparacion.setString(2, persona.getPrimerApellido());
            preparacion.setString(3, persona.getSegundoApellido());
            preparacion.setByte(4, persona.getEdad());
            preparacion.setInt(5, persona.getNumeroIdentificacion());
            preparacion.setString(6, persona.getEmail());
            preparacion.setString(7, persona.getSexo());
            preparacion.setString(8, persona.getDocumentoIdentidad());
            preparacion.setString(9, persona.getNumeroTelefono());
            preparacion.setDate(10, persona.getFechaNacimiento());
            preparacion.setFloat(11, persona.getCalificacionMedia());
            preparacion.setString(12, persona.getHistorialViajes());
            preparacion.setString(13, persona.getContrasena());
            preparacion.executeUpdate();

            ResultSet obtenerId = preparacion.executeQuery("select id_usuario from usuario where numero_identificacion = " + persona.getNumeroIdentificacion());
            while (obtenerId.next()){
                System.out.println(String.format("Datos Insertados con el ID: %d \n", obtenerId.getInt("id_usuario")));
            }
            return true;
        }catch (SQLException ex){
            System.err.println("Error al insertar datos");
            ex.printStackTrace();
            return false;
        }
    }

    // Metodo que consulta todos los registros de la tabla usuario.
    public void leerDatosUsuario(int numeroIdentificacion){
        // Definicion de la salida y query de consulta
        String salida = "ID: %d, Nombre: %s, Primer apellido: %s, Segundo apellido: %s, \nEdad: %d, Numero identificacion: %d, Email: %s, \nSexo: %s, Documento de identidad: %s, Numero de telefono: %s, \nFecha de nacimiento: %s, Calificacion media: %f, Historial de viajes: %s Contraseña: %s\n";
        String query = "select * from usuario where numero_identificacion = " + numeroIdentificacion;
        try{
            Connection conexion = ConexionDB.conectar();
            PreparedStatement preparacion = conexion.prepareStatement(query);
            ResultSet resultado = preparacion.executeQuery();

            if(!resultado.next()){
                System.err.print("No hay datos que mostrar en la tabla usuario");
            }
            else {
                // Obtenemos los datos del query con el resultado
                do{
                    int id = resultado.getInt("id_usuario");
                    String nombre = resultado.getString("nombre");
                    String primer_apellido = resultado.getString("primer_apellido");
                    String segundo_apellido = resultado.getString("segundo_apellido");
                    byte edad = resultado.getByte("edad");
                    int numero_identificacion = resultado.getInt("numero_identificacion");
                    String email = resultado.getString("email");
                    String sexo = resultado.getString("sexo");
                    String documento_identidad = resultado.getString("documento_identidad");
                    String numero_telefono = resultado.getString("numero_telefono");
                    String fecha_nacimiento = resultado.getString("fecha_nacimiento");
                    float calificacion_media = resultado.getFloat("calificacion_media");
                    String historial_viajes = resultado.getString("historial_viajes");
                    String contrasena = resultado.getString("contrasena");
                    // Salida de cada dato por consola
                    System.out.print(String.format(salida, id, nombre, primer_apellido, segundo_apellido, edad, numero_identificacion, email, sexo, documento_identidad, numero_telefono, fecha_nacimiento, calificacion_media , historial_viajes, contrasena));
                }
                while(resultado.next()); // True si existen datos
                System.out.println(); // Espacio
            }
        }catch (SQLException ex){
            System.err.println("Error al mostrar los datos");
            ex.printStackTrace();
        }
    }

    // Metodo que realiza actualizaciones a la table usuario e indica si hubo un cambio o no
    public void modificarDatosUsuario(String columna_actualizar, String nuevo_valor, int id){
        String query = "Update usuario set " + columna_actualizar.toLowerCase().trim().replace(" ", "_") + " = ? where id_usuario = ?";
        byte changes;
        try{
            Connection conexion = ConexionDB.conectar();
            PreparedStatement preparacion = conexion.prepareStatement(query);
            preparacion.setString(1, nuevo_valor);
            preparacion.setInt(2, id);

            changes = (byte) preparacion.executeUpdate();
            System.out.println(String.format("Se han realizado cambios a: %d fila \n", changes));

        } catch (SQLException e) {
            System.err.println("Error al actualizar los datos");
            e.printStackTrace();
        }

    }

    // Metodo para eliminar a un usuario de la tabla por medio de su id
    public void eliminarUsuario(int id){
        // Establecemos dos querys
        String query = "delete from usuario where id_usuario = ?";
        String queryValidacionID = "select * from usuario where id_usuario = ?";
        // Definicion de una variable para la confirmacion del delete del usuario
        char decision;
        try{
            Connection conexion = ConexionDB.conectar();

            // Validacion del id en la tabla usuarios
            PreparedStatement validacionID = conexion.prepareStatement(queryValidacionID);
            validacionID.setInt(1, id);
            ResultSet existenciaId = validacionID.executeQuery();

            // Si no existe un usuario cn ese ID entra aca
            if(!existenciaId.next()){
                System.out.println("Error. Ese registro no existe en esta tabla.\n");
            }
            // Caso contrario entra en este bloque
            else{
                // Obtencion del id existente en la tabla
                PreparedStatement preparar = conexion.prepareStatement(query);
                preparar.setInt(1, id);

                while(true){
                    // Obtenemos confirmacion por teclado
                    Scanner opcion = new Scanner(System.in);
                    System.out.print(String.format("¿Estas seguro de eliminar a %s relacionado con el id %d? (y/n): ", existenciaId.getString("nombre"), id));
                    decision = Character.toLowerCase(opcion.next().charAt(0));  // Transformar en minusculas

                    //Confirmamos si quiere eliminar el usuario
                    if(decision == 'y'){
                        System.out.println(String.format("Se han eliminado: %d registros\n", preparar.executeUpdate()));
                        break;
                    }else if(decision == 'n'){
                        System.out.println("Datos no eliminados\n");
                        break;
                    }
                    else{
                        System.err.println("Ingresa una opcion valida.");
                    }
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    // Listar todos los usuarios de la db para el JSP especialmente
    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try {
            Connection conexion = ConexionDB.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario user = new Usuario(
                        rs.getString("nombre"),
                        rs.getString("primer_apellido"),
                        rs.getString("segundo_apellido"),
                        rs.getByte("edad"),
                        rs.getInt("numero_identificacion"),
                        rs.getString("email"),
                        rs.getString("sexo"),
                        rs.getString("documento_identidad"),
                        rs.getString("numero_telefono"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getFloat("calificacion_media"),
                        rs.getString("historial_viajes"),
                        rs.getString("contrasena")
                );
                lista.add(user);
            } }
        catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }


}
