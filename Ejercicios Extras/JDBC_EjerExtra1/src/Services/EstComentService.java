package Services;

import java.util.Collection;

import Entities.EstadisticaCometario;
import Persistence.EstComentDAO;

public class EstComentService {
    

    private EstComentDAO dao;

    public EstComentService() {
        this.dao = new EstComentDAO();
    }

    //Inciso I)
    public void estComentCasas() throws Exception {
        try {
            Collection<EstadisticaCometario> estComentatios = dao.casasLimpiasRU();
            if (estComentatios.isEmpty()) {
                throw new Exception("No hay casas bajo la consulta");
            } else {
                for (EstadisticaCometario estadisticaCometario : estComentatios) {
                    System.out.println(estadisticaCometario.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
