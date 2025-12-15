package mx.uv.Proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*") // IMPORTANTE: Permite que Svelte se conecte
public class JuegoControlador {

    @Autowired
    private IJugador iJugador;

    @PostMapping("/login")
    public Jugador login(@RequestBody Jugador datos) {
        // Verificar si el jugador existe
        Jugador existente = iJugador.findByUsuario(datos.getUsuario());
        if (existente == null) {
            datos.setMaxPuntuacion(0);
            return iJugador.save(datos);
        } else {
            if (existente.getPassword().equals(datos.getPassword())) {
                return existente;
            }
            return null;
        }
    }

    @GetMapping("/scoreboard")// Obtener el top 5 de jugadores
    public List<Jugador> obtenerTop5() {
        return iJugador.findTop5ByOrderByMaxPuntuacionDesc();
    }

    @PostMapping("/puntaje") // Actualizar el puntaje máximo de un jugador
    public Jugador actualizarPuntaje(@RequestBody Jugador datos) {
        Jugador jugador = iJugador.findByUsuario(datos.getUsuario());
        if (jugador != null && datos.getMaxPuntuacion() > jugador.getMaxPuntuacion()) {
            jugador.setMaxPuntuacion(datos.getMaxPuntuacion());
            return iJugador.save(jugador);
        }
        return jugador;
    }

    @DeleteMapping("/borrar") // Borrar cuenta de jugador
    public boolean borrarCuenta(@RequestBody Map<String, String> credenciales) {
        Jugador jugador = iJugador.findByUsuario(credenciales.get("usuario")); 
        if (jugador != null && jugador.getPassword().equals(credenciales.get("password"))) { // Verificar contraseña
            iJugador.delete(jugador); // Lo borra
            return true;
        }
        return false;
    }
}