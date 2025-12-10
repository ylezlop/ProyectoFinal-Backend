package mx.uv.Proyecto;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String usuario;
    private String password;
    private int maxPuntuacion;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public int getMaxPuntuacion() { return maxPuntuacion; }
    public void setMaxPuntuacion(int maxPuntuacion) { this.maxPuntuacion = maxPuntuacion; }
}