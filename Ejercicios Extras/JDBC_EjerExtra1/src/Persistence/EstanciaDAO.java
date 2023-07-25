package Persistence;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import Entities.Estancia;

public class EstanciaDAO extends DAO {
    
    //Método Iniso J)
    public Collection<Estancia> mostrarEstancias() throws Exception{
        try {
            String sql = "SELECT * FROM estancias;";
            consultarBase(sql);
            Estancia est = null;
            Collection<Estancia> estancias = new ArrayList<>();
            while (resultado.next()) {
                est = new Estancia();
                est.setId(resultado.getInt(1));
                est.setIdCliente(resultado.getInt(2));
                est.setIdCasa(resultado.getInt(3));
                est.setNombreHuesped(resultado.getString(4));
                est.setFechaDesde(resultado.getDate(5));
                est.setFechaHasta(resultado.getDate(6));
                estancias.add(est);
            }
            desconectarBase();
            return estancias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    //Agregar Estancia Inciso J
    public void addEstancia(Estancia estancia) throws Exception {
        try {
            if (estancia == null) {
                throw new Exception("Ingres una estancia");
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaDesde = dateFormat.format(estancia.getFechaDesde());
            String fechaHasta = dateFormat.format(estancia.getFechaHasta());
            String sql = "INSERT INTO estancias (id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta) VALUES(" + estancia.getIdCliente() + "," + estancia.getIdCasa() + ", '" + estancia.getNombreHuesped() + "', '" + fechaDesde + "', '" + fechaHasta + "');";
            insertarModificarEliminar(sql);
            desconectarBase();
        } catch (Exception e) {
            throw e;
        }
    }
}
