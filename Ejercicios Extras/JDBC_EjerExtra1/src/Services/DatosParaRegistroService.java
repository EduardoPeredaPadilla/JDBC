package Services;


import java.util.Date;

import Entities.DatosParaRegistro;

public class DatosParaRegistroService {
    
    public DatosParaRegistro nuevoRegistro(Date fechaDesde, Date fechaHasta, int numDias) throws Exception {
        DatosParaRegistro registro = new DatosParaRegistro(fechaDesde, fechaHasta, numDias);
        return registro;
    }

}
