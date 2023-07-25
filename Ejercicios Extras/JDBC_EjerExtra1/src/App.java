import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entities.Casa;
import Entities.Cliente;
import Entities.DatosParaRegistro;
import Services.CasaService;
import Services.ClienteService;
import Services.ComentarioService;
// import Services.DatosParaRegistroService;
import Services.EstComentService;
import Services.EstConteoService;
import Services.EstService;
import Services.EstanciaService;
import Services.FamiliaService;

public class App {
    public static void main(String[] args) throws Exception {
        
        Menu();
    }

    public static void Menu() throws Exception {

        FamiliaService famServ = new FamiliaService();
        CasaService casaServ = new CasaService();
        ClienteService clienteServ = new ClienteService();
        EstService estServ = new EstService();
        EstConteoService estConteoServ = new EstConteoService();
        EstComentService estComentServ = new EstComentService();
        EstanciaService estanciaServ = new EstanciaService();
        ComentarioService comentServ = new ComentarioService();
        // DatosParaRegistroService regServ = new DatosParaRegistroService();
        DatosParaRegistro registro = new DatosParaRegistro();


        Scanner scan = new Scanner(System.in);
        int resp;

        System.out.println("");
        System.out.println("Menu Estancias en el Extranjero");
        System.out.println("");
        System.out.println("1. Mostrar Estantcias");
        System.out.println("2. Mostrar Familias");
        System.out.println("3. Mostrar Clientes");
        System.out.println("4. Mostrar Casas");
        System.out.println("5. Mostrar Comentarios");
        System.out.println("6. Agregar Cliente");
        System.out.println("7. Consultar Disponibilidad de Casas por fecha y úmero de días");
        System.out.println("8. Mostrar famiulias con al menos 3 hijos y edad máxima inferior a 10 años");
        System.out.println("9. Buscar y mostrar Casas disponibles para el mes de agosto del 2020 en Reino unido");
        System.out.println("10. Mostrar Familias con correo de Hotmail");
        System.out.println("11. Mostrar datos de clientes que realizaron alguna estancia y la descripción de la casa");
        System.out.println("12. Mostrar todas las estancias  con datos de cleintes e información de las casas");
        System.out.println("13. Icrementar precio pro habitación en eun 5% para las casa de Reino Unido por devaluación");
        System.out.println("14. Buscar y mostrar casas de Reino unido con comentraios acerca que están limpias");
        System.out.println("15. Mostrar número de casas por Pais");
        System.out.println("16. Salir");
        System.out.println("");
        System.out.println("Ingresa la opción deseada");

        try {
            resp = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Opción inválida");
            System.out.println("Intenta nuevamente");
            //scan.close();
            Menu();
            return;
        }

        switch (resp) {
            case 1:
                System.out.println("Opción 1. Mostrar Estancias");
                try {
                    estanciaServ.mostrarEstancias();
                    //scan.close();
                    Menu();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                    //scan.close();
                    Menu();
                    return;
                }
                break;
            case 2:
                System.out.println("Opción 2. Mostrar Familias");
                try {
                    famServ.mostrarFamilias();
                    //scan.close();
                    Menu();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                    //scan.close();
                    Menu();
                    return;
                }
                break;
            case 3:
                System.out.println("Opción 3. Mostrar Clientes");
                try {
                    clienteServ.mostrarCliente();
                    //scan.close();
                    Menu();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                    //scan.close();
                    Menu();
                    return;
                }
                break;
            case 4:
                System.out.println("Opción 4. Mostrar Casas");
                try {
                    casaServ.mostrarTodasLasCasas();
                    //scan.close();
                    Menu();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                    //scan.close();
                    Menu();
                    return;
                }
                break;
            case 5:
                System.out.println("Opción 5. Mostrar Comentarios");
                try {
                    comentServ.MostrarCometarios();
                    //scan.close();
                    Menu();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                    //scan.close();
                    Menu();
                    return;
                }
                break;
            case 6:
                System.out.println("Opción 6. Agregar Cliente");
                try {
                    String nombre = "Eduardo Pereda";
                    String calle = "Las Cassa";
                    int numero = 2;
                    String codigo_postal = "62000";
                    String ciudad = "Cuernavaca";
                    String pais = "México";
                    String email = "eduardoperedapadilla@gmail.com";
                    clienteServ.createAddCliente(nombre, calle, numero, codigo_postal, ciudad, pais, email);
                    //scan.close();
                    Menu();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                    //scan.close();
                    Menu();
                    return;
                }
                break;
            case 7:
                System.out.println("Opción 7. Consultar Disponibilidad de Casas por fecha y número de días");
                int regEst;
                int id_cliente;
                int id_casa;
                
                try {
                    
                    Collection<Casa> casas = casaServ.mostrarCasasD(registro);
                    System.out.println("Deseas registrar una estancia?");
                    System.out.println("1. Si");
                    System.out.println("2. No");
                    System.out.println("Ingresa tu respuesta");
                    try {
                        regEst = scan.nextInt();
                    } catch (InputMismatchException ie) {
                        System.out.println("Opción inválida");
                        //scan.close();
                        Menu();
                        return;
                    }
                    switch (regEst) {
                        case 1:
                            System.out.println("Registrar Estancia");
                            System.out.println("Ingresa el ID de la casa para el registro de la estancia");
                            try {
                                id_casa = scan.nextInt();
                            } catch (InputMismatchException ie) {
                                System.out.println("Opción inválida");
                                //scan.close();
                                Menu();
                                return;
                            }
                            Collection<Cliente> clientes = clienteServ.mostrarCliente();
                            System.out.println("Inrese el id del cliente que desea la estancia");
                            try {
                                id_cliente = scan.nextInt();
                            } catch (InputMismatchException ie) {
                                System.out.println("Opción inválida");
                                //scan.close();
                                Menu();
                                return;
                            }
                            clienteServ.clienteParaEstancia(id_cliente, clientes, casas, registro, id_casa);
                            //scan.close();
                            Menu();
                            break;
                        case 2:
                            System.out.println("Regresar");
                            Menu();
                            break;
                        default:
                            break;
                    }
                    Menu();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                    //scan.close();
                    Menu();
                    return;
                }
                break;
            case 8:
                System.out.println("Opción 8. Mostrar famiulias con al menos 3 hijos y edad máxima inferior a 10 años");
                try {
                    famServ.mostrarFamiliasA();
                    //scan.close();
                    Menu();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                    //scan.close();
                    Menu();
                    return;
                }
                break;
            case 9:
                System.out.println("Opción 9. Buscar y mostrar Casas disponibles para el mes de agosto del 2020 en Reino unido");
                try {
                    casaServ.mostrarCasasB();
                    //scan.close();
                    Menu();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                    //scan.close();
                    Menu();
                    return;
                }
                break;
            case 10:
                System.out.println("Opción 10. Mostrar Familias con correo de Hotmail");
                try {
                    famServ.mostrarFamiliasC();
                    //scan.close();
                    Menu();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                    //scan.close();
                    Menu();
                    return;
                }
                break;
            case 11:
                System.out.println("Opción 11. Mostrar datos de clientes que realizaron alguna estancia y la descripción de la casa");
                try {
                    estServ.mostrarEstE();
                    //scan.close();
                    Menu();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                    //scan.close();
                    Menu();
                    return;
                }
                break;
            case 12:
                System.out.println("Opción 12. Mostrar todas las estancias  con datos de cleintes e información de las casas");
                try {
                    estServ.mostrarEstF();
                    //scan.close();
                    Menu();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                    //scan.close();
                    Menu();
                    return;
                }
                break;
            case 13:
                System.out.println("Opción 13. Icrementar precio pro habitación en eun 5% para las casa de Reino Unido por devaluación");
                try {
                    casaServ.cambiarPrecio();
                    //scan.close();
                    Menu();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                    //scan.close();
                    Menu();
                    return;
                }
                break;
            case 14:
                System.out.println("Opción 14. Buscar y mostrar casas de Reino unido con comentraios acerca que están limpias");
                try {
                    estComentServ.estComentCasas();
                    //scan.close();
                    Menu();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                    //scan.close();
                    Menu();
                    return;
                }
                break;
            case 15:
                System.out.println("Opción 15. Mostrar número de casas por Pais");
                try {
                    estConteoServ.conteoCasasPorPais();
                    //scan.close();
                    Menu();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                    //scan.close();
                    Menu();
                    return;
                }
                break;
            case 16:
                System.out.println("Opción 16. Salir");
                System.out.println("hasta pronto!");
                //scan.close();
                break;
            default:
                System.out.println("Elige una oçicón valida del menú");
                //scan.close();
                Menu();
                break;
        }
    }
}
