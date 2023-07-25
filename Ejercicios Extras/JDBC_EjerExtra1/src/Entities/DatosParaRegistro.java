package Entities;

import java.util.Date;

public class DatosParaRegistro {
    
    private Date fechaDesde;
    private Date fechaHasta;
    private int numDias;


    public DatosParaRegistro() {
    }

    public DatosParaRegistro(Date fechaDesde, Date fechaHasta, int numDias) {
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.numDias = numDias;
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

    public int getNumDias() {
        return this.numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

}
