package Services;

import java.util.Collection;

import Entities.EstadisticaConteo;
import Persistence.EstContDAO;

public class EstConteoService {
    
    public EstContDAO dao;

    public EstConteoService() {
        this.dao = new EstContDAO();
    }

    //Método Inciso H)
    public void conteoCasasPorPais() throws Exception {
        try {
            Collection<EstadisticaConteo> estConteos = dao.totalCasasPorPais();
            if (estConteos.isEmpty()) {
                throw new Exception("No hay casa registradas");
            } else {
                for (EstadisticaConteo estadisticaConteo : estConteos) {
                    System.out.println(estadisticaConteo.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }


}
