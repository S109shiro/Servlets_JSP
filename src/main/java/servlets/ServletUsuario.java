package servlets;

import Entidades.Usuario;
import com.mytaxitravel.Crud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet("/")  // Ubicacion del servlet con el web.xml
public class ServletUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Crud crud = new Crud();
        ArrayList<Usuario> registrosUsuarios = crud.listarUsuarios();

        req.setAttribute("listaUsuarios", registrosUsuarios);

        req.getRequestDispatcher("mostrarUsuarios.jsp").forward(req, resp);

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

        Usuario user = new Usuario(nombre,primerApellido,segundoApellido,Byte.parseByte(edad),Integer.parseInt(numeroIdentificacion),email,sexo,documentoIdentidad,numeroTelefono, Date.valueOf(fechaNacimiento),0.0f,"[]", contrasena);

        Crud modificar = new Crud();
        PrintWriter out = resp.getWriter();


        if(modificar.crearUsuario(user)){

            out.println("Usuario creado");
        }else{
            out.println("Usuario no creado. Verificar datos");
        }





    }
}
