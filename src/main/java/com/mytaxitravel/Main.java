package com.mytaxitravel;

import java.sql.Date;

public class Main {
    static void main(String[] args) {
        Usuario persona = new Usuario("Juan", "Diaz", "Romero", (byte)14, 182282994, "sebrod@gmail.com", "Femenino", "url.com", "3003367605", Date.valueOf("2004-10-09"), 4.8f, "[]", "2004Sebas!");
        Crud editar = new Crud();

        //editar.modificarDatosUsuario("Fecha Nacimiento", "2004-10-09", 1);
        //editar.leerDatosUsuario(1);

    }

}
