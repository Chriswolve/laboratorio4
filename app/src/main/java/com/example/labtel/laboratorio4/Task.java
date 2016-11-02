package com.example.labtel.laboratorio4;

/**
 * Created by labtel on 22/10/2016.
 */
public class Task {

    private String titulo;

    private String fechaini;

    private String fechafin;

    private String descripcion;

    public Task(String titulo, String fechaini, String fechafin, String descripcion) {
        this.titulo = titulo;
        this.fechaini = fechaini;
        this.fechafin = fechafin;
        this.descripcion = descripcion;
    }
    public String toString(){
        return "titulo : "+titulo+ "\n "+
                "Fecha inicio : "+fechaini+ "\n "+
                "Fecha final : "+fechafin+ "\n "+
                "Descripcion : "+descripcion+ "\n ";

    }
    public String toStringShort(){
        return "Titulo : "+titulo+ "\n"+  fechaini+ "\n ";

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaini() {
        return fechaini;
    }

    public void setFechaini(String fechaini) {
        this.fechaini = fechaini;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}


