package com.mytaxitravel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static String url = "jdbc:mysql://localhost:3306/my_taxi_travel";
    private static String user = "root";
    private static String pass = "2004248";

    public static Connection conectar(){
        Connection conexion = null;
        try{
            conexion = DriverManager.getConnection(url, user, pass);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return conexion;

    }


}
