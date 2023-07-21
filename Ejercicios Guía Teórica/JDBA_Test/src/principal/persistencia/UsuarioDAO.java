package principal.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import principal.dominio.usuario.Usuario;

public final class UsuarioDAO extends DAO {
    
    //Método para insertar un usuario en la tabla usuario de la DB perros
    public void guardarUsuario(Usuario usuario) throws Exception{
        try {
            if (usuario == null) {
                throw new Exception("DEbe indicar un  usuario");
            }
            
            String sql = "INSERT INTO Usuario (correoElectronico, clave)"
                    + "VALUES ( '" +  usuario.getCorreoElectronico() + "' , '" + usuario.getClave() + "' ); ";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
     //Método para modificar un usuario en la tabla usuario de la DB perros
    public void modificarUsuario(Usuario usuario) throws Exception {
        try {
            if (usuario == null) {
                throw new Exception("Debe indicar el usuario que desea modificar");
            }
            
            String sql = "UPDATE Usuario SET "
                    + "clave = '" + usuario.getClave() + "' WHERE correoElectronico = '" + usuario.getCorreoElectronico() + "' ; ";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    //Método para eliminar un usuario en la tabla usuario de la DB perros
    public void eliminarUsuario(String correoElectronico) throws Exception {
        try {
            if (correoElectronico == null) {
                throw new Exception("Debe indicar el usuario que desea eliminar");
            }
            
            String sql = "DELETE FROM Usuario WHERE correoElectronico = '" + correoElectronico+ "' ; ";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    //Método para buscar/mostrar un usuario por correo en la tabla usuario de la DB perros
    public Usuario buscarUsuarioPorCorreoElectronico(String correoElectronico) throws Exception {
        try {
            String sql = "SELECT * FROM Usuario "
                    + " WHERE correoElectronico = '" + correoElectronico + "'";
            consultarBase(sql);
            
            Usuario usuario = null;
            while (resultado.next()) {                
                usuario = new Usuario();
                usuario.setId(resultado.getInt(1));
                //usuario.setId(resultado.getInt("id"));
                usuario.setCorreoElectronico(resultado.getString(2));
                usuario.setClave(resultado.getString(3));
            }
            desconectarBase();
            return usuario;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    //Método para buscar/mostrar un usuario por id en la tabla usuario de la DB perros
    public Usuario buscarUsuarioPorId(Integer id) throws Exception {
        try {

            String sql = "SELECT * FROM Usuario "
                    + " WHERE id = '" + id + "'";

            consultarBase(sql);

            Usuario usuario = null;
            while (resultado.next()) {
                usuario = new Usuario();
                usuario.setId(resultado.getInt(1));
                usuario.setCorreoElectronico(resultado.getString(2));
                usuario.setClave(resultado.getString(3));
            }
            desconectarBase();
            return usuario;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
     //Método para buscar/mostrar muchos (n) usuarios en la tabla usuario de la DB perros
    public Collection<Usuario> listarUsuarios() throws Exception {
        try {
            String sql = "SELECT id, correoElectronico, clave FROM Usuario";
            consultarBase(sql);
            
            Usuario usuario = null;
            Collection<Usuario> usuarios = new ArrayList<>();
            while (resultado.next()) {                
                usuario = new Usuario();
                usuario.setId(Integer.valueOf(resultado.getString(1)));
                usuario.setCorreoElectronico(resultado.getString(2));
                usuario.setClave(resultado.getString(3));
                usuarios.add(usuario);
            }
            desconectarBase();
            return usuarios;
            
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    
}

