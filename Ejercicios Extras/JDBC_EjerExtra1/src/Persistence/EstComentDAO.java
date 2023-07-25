package Persistence;

import java.util.ArrayList;
import java.util.Collection;

import Entities.Casa;
import Entities.Comentario;
import Entities.EstadisticaCometario;

public class EstComentDAO extends DAO {
    
    //Inciso I)
    public Collection<EstadisticaCometario> casasLimpiasRU() throws Exception {
        try {
            String sql = "SELECT c.id_casa, c.pais, cm.id_comentario, cm.comentario FROM casas c LEFT JOIN comentarios cm ON c.id_casa = cm.id_casa WHERE c.pais = 'Reino unido' AND cm.comentario LIKE '%_limpia_%';";
            consultarBase(sql);
            Casa casa = null;
            Comentario comentario = null;
            EstadisticaCometario estComent = null;
            Collection<EstadisticaCometario> estComentarios = new ArrayList<>();
            while (resultado.next()) {
                casa = new Casa();
                comentario = new Comentario();
                estComent = new EstadisticaCometario();
                casa.setId(resultado.getInt(1));
                casa.setPais(resultado.getString(2));
                comentario.setId(resultado.getInt(3));
                comentario.setComentario(resultado.getString(4));
                estComent.setCasa(casa);
                estComent.setComentario(comentario);
                estComentarios.add(estComent);
            }
            desconectarBase();
            return estComentarios;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}
