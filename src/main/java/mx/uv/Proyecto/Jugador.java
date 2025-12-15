package mx.uv.Proyecto;

import jakarta.persistence.*;

// Modelo de datos para un jugador
@Entity
@Table(name = "jugadores") // Nombre de la tabla en la base de datos
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autogenerado
    private Integer id;

    @Column(unique = true) 
    private String usuario; // Nombre de usuario único
    private String password; 
    private int maxPuntuacion;

    // Getters y Setters
    public Integer getId() { return id; } 
    public void setId(Integer id) { this.id = id; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public int getMaxPuntuacion() { return maxPuntuacion; }
    public void setMaxPuntuacion(int maxPuntuacion) { this.maxPuntuacion = maxPuntuacion; }
}