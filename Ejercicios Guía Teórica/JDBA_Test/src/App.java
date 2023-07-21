//import java.util.logging.Level;
//import java.util.logging.Logger;

import principal.dominio.mascota.MascotaService;
import principal.dominio.usuario.Usuario;
import principal.dominio.usuario.UsuarioService;

public class App {
    public static void main(String[] args) throws Exception {
        
        UsuarioService usuarioService = new UsuarioService();
        MascotaService mascotaService = new MascotaService();

        
        // try {
        //     //Creamos  usuarios
        //     usuarioService.crearUsuario("eduardo@hotmail.com", "eddPereda");
        //     usuarioService.crearUsuario("manuel@hotmail.com", "eggprogramacion");
        //     usuarioService.imprimirUsuarios();
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     System.out.println("Error del sistema por \n" + e.getMessage());
        // }
        
        
        // try {
        //     //Modificamos un usuario
        //     usuarioService.modificarClaveUsuario("eduardo@hotmail.com", "eddPerea", "eddPereda");
        //     usuarioService.imprimirUsuarios();
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     System.out.println("Error del sistema por \n" + e.getMessage());
        // }
        
        
        // try {
        //     //Eliminamos un usuario
        //     usuarioService.eliminarUsuario("manuel@hotmail.com");
        //     usuarioService.imprimirUsuarios();
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     System.out.println("Error del sistema por \n" + e.getMessage());
        // }
        
        
        try {
            //Buscamos el Usuario por correo
            Usuario usuario = usuarioService.buscarUsuarioPorCorreoElectronico("eduardo@hotmail.com");
            //Creamos Mascota con el Usuario anterior
            mascotaService.crearMascota("Maya", "Calle", usuario);

            //Mostramos Mascota con su Usuario
            mascotaService.imprimirMascotas();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }




       /*  UsuarioService usuarioServ = new UsuarioService();
        
        try {
            usuarioServ.crearUsuario("maya@hotmail", "clave003");
            System.out.println("Dentro del try");
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Usuario creado");*/
    }

}

