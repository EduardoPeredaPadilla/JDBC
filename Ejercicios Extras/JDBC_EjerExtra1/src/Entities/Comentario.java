package Entities;

public class Comentario {
    
    private int id;
    private int idCasa;
    private String comentario;


    public Comentario() {
    }

    public Comentario(int idCasa, String comentario) {
        this.idCasa = idCasa;
        this.comentario = comentario;
    }    

    public Comentario(int id, int idCasa, String comentario) {
        this.id = id;
        this.idCasa = idCasa;
        this.comentario = comentario;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCasa() {
        return this.idCasa;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comentario [");
        if (id != 0) {
            sb.append("ID = ").append(id + " ");
        }
        if (idCasa != 0) {
            sb.append("ID Casa = ").append(idCasa + " ");
        }
        if (comentario != null) {
            sb.append("Cometario = ").append(comentario + " ");
        }
        sb.append("]");
        return sb.toString();
    }

}
