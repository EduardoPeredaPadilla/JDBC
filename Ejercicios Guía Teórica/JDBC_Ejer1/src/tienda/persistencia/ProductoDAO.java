package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;

import tienda.entidades.Producto;

public class ProductoDAO extends DAO {
    
    //Método para insertar un producto en la tabla producto de la DB tienda
    public void agregarProducto(Producto producto) throws Exception {
         try {
             if (producto == null) {
                 throw new Exception("Debes indicar un producto, desde el ProdutoDAO");
             }
             //Generamos la consulta con Sintaxis nativa de SQL
             String sql = "INSERT INTO producto (nombre, precio, codigoFabricante)"
                + " VALUES ('" + producto.getNombre() + "'," + producto.getPrecio() + "," + producto.getCodigoFabricante() + ");";
            insertarModificarEliminar(sql);
         } catch (Exception e) {
             throw e;
         }
    }

    //Método para eliminar un producto en la tabla producto de la DB tienda
    public void eliminarProducto(String nombre) throws Exception {
        try {
            if (nombre == null) {
                throw new Exception("Debes indicar el producto a eliminar, desde el ProdutoDAO");
            }
            //Generamos la consulta con Sintaxis nativa de SQL
            String sql = "DELETE FROM producto WHERE nombre = " + nombre + "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    //Método para buscar producto por nombre
    public Producto buscarProductoPorNombre(String nombre) throws Exception {
        try {
            if (nombre == null) {
                throw new Exception("Debes indicar un nombre, desde el ProductoDAO");
            }
            String sql = "SELECT * FROM producto WHERE nombre = '" + nombre + "';";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }

    }



    //Método para buscar/mostrar muchos (n) productos en la tabla producto de la DB tienda
    public Collection<Producto> listarProductos() throws Exception {
        try {
            //Generamos la consulta con Sintaxis nativa de SQL
            String sql = "SELECT * FROM producto";
            consultarBase(sql);
            //Creamos un objeto fabricante null para después instanciarlo y agregarlos aun arraylist de Productos
            Producto producto = null;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    
    //Método para mostrar los productos de precio entre 120 y 202
    public Collection<Producto> mostrarProductosRangoPrecio() throws Exception {
        try {
            //Generamos la cobsulta
            String sql = "SELECT * FROM producto WHERE precio > 120 AND precio < 202";
            consultarBase(sql);
            //Creamos objeto y colección
            Producto producto = null;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    //Método para mostrar los productos Portátil
    public Collection<Producto> mostrarProductosPortatiles() throws Exception {
        try {
            //Generamos la cobsulta
            String sql = "SELECT * FROM producto WHERE nombre like 'Portátil_%'";
            consultarBase(sql);
            //Creamos objeto y colección
            Producto producto = null;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    //Método para mostrar los productos más barato
    public Collection<Producto> mostrarProductoMasBarato() throws Exception {
        try {
            //Generamos la cobsulta
            String sql = "SELECT * FROM producto"
                + " Order by precio LIMIT 1";
            consultarBase(sql);
            //Creamos objeto y colección
            Producto producto = null;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    //Método para editar un producto
    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debes indicar el producto que deseas modificar");
            }
            String sql = "UPDATE producto SET"
                + " precio = " + producto.getPrecio() + " WHERE nombre = '" + producto.getNombre() + "'" ;
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    

}
