package Persistence;

import java.util.ArrayList;
import java.util.Collection;

import Entities.Familia;

public class FamiliaDAO extends DAO {

    //Método para mostrar la lista de las familias
    public Collection<Familia> listarFamilias() throws Exception {
        try {
            String sql = "SELECT * FROM familias;";
            consultarBase(sql);
            Familia familia = null;
            Collection<Familia> familias = new ArrayList<>();
            while (resultado.next()) {
                familia = new Familia();
                familia.setId(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdadMinima(resultado.getInt(3));
                familia.setEdadMaxima(resultado.getInt(4));
                familia.setNumHijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setIdCasaFimilia(resultado.getInt(7));
                familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    //Método para elinciso a)
    public Collection<Familia> mostrarFamiliasA() throws Exception {
        try {
            String sql = "SELECT * FROM familias WHERE num_hijos >= 3 AND edad_maxima < 10;";
            consultarBase(sql);
            Familia familia = new Familia();
            Collection<Familia> familias = new ArrayList<>();
            while (resultado.next()) {
                familia = new Familia();
                familia.setId(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdadMinima(resultado.getInt(3));
                familia.setEdadMaxima(resultado.getInt(4));
                familia.setNumHijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setIdCasaFimilia(resultado.getInt(7));
                familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    //Método para elinciso c)
    public Collection<Familia> mostrarFamiliasC() throws Exception {
        try {
            String sql = "SELECT * FROM familias WHERE email LIKE '%_hotmail_%';";
            consultarBase(sql);
            Familia familia = new Familia();
            Collection<Familia> familias = new ArrayList<>();
            while (resultado.next()) {
                familia = new Familia();
                familia.setId(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdadMinima(resultado.getInt(3));
                familia.setEdadMaxima(resultado.getInt(4));
                familia.setNumHijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setIdCasaFimilia(resultado.getInt(7));
                familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    
}
