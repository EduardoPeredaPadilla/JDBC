package Services;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import Entities.Casa;
import Entities.DatosParaRegistro;
import Persistence.CasaDAO;

public class CasaService {
    
    private CasaDAO dao;

    public CasaService() {
        this.dao = new CasaDAO();
    }

    public void mostrarCasasB() throws Exception {
        try {
            Collection<Casa> casas = dao.mostrarCasaB();
            if (casas.isEmpty()) {
                throw new Exception("No existen casas con esta consulta b)");
            } else {
                for (Casa casa : casas) {
                    System.out.println(casa.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Casa> mostrarCasasD(DatosParaRegistro registro) throws Exception {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Ingrese el año");
            int anio = scan.nextInt();
            System.out.println("ingrese el número de mes");
            int mes = scan.nextInt();
            System.out.println("Ingrese el día");
            int dia = scan.nextInt();
            Date fechaDesdeDate = new Date(anio - 1900, mes-1, dia);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaDesde = dateFormat.format(fechaDesdeDate);
            System.out.println("Ingrese el númerop de días que desea alojarse");
            int numDias = scan.nextInt();
            Date fechaHastaDate = new Date(anio - 1900, mes-1, dia + numDias);
            Collection<Casa> casas = dao.mostrarCasasD(fechaDesde, numDias);
            if (casas.isEmpty()) {
                throw new Exception("No existen casas con esta consulta d) FromService");
            } else {
                for (Casa casa : casas) {
                    System.out.println(casa.toString());
                }
                registro.setFechaDesde(fechaDesdeDate);
                registro.setFechaHasta(fechaHastaDate);
                registro.setNumDias(numDias);
                return casas;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    //Inciso G)
    public void cambiarPrecio() throws Exception {
        try {
            dao.cambiarPrecioHab();
            Collection<Casa> casas = dao.mostrarTodasLasCasas();
            if (casas.isEmpty()) {
                throw new Exception("No hay casa registradas");
            } else {
                for (Casa casa : casas) {
                    System.out.println(casa.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void mostrarTodasLasCasas() throws Exception {
        try {
            Collection<Casa> casas = dao.mostrarTodasLasCasas();
            if (casas.isEmpty()) {
                throw new Exception("No hay casa registradas");
            } else {
                for (Casa casa : casas) {
                    System.out.println(casa.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
