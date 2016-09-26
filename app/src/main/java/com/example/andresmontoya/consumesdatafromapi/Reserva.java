package com.example.andresmontoya.consumesdatafromapi;

import java.util.Date;

/**
 * Created by andres.montoya on 26/09/2016.
 */

public class Reserva {

    public String vuelo;
    public String asiento;
    public String cliente;
    public String fecha;

    public Reserva() {
    }

    public Reserva(String fecha, String cliente, String asiento, String vuelo) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.asiento = asiento;
        this.vuelo = vuelo;
    }

    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
