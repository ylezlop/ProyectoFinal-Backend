package mx.uv.Proyecto;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface IJugador extends CrudRepository<Jugador, Integer> {
    Jugador findByUsuario(String usuario);
    List<Jugador> findTop5ByOrderByMaxPuntuacionDesc();
}