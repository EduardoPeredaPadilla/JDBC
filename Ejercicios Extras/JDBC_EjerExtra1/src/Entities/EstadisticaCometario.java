package Entities;

public class EstadisticaCometario {
    
    private Casa casa;
    private Comentario comentario;


    public EstadisticaCometario() {
    }

    public EstadisticaCometario(Casa casa, Comentario comentario) {
        this.casa = casa;
        this.comentario = comentario;
    }

    public Casa getCasa() {
        return this.casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public Comentario getComentario() {
        return this.comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Estadística de comentario [ " +
            getCasa() + " " +
            getComentario() +
            " ]";
    }

}
