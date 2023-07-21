package tienda.services;


import java.util.Collection;

import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public class FabricanteService {
    
    private FabricanteDAO dao;
    
    public FabricanteService() {
        this.dao = new FabricanteDAO();
    }

    public void addFabricante(String nombre) throws Exception {


        try {
            //System.out.println("Dentro de try del FabServ");
            if (nombre == null) {
                throw new Exception("Debes indicar un fabricante");
            }
            if (dao.buscarFabricante(nombre) != null) {
                throw new Exception("El fabricante " + nombre + " ya existe");
            }
            Fabricante fabricante = new Fabricante(nombre);
            //System.out.println(fabricante);
            dao.agregarFabricante(fabricante);
        } catch (Exception e) {
        }
    }

    public boolean codigosFabricantes(int codigoFabricante) throws Exception {

        Collection<Integer> codigos = dao.codigosFabricantes();
        for (Integer codigo : codigos) {
            if (codigo == codigoFabricante) {
                return true;
            }
        }
        return false;
    }

}
