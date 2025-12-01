package Entidades;

import java.sql.*;

public class Usuario {
        // Atributos
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private byte edad;
        private int numeroIdentificacion;
        private String email;
        private String sexo;
        private String documentoIdentidad;
        private String numeroTelefono;
        private Date fechaNacimiento;
        private float calificacionMedia;
        private String historialViajes;
        private String contrasena;

        // Constructo vacio
        public Usuario(){

        }

        // Constructor con parametros
        public Usuario(String nombre, String primerApellido, String segundoApellido, byte edad, int numeroIdentificacion, String email, String sexo, String documentoIdentidad, String numeroTelefono, Date fechaNacimiento, float calificacionMedia, String historialViajes, String contrasena) {
            this.nombre = nombre;
            this.primerApellido = primerApellido;
            this.segundoApellido = segundoApellido;
            this.edad = edad;
            this.numeroIdentificacion = numeroIdentificacion;
            this.email = email;
            this.sexo = sexo;
            this.documentoIdentidad = documentoIdentidad;
            this.numeroTelefono = numeroTelefono;
            this.fechaNacimiento = fechaNacimiento;
            this.calificacionMedia = calificacionMedia;
            this.historialViajes = historialViajes;
            this.contrasena = contrasena;
        }

        // Getters y Setters
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getPrimerApellido() {
            return primerApellido;
        }

        public void setPrimerApellido(String primerApellido) {
            this.primerApellido = primerApellido;
        }

        public String getSegundoApellido() {
            return segundoApellido;
        }

        public void setSegundoApellido(String segundoApellido) {
            this.segundoApellido = segundoApellido;
        }

        public byte getEdad() {
            return edad;
        }

        public void setEdad(byte edad) {
            this.edad = edad;
        }

        public int getNumeroIdentificacion() {
            return numeroIdentificacion;
        }

        public void setNumeroIdentificacion(int numeroIdentificacion) {
            this.numeroIdentificacion = numeroIdentificacion;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        public String getDocumentoIdentidad() {
            return documentoIdentidad;
        }

        public void setDocumentoIdentidad(String documentoIdentidad) {
            this.documentoIdentidad = documentoIdentidad;
        }

        public String getNumeroTelefono() {
            return numeroTelefono;
        }

        public void setNumeroTelefono(String numeroTelefono) {
            this.numeroTelefono = numeroTelefono;
        }

        public Date getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(Date fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public float getCalificacionMedia() {
            return calificacionMedia;
        }

        public void setCalificacionMedia(float calificacionMedia) {
            this.calificacionMedia = calificacionMedia;
        }

        public String getHistorialViajes() {
            return historialViajes;
        }

        public void setHistorialViajes(String historialViajes) {
            this.historialViajes = historialViajes;
        }

        public String getContrasena() {
            return contrasena;
        }

        public void setContrasena(String contrasena) {
            this.contrasena = contrasena;
        }


}
