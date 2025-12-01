package servlets;

import Entidades.Usuario;
import com.mytaxitravel.Crud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/")
public class ServletUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("user_name");
        String primerApellido = req.getParameter("user_lastname");
        String segundoApellido = req.getParameter("user_second_lastname");
        String edad = req.getParameter("user_age");
        String numeroIdentificacion = req.getParameter("user_id_number");
        String email = req.getParameter("user_email");
        String sexo = req.getParameter("user_sex");
        String documentoIdentidad = req.getParameter("user_document");
        String numeroTelefono = req.getParameter("user_number_phone");
        String fechaNacimiento = req.getParameter("user_birthday");
        String contrasena = req.getParameter("user_password");

        System.out.println(fechaNacimiento);

        Usuario user = new Usuario(nombre,primerApellido,segundoApellido,Byte.parseByte(edad),Integer.parseInt(numeroIdentificacion),email,sexo,documentoIdentidad,numeroTelefono, Date.valueOf(fechaNacimiento),0.0f,"[]", contrasena);

        Crud modificar = new Crud();

        modificar.crearUsuario(user);




    }
}
