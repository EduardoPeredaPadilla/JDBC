package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;

import tienda.entidades.Fabricante;

public class FabricanteDAO extends DAO {
    
    //Método para insertar un fabricante en la tabla fabricante de la DB tienda
    public void agregarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debes indicar un fabricante");
            }
            //Generamos la consulta con Sintaxis nativa de SQL
            String sql = "INSERT INTO fabricante (nombre)"
                + "VALUES ('" + fabricante.getNombre() + "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    //Método para eliminar un fabricante en la tabla producto de la DB tienda
    public void eliminarProducto(String nombre) throws Exception {
        try {
            if (nombre == null) {
                throw new Exception("Debes indicar el fabricante a eliminar");
            }
            //Generamos la consulta con Sintaxis nativa de SQL
            String sql = "DELETE FROM fabricante WHERE nombre = " + nombre + "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    //Método para bscar Fabricante por nombre
    public Fabricante buscarFabricante(String nombre) throws Exception {
        try {
            if (nombre == null) {
                throw new Exception("Debes indiar un fabricante para buscarlo");
            }
            String sql = "SELECT * FROM fabricante"
                + "WHERE nombre = " + nombre + "';";
            consultarBase(sql);
            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Integer> codigosFabricantes() throws Exception {
        try {
            String sql = "SELECT codigo FROM fabricante";
            consultarBase(sql);
            Collection<Integer> codigos = new ArrayList<>();
            while (resultado.next()) {
                codigos.add(resultado.getInt(1));
            }
            desconectarBase();
            return codigos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

}
