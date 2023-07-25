package Entities;

public class Familia {
    
    private int id;
    private String nombre;
    private int edadMinima;
    private int edadMaxima;
    private int numHijos;
    private String email;
    private int idCasaFimilia;


    public Familia() {
    }

    public Familia(String nombre, int edadMinima, int edadMaxima, int numHijos, String email, int idCasaFimilia) {
        this.nombre = nombre;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.numHijos = numHijos;
        this.email = email;
        this.idCasaFimilia = idCasaFimilia;
    }

    public Familia(int id, String nombre, int edadMinima, int edadMaxima, int numHijos, String email, int idCasaFimilia) {
        this.id = id;
        this.nombre = nombre;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.numHijos = numHijos;
        this.email = email;
        this.idCasaFimilia = idCasaFimilia;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdadMinima() {
        return this.edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public int getEdadMaxima() {
        return this.edadMaxima;
    }

    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public int getNumHijos() {
        return this.numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdCasaFimilia() {
        return this.idCasaFimilia;
    }

    public void setIdCasaFimilia(int idCasaFimilia) {
        this.idCasaFimilia = idCasaFimilia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Familia [");
        if (id != 0) {
            sb.append("ID = ").append(id + " ");
        }
        if (nombre != null) {
            sb.append("Nombre = ").append(nombre + " ");
        }
        if (edadMinima != 0) {
            sb.append("Edad Mínima = ").append(edadMinima + " ");
        }
        if (edadMaxima != 0) {
            sb.append("Edad Máxima = ").append(edadMaxima + " ");
        }
        if (numHijos != 0) {
            sb.append("Número de hijos = ").append(numHijos + " ");
        }
        if (email != null) {
            sb.append("Email = ").append(email + " ");
        }
        if (idCasaFimilia != 0) {
            sb.append("ID Casa Familia= ").append(idCasaFimilia + " ");
        }
        sb.append("]");
        return sb.toString();
    }


}
