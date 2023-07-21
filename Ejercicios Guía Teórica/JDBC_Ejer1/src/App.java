import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;

//import tienda.entidades.Producto;
import tienda.services.FabricanteService;
import tienda.services.ProductoService;

public class App {
    public static void main(String[] args) throws Exception {
        

        // ProductoService prodServ = new ProductoService();
        // String nombre = "AS50";
        // double precio = 150;
        // prodServ.findAndModify(nombre, precio);
        Menu();  

    }

    public static void Menu() throws Exception {

        //Scanner scan = new Scanner(System.in).useDelimiter("\n");
        Scanner scan = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        FabricanteService fabServ = new FabricanteService();
        ProductoService prodServ = new ProductoService();
        int resp;

        System.out.println("");
        System.out.println("Menu de Tienda");
        System.out.println("");
        System.out.println("1. Mostar todos los productos de la tienda");
        System.out.println("2. Mostrrar los productos de precio entre $120.00 y $202.00");
        System.out.println("3. Mostrar los productos portátiles");
        System.out.println("4. Mostrar el producto más barato");
        System.out.println("5. Ingresar un nuevo producto");
        System.out.println("6. Ingresar un nuevo Fabricante");
        System.out.println("7. Modificar el precio de un producto");
        System.out.println("8. Salir");
        System.out.println("");
        System.out.println("Ingresa la opción deseada");
        
        try {
            resp = scanInt.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ingresa el número de la opción deseada");
            Menu();
            return;
        }

        if (resp < 1 || resp > 8) {
            System.out.println("Opción inválida");
            Menu();
            return;
        } else {
            switch (resp) {
                case 1:
                    try {
                        prodServ.imprimirProductos();
                        Menu();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                        Menu();
                        return;
                    }
                    break;
                case 2:
                    try {
                        prodServ.mostrarProductosRangoPrecio();
                        Menu();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                        Menu();
                        return;
                    }
                    break;
                case 3:
                    try {
                        prodServ.mostrarProductosPortatiles();
                        Menu();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                        Menu();
                        return;
                    }
                    break;
                case 4:
                    try {
                        prodServ.productoMasBarato();
                        Menu();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                        Menu();
                        return;
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Ingresa el nombre del nuevo producto");
                        String nombre = scan.next();
                        System.out.println("Ingrese el precio del producto");
                        double precio = scanInt.nextDouble();
                        System.out.println("Ingrese el código del fabricante");
                        int codigoFabricante = scanInt.nextInt();
                        prodServ.addProducto(nombre, precio, codigoFabricante);
                        Menu();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                        Menu();
                        return;
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Ingrese el nombre del nuevo fabricante");
                        String nombre = scan.next();
                        fabServ.addFabricante(nombre);
                        Menu();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                        Menu();
                        return;
                    }
                    break;
                case 7:
                    try {
                        System.out.println("Ingrese el nombre dl producto a modificar el precio");
                        String nombre = scan.next();
                        //String nombre = "AS50";
                        System.out.println("Ingrese el nuevo precio del producto");
                        double precio = scanInt.nextDouble();
                        //double precio = 166;
                        prodServ.findAndModify(nombre, precio);
                        Menu();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                        Menu();
                        return;
                    }
                    break;
                default:
                    System.out.println("Hasta pronto!");
                    break;
            }
        }
        //scan.close();
    }

}
