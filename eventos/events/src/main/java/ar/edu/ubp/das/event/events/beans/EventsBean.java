package ar.edu.ubp.das.event.events.beans;

import java.sql.Date;

public class EventsBean {

    private int nroEvento;
    private String nomEvento;
    private Date fechaEvento;
    private String descEvento;
    private String tipoEvento;

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getDescEvento() {
        return descEvento;
    }

    public void setDescEvento(String descEvento) {
        this.descEvento = descEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNroEvento() {
        return nroEvento;
    }

    public void setNroEvento(int nroEvento) {
        this.nroEvento = nroEvento;
    }

    public String getNomEvento() {
        return nomEvento;
    }

    public void setNomEvento(String nomEvento) {
        this.nomEvento = nomEvento;
    }
}
