package Persistence;

import java.util.ArrayList;
import java.util.Collection;


import Entities.Casa;
import Entities.Cliente;
import Entities.Estadistica;
import Entities.Estancia;

public class EstadisticaDAO extends DAO {
    

    //Método Inciso E)
    public Collection<Estadistica> ConsultaIncisoE() throws Exception {
        try {
            String sql = "SELECT c.id_cliente, c.nombre, c.ciudad, c.pais, c.email, e.id_estancia, cs.id_casa, cs.tipo_vivienda FROM clientes c LEFT JOIN estancias e ON c.id_cliente = e.id_cliente LEFT JOIN casas cs ON e.id_casa = cs.id_casa;";
            consultarBase(sql);
            Estadistica est = null;
            Cliente cliente = null;
            Estancia estancia = null;
            Casa casa = null;
            Collection<Estadistica> estadisticas = new ArrayList<>();
            while (resultado.next()) {
                est = new Estadistica();
                cliente = new Cliente();
                estancia = new Estancia();
                casa = new Casa();
                cliente.setId(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setCiudad(resultado.getString(3));
                cliente.setPais(resultado.getString(4));
                cliente.setEmail(resultado.getString(5));
                estancia.setId(resultado.getInt(6));
                casa.setId(resultado.getInt(7));
                casa.setTipoVivienda(resultado.getString(8));
                est.setCliente(cliente);
                est.setEstancia(estancia);
                est.setCasa(casa);
                estadisticas.add(est);
            }
            desconectarBase();
            return estadisticas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    //Inciso f)
    public Collection<Estadistica> ConsultaInciso_F() throws Exception {
        try {
            String sql = "SELECT e.id_estancia, c.nombre, c.ciudad, c.pais, cs.id_casa, cs.ciudad, cs.pais, cs.tipo_vivienda FROM estancias e LEFT JOIN clientes c ON e.id_cliente = c.id_cliente LEFT JOIN casas cs ON e.id_casa = cs.id_casa;";
            consultarBase(sql);
            Estadistica est = null;
            Cliente cliente = null;
            Estancia estancia = null;
            Casa casa = null;
            Collection<Estadistica> estadisticas = new ArrayList<>();
            while (resultado.next()) {
                est = new Estadistica();
                cliente = new Cliente();
                estancia = new Estancia();
                casa = new Casa();
                estancia.setId(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setCiudad(resultado.getString(3));
                cliente.setPais(resultado.getString(4));
                casa.setId(resultado.getInt(5));
                casa.setCiudad(resultado.getString(6));
                casa.setPais(resultado.getString(7));
                casa.setTipoVivienda(resultado.getString(8));
                est.setCliente(cliente);
                est.setEstancia(estancia);
                est.setCasa(casa);
                estadisticas.add(est);
            }
            desconectarBase();
            return estadisticas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}
