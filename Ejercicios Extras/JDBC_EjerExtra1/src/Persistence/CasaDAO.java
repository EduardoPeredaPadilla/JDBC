package Persistence;

import java.util.ArrayList;
import java.util.Collection;

import Entities.Casa;

public class CasaDAO extends DAO {
    
    //Método para inciso b)
    public Collection<Casa> mostrarCasaB() throws Exception {
        try {
            String sql = "SELECT * FROM casas WHERE fecha_desde >= '2020-08-01' AND fecha_hasta <= '2020-08-31' AND pais = 'Reino Unido';";
            consultarBase(sql);
            Casa casa = null;
            Collection<Casa> casas = new ArrayList<>();
            while (resultado.next()) {
                casa = new Casa();
                casa.setId(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getDate(7));
                casa.setFechaHasta(resultado.getDate(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }
            desconectarBase();
            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    //Método para inciso d)
    public Collection<Casa> mostrarCasasD(String fechaDesde, int numDias) throws Exception {
        try {
            String sql = "SELECT * FROM casas WHERE fecha_desde <= '" + fechaDesde + "' AND fecha_hasta >= DATE_ADD('" + fechaDesde + "', INTERVAL " + numDias + " DAY) AND tiempo_maximo >= " + numDias + ";";
            consultarBase(sql);
            Casa casa = null;
            Collection<Casa> casas = new ArrayList<>();
            while (resultado.next()) {
                casa = new Casa();
                casa.setId(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getDate(7));
                casa.setFechaHasta(resultado.getDate(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }
            desconectarBase();
            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    //Método para Inciso G)
    public void cambiarPrecioHab() throws Exception {
        try {
            String sql = "UPDATE casas cs SET cs.precio_habitacion = cs.precio_habitacion * 1.05 WHERE cs.pais = 'Reino unido';";
            insertarModificarEliminar(sql);
            desconectarBase();
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    public Collection<Casa> mostrarTodasLasCasas() throws Exception {
        try {
            String sql = "SELECT * FROM casas;";
            consultarBase(sql);
            Casa casa = null;
            Collection<Casa> casas = new ArrayList<>();
            while (resultado.next()) {
                casa = new Casa();
                casa.setId(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getDate(7));
                casa.setFechaHasta(resultado.getDate(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }
            desconectarBase();
            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    

}
