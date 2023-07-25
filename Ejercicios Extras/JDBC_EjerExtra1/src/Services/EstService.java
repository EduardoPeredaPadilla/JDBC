package Services;

import java.util.Collection;

import Entities.Estadistica;
import Persistence.EstadisticaDAO;

public class EstService {
    
    private EstadisticaDAO dao;

    public EstService() {
        this.dao = new EstadisticaDAO();
    }

    public void mostrarEstE() throws Exception {
        try {
            Collection<Estadistica> estadisticas = dao.ConsultaIncisoE();
            if (estadisticas.isEmpty()) {
                throw new Exception("Sin estadísticas en esta consulta");
            } else {
                for (Estadistica estadistica : estadisticas) {
                    System.out.println(estadistica.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void mostrarEstF() throws Exception {
        try {
            Collection<Estadistica> estadisticas = dao.ConsultaInciso_F();
            if (estadisticas.isEmpty()) {
                throw new Exception("Sin estadísticas en esta consulta");
            } else {
                for (Estadistica estadistica : estadisticas) {
                    System.out.println(estadistica.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
