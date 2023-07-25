package Entities;

public class Estadistica {
    
    private Casa casa;
    private Cliente cliente;
    private Comentario comentario;
    private Estancia estancia;
    private Familia familia;


    public Estadistica() {
    }

    public Estadistica(Casa casa, Cliente cliente, Comentario comentario, Estancia estancia, Familia familia) {
        this.casa = casa;
        this.cliente = cliente;
        this.comentario = comentario;
        this.estancia = estancia;
        this.familia = familia;
    }

    public Casa getCasa() {
        return this.casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Comentario getComentario() {
        return this.comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Estancia getEstancia() {
        return this.estancia;
    }

    public void setEstancia(Estancia estancia) {
        this.estancia = estancia;
    }

    public Familia getFamilia() {
        return this.familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estadísticas [");
        if (cliente != null) {
            sb.append(" " + cliente);
        }
        if (estancia != null) {
            sb.append(" " + estancia);
        }
        if (casa != null) {
            sb.append(" " + casa);
        }
        
        if (comentario != null) {
            sb.append(" " + comentario);
        }
        
        if (familia != null) {
            sb.append(" " + familia);
        }
        sb.append("]");
        return sb.toString();
    }


}
