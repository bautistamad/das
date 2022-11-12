package ar.edu.ubp.das.event.events.beans;

import java.util.List;
import java.util.Map;

public class EventAssistant {

    private int nroEvento;
    private String nombre;
    private String apellido;
    private String correo;
    private String actividades;

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public int getNroEvento() {
        return nroEvento;
    }

    public void setNroEvento(int nroEvento) {
        this.nroEvento = nroEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
