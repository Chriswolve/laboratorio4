package com.example.labtel.laboratorio4;

/**
 * Created by labtel on 22/10/2016.
 */
public class Contact {
    private String nombre;

    private String DNI;

    private String correo;

    private String numero;

    public Contact(String nombre, String dni, String correo, String numero) {
        this.nombre = nombre;
        this.DNI = dni;
        this.correo = correo;
        this.numero= numero;
    }
    public String toString(){
        return "Nombre : "+nombre+ "\n "+
                "DNI : "+DNI+ "\n "+
                "Correo : "+correo+ "\n "+
                "Numero : "+numero+ "\n ";

    }
    public String toStringShort(){
        return "Nombre : "+nombre+ "\n"+

                "Numero : "+numero+ "\n ";

    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
