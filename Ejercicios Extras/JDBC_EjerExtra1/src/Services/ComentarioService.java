package Services;

import java.util.Collection;
import Entities.Comentario;
import Persistence.ComentarioDAO;

public class ComentarioService {
    
    private ComentarioDAO dao;

    public ComentarioService(){
        this.dao = new ComentarioDAO();
    }

    //Mostrar Comentarios
    public void MostrarCometarios() throws Exception {
        try {
            Collection<Comentario> cometarios = dao.mostrarComentarios();
            if (cometarios.isEmpty()) {
                throw new Exception("Sin comentarios registrados");
            } else {
                for (Comentario comentario : cometarios) {
                    System.out.println(comentario.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
