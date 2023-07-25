package Entities;

public class EstadisticaConteo {
    
    private String pais;
    private int totalCasas;


    public EstadisticaConteo() {
    }

    public EstadisticaConteo(String pais, int totalCasas) {
        this.pais = pais;
        this.totalCasas = totalCasas;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getTotalCasas() {
        return this.totalCasas;
    }

    public void setTotalCasas(int totalCasas) {
        this.totalCasas = totalCasas;
    }

    @Override
    public String toString() {
        return "Estadísticas Casas por Pais [" +
            " Pais = " + getPais() +
            " Total de Casas = " + getTotalCasas() + " ]";
    }


}
