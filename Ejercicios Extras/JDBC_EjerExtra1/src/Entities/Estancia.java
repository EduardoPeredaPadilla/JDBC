package Entities;

import java.util.Date;

public class Estancia {
    
    private int id;
    private int idCliente;
    private int idCasa;
    private String nombreHuesped;
    private Date fechaDesde;
    private Date fechaHasta;


    public Estancia() {
    }

    public Estancia(int idCliente, int idCasa, String nombreHuesped, Date fechaDesde, Date fechaHasta) {
        this.idCliente = idCliente;
        this.idCasa = idCasa;
        this.nombreHuesped = nombreHuesped;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public Estancia(int id, int idCliente, int idCasa, String nombreHuesped, Date fechaDesde, Date fechaHasta) {
        this.id = id;
        this.idCliente = idCliente;
        this.idCasa = idCasa;
        this.nombreHuesped = nombreHuesped;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCasa() {
        return this.idCasa;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public String getNombreHuesped() {
        return this.nombreHuesped;
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }

    public Date getFechaDesde() {
        return this.fechaDesde;
    }
    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }


    public Date getFechaHasta() {
        return this.fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estancia [");
        if (id != 0) {
            sb.append("ID = ").append(id + " ");
        }
        if (idCliente != 0) {
            sb.append("ID Cliente= ").append(idCliente + " ");
        }
        if (idCasa != 0) {
            sb.append("ID Casa = ").append(idCasa + " ");
        }
        if (nombreHuesped != null) {
            sb.append("Nombre Huesped = ").append(nombreHuesped + " ");
        }
        if (fechaDesde != null) {
            sb.append("Fecha desde = ").append(fechaDesde + " ");
        }
        if (fechaHasta != null) {
            sb.append("Fecha hasta = ").append(fechaHasta + " ");
        }
        sb.append("]");
        return sb.toString();
    }

}
