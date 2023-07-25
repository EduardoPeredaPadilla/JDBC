package Services;

import java.util.Collection;

import Entities.Familia;
import Persistence.FamiliaDAO;

public class FamiliaService {
    
    private FamiliaDAO dao;
    public FamiliaService() {
        this.dao = new FamiliaDAO();
    }

    public void mostrarFamilias() throws Exception {
        try {
            Collection<Familia> familias = dao.listarFamilias();
            if (familias.isEmpty()) {
                throw new Exception("No existen familias registradas");
            } else {
                for (Familia familia : familias) {
                    System.out.println(familia.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void mostrarFamiliasA() throws Exception {
        try {
            Collection<Familia> familias = dao.mostrarFamiliasA();
            if (familias.isEmpty()) {
                throw new Exception("No existen familias registradas con la busqueda especificada en el a)");
            } else {
                for (Familia familia : familias) {
                    System.out.println(familia.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void mostrarFamiliasC() throws Exception {
        try {
            Collection<Familia> familias = dao.mostrarFamiliasC();
            if (familias.isEmpty()) {
                throw new Exception("No existen familias registradas con la busqueda especificada en el inciso c)");
            } else {
                for (Familia familia : familias) {
                    System.out.println(familia.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
