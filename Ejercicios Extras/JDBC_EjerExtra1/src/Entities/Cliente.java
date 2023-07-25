package Entities;

public class Cliente {
    
    private int id;
    private String nombre;
    private String calle;
    private int numero;
    private String codigoPostal;
    private String ciudad;
    private String pais;
    private String email;


    public Cliente() {
    }

    public Cliente(String nombre, String calle, int numero, String codigoPostal, String ciudad, String pais, String email) {
        this.nombre = nombre;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.pais = pais;
        this.email = email;    
    }


    public Cliente(int id, String nombre, String calle, int numero, String codigoPostal, String ciudad, String pais, String email) {
        this.id = id;
        this.nombre = nombre;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.pais = pais;
        this.email = email;
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

    public String getCalle() {
        return this.calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente [");
        if (id != 0) {
            sb.append("ID = ").append(id + " ");
        }
        if (nombre != null) {
            sb.append("Nombre = ").append(nombre + " ");
        }
        if (calle != null) {
            sb.append("Calle = ").append(calle + " ");
        }
        if (numero != 0) {
            sb.append("Número = ").append(numero + " ");
        }
        if (codigoPostal != null) {
            sb.append("CP = ").append(codigoPostal + " ");
        }
        if (ciudad != null) {
            sb.append("Ciudad = ").append(ciudad + " ");
        }
        if (pais != null) {
            sb.append("Pais = ").append(pais + " ");
        }
        if (email != null) {
            sb.append("Email = ").append(email + " ");
        }
        sb.append("]");
        return sb.toString();
    }

}
