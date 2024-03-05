package application;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String usuario;
    private String contraseña;
    private static List<Jugador> listaJugadores = new ArrayList<>();
      
    public Jugador(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public void registrar(String usuario, String contraseña) {
        Jugador nuevoJugador = new Jugador(usuario, contraseña);
        listaJugadores.add(nuevoJugador);
    }

    public static boolean iniciarSesion(String usuario, String contraseña) {
        for (Jugador jugador : listaJugadores) {
            if (jugador.getUsuario().equals(usuario) && jugador.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        return false; 
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}

