package tienda.services;

import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;
import java.util.Collection;

public class ProductoService {
    
    private ProductoDAO dao;

    public ProductoService() {
        this.dao = new ProductoDAO();
    }


    public void addProducto(String nombre, double precio, int codigoFabricante ) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                System.out.println("Dentro ProdServ If 1");
                throw new Exception("Debes indicar el nombre del producto");
            }
            if (precio == 0) {
                System.out.println("Dentro ProdServ If 2");
                throw new Exception("Debes indicar el precio del producto");
            }
            if (codigoFabricante == 0) {
                System.out.println("Dentro ProdServ If 3");
                throw new Exception("Debes indicar el fabricante del producto");
            }
            if (dao.buscarProductoPorNombre(nombre) != null) {
                System.out.println("Dentro ProdServ If 4");
                throw new Exception("El producto " + nombre + "ya existe");
            }
            FabricanteService fabServ = new FabricanteService();
            if (!fabServ.codigosFabricantes(codigoFabricante)) {
                System.out.println("Dentro ProdServ If 5");
                throw new Exception("El codigo de Fabricante ingresado no existe");
            }
            System.out.println("Dentro ProdServ fuera de los If");
            Producto producto = new Producto(nombre, precio, codigoFabricante);
            dao.agregarProducto(producto);
        } catch (Exception e) {
        }
    }

    public void findAndModify(String nombre, double precio) throws Exception {
        Producto producto = dao.buscarProductoPorNombre(nombre);
        producto.setPrecio(precio);
        dao.modificarProducto(producto);
    }

    public Collection<Producto> listaProductos() throws Exception {
        try {
            Collection<Producto> productos = dao.listarProductos();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductos() throws Exception {
        try {
            Collection<Producto> productos = listaProductos();
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para mostrar");
            } else {
                for (Producto producto : productos) {
                    System.out.println(producto.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void mostrarProductosRangoPrecio() throws Exception {
        try {
            Collection<Producto> productos = dao.mostrarProductosRangoPrecio();
            if (productos.isEmpty()) {
                throw new Exception("No hay productos en este rango de precio");
            } else {
                for (Producto producto : productos) {
                    System.out.println(producto.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void mostrarProductosPortatiles() throws Exception {
        try {
            Collection<Producto> productos = dao.mostrarProductosPortatiles();
            if (productos.isEmpty()) {
                throw new Exception("No hay productos portátiles");
            } else {
                for (Producto producto : productos) {
                    System.out.println(producto.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void productoMasBarato() throws Exception {
        try {
            Collection<Producto> productos = dao.mostrarProductoMasBarato();
            if (productos.isEmpty()) {
                throw new Exception("No hay productos");
            } else {
                for (Producto producto : productos) {
                    System.out.println(producto.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarPrecioProduto(String nombre, double precio) throws Exception {

        Producto producto = dao.buscarProductoPorNombre(nombre);
        producto.setPrecio(precio);
        dao.modificarProducto(producto);
        // try {
        //     System.out.println("En el Service dentro del try");
        //     if (nombre == null || nombre.trim().isEmpty()) {
        //         throw new Exception("Debes indicar el nombre del producto a modificar");
        //     }
        //     System.out.println("En el Service dentro del try, paso el primer if");
        //     if (precio == 0) {
        //         throw new Exception("Debes indicar el nuevo precio del producto");
        //     }
        //     System.out.println("En el Service dentro del try, paso el segundo if");
        //     System.out.println(nombre);
        //     System.out.println("Antes de llamar al dao.modificar");
        //     Producto producto = dao.buscarProductoPorNombre(nombre);
        //     producto.setPrecio(precio);
        //     dao.modificarProducto(producto);
        // } catch (Exception e) {
        //     throw e;
        // }
    }

}
