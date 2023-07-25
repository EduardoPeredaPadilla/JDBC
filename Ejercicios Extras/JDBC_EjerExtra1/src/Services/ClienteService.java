package Services;

import java.util.Collection;

import Entities.Casa;
import Entities.Cliente;
import Entities.DatosParaRegistro;
import Persistence.ClienteDAO;

public class ClienteService {
    
    private ClienteDAO dao;

    public ClienteService() {
        this.dao = new ClienteDAO();
    }

    public Collection<Cliente> mostrarCliente() throws Exception {
        try {
            
            Collection<Cliente> clientes = dao.mostrarClientes();
            if (clientes.isEmpty()) {
                throw new Exception("No existen clientes con esta consulta");
            } else {
                for (Cliente cliente : clientes) {
                    System.out.println(cliente.toString());
                }
                return clientes;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void clienteParaEstancia(int id_cliente, Collection<Cliente> clientes, Collection<Casa> casas, DatosParaRegistro registro, int id_casa) throws Exception {
        try {
            EstanciaService estanciaServ = new EstanciaService();
            Cliente cliente = null;
            Casa casa = null;
            int conteo = 0;
            int contCasas = 0;
            for (Cliente client : clientes) {
                if (client.getId() == id_cliente) {
                    cliente = new Cliente();
                    cliente.setId(client.getId());
                    cliente.setNombre(client.getNombre());
                } else {
                    conteo++;
                }
            }
            if (conteo == clientes.size()) {
                System.out.println("El Id de cliente ingresado no existe, verifica e intenta nuevamente");
                return;
            } 
            for (Casa cas : casas) {
                if (cas.getId() == id_casa) {
                    casa = new Casa();
                    casa.setId(id_casa);
                    estanciaServ.agregarEstancia(casa, cliente, registro);
                } else {
                    contCasas++;
                }
            }
            if (contCasas == casas.size()) {
                System.out.println("El id de la casa no exiiste intenta nuevamente");
                return;
            }
            
            
        } catch (Exception e) {
            throw e;
        }
    }

    public void createAddCliente(String nombre, String calle, int numero, String codigo_postal, String ciudad, String pais, String email) throws Exception{
        try {
            if (nombre == null) {
                throw new Exception("Debes indicar el nombre del cliente");
            }
            if (calle == null) {
                throw new Exception("Debes indicar la calle del cliente");
            }
            if (numero == 0) {
                throw new Exception("Debes indicar el número del cliente");
            }
            if (codigo_postal == null) {
                throw new Exception("Debes indicar el CP del cliente");
            }
            if (ciudad == null) {
                throw new Exception("Debes indicar la ciudad del cliente");
            }
            if (pais == null) {
                throw new Exception("Debes indicar el pais del cliente");
            }
            if (email == null) {
                throw new Exception("Debes indicar el email del cliente");
            }

            Cliente cliente = new Cliente(nombre, calle, numero, codigo_postal, ciudad, pais, email);
            // cliente.setNombre("Eduardo Pereda");
            // cliente.setCalle("Las Casas");
            // cliente.setNumero(2);
            // cliente.setCodigoPostal("62000");
            // cliente.setCiudad("Cuernavaca");
            // cliente.setPais("México");
            // cliente.setEmail("eduardoperedapadilla@gmail.com");
            dao.addCliente(cliente);
        } catch (Exception e) {
            throw e;
        }
    }
}
