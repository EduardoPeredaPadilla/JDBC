package Services;

// import java.text.SimpleDateFormat;
import java.util.Collection;
// import java.util.Scanner;
// import java.util.Date;

import Entities.Casa;
import Entities.Cliente;
import Entities.DatosParaRegistro;
import Entities.Estancia;
import Persistence.EstanciaDAO;

public class EstanciaService {
    
    private EstanciaDAO dao;

    public EstanciaService() {
        this.dao = new EstanciaDAO();
    }

    //Inciso J)
    public void mostrarEstancias() throws Exception{
        try {
            Collection<Estancia> estancias = dao.mostrarEstancias();
            if (estancias.isEmpty()) {
                throw new Exception("No hay estancias registradas");
            } else {
                for (Estancia estancia : estancias) {
                    System.out.println(estancia.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    //Agregar Estancia
    public void agregarEstancia(Casa casa, Cliente cliente, DatosParaRegistro registro) throws Exception {
        // Scanner scan = new Scanner(System.in);
        try {
            Estancia estancia = new Estancia();
            estancia.setIdCliente(cliente.getId());
            estancia.setIdCasa(casa.getId());
            estancia.setNombreHuesped(cliente.getNombre());
            // Date fecha1 = new Date(registro.getFechaDesde());
            // Date fecha2 = new Date(registro.getFechaHasta());
            estancia.setFechaDesde(registro.getFechaDesde());
            estancia.setFechaHasta(registro.getFechaHasta());
            dao.addEstancia(estancia);
        } catch (Exception e) {
            throw e;
        }
    }
}
