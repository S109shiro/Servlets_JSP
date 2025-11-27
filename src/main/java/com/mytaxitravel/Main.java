package com.mytaxitravel;

import java.sql.Date;

public class Main {
    static void main(String[] args) {
        Usuario persona = new Usuario("Juan", "Diaz", "Romero", (byte)14, 1016712994, "sebrod@gmail.com", "Femenino", "url.com", "3003367605", Date.valueOf("2004-10-09"), 4.8f, "[]", "2004Sebas!");
        Crud editar = new Crud();

        //editar.modificarDatosUsuario("numero identificacion", "1016712994", 1);
        editar.leerDatosUsuario(persona.getNumeroIdentificacion());

    }

}
