package Persistence;

import java.util.ArrayList;
import java.util.Collection;

import Entities.EstadisticaConteo;

public class EstContDAO extends DAO {
    
    //Método inciso H)
    public Collection<EstadisticaConteo> totalCasasPorPais() throws Exception {
        try {
            String sql = "SELECT pais, COUNT(*) FROM casas GROUP BY pais;";
            consultarBase(sql);
            EstadisticaConteo est = null;
            Collection<EstadisticaConteo> estConteos = new ArrayList<>();
            while (resultado.next()) {
                est = new EstadisticaConteo();
                est.setPais(resultado.getString(1));
                est.setTotalCasas(resultado.getInt(2));
                estConteos.add(est);
            }
            desconectarBase();
            return estConteos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}
