package Persistence;

import java.util.ArrayList;
import java.util.Collection;

import Entities.Comentario;

public class ComentarioDAO extends DAO {

    //Motrar Comentarios
    public Collection<Comentario> mostrarComentarios() throws Exception {
        try {
            String sql = "SELECT * FROM comentarios;";
            consultarBase(sql);
            Comentario comentario = null;
            Collection<Comentario> comentarios = new ArrayList<>();
            while (resultado.next()) {
                comentario = new Comentario();
                comentario.setId(resultado.getInt(1));
                comentario.setIdCasa(resultado.getInt(2));
                comentario.setComentario(resultado.getString(3));
                comentarios.add(comentario);
            }
            desconectarBase();
            return comentarios;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}

