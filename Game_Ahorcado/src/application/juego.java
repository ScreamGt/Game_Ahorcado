package application;

public class juego {
    private palabra palabra;
    private boolean juegoTerminado;
    private int intentos;

    public juego() {
        palabra = new palabra();
        juegoTerminado = false;
        intentos = 5;
    }

    public void decrementarIntentos() {
        intentos--;
        if (intentos <= 0) {
            juegoTerminado = true;
        }
    }

    public boolean revelarLetra(char letra) {
        boolean letraAdivinada = palabra.revelarLetra(letra);
        if (!letraAdivinada) {
            decrementarIntentos();
        }
        return letraAdivinada;
    }

    public String getPalabraGuionString() {
        return palabra.getPalabraGuionString();
    }

    public int getIntentos() {
        return intentos;
    }

    public boolean juegoTerminado() {
        return juegoTerminado;
    }
    
}

