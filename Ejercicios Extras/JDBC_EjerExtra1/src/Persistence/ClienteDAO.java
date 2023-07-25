package Persistence;

import java.util.ArrayList;
import java.util.Collection;

import Entities.Cliente;

public class ClienteDAO extends DAO {
    //Método para inciso e
    public Collection<Cliente> mostrarClientes() throws Exception {
        try {
            String sql = "SELECT id_cliente, nombre FROM clientes;";
            consultarBase(sql);
            Cliente cliente = null;
            Collection<Cliente> clientes = new ArrayList<>();
            while (resultado.next()) {
                cliente = new Cliente();
                cliente.setId(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                clientes.add(cliente);
            }
            desconectarBase();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    public Cliente buscarClientPorID(int id_cliente) throws Exception {
        try {
            String sql = "SELECT id_cliente, nombre FROM clientes WHERE id_cliente = " + id_cliente + ";";
            consultarBase(sql);
            Cliente cliente = null;
            while (resultado.next()) {
                cliente = new Cliente();
                cliente.setId(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
            }
            desconectarBase();
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    public void addCliente(Cliente cliente) throws Exception {
        try {
            if (cliente == null) {
                throw new Exception("Debes indicar el cliente a agregar");
            }
            String sql = "INSERT INTO clientes (nombre, calle, numero, codigo_postal, ciudad, pais, email) VALUES('" + cliente.getNombre() + "', '" + cliente.getCalle() + "', " + cliente.getNumero() + ", '" + cliente.getCodigoPostal() + "', '" + cliente.getCiudad() + "', '" + cliente.getPais() + "', '" + cliente.getEmail() + "');";
            insertarModificarEliminar(sql);
            desconectarBase();
        } catch (Exception e) {
            throw e;
        }
    }
}