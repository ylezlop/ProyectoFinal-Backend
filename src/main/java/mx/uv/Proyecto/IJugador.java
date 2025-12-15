package mx.uv.Proyecto;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface IJugador extends CrudRepository<Jugador, Integer> {
    Jugador findByUsuario(String usuario); // Buscar jugador por nombre de usuario
    List<Jugador> findTop5ByOrderByMaxPuntuacionDesc(); // Obtener los 5 jugadores con mayor puntuación
}