package application;

import java.util.Random;

public class palabra {
    private String palabraAdivinar;
    private char[] palabraGuion;

    public palabra() {
        this.palabraAdivinar = getPalabraAdivinar();
        this.palabraGuion = getPalabraGuion(this.palabraAdivinar);
    }

    public String getPalabraAdivinar() {
        String[] palabras = {"casa", "carro", "ventana", "juegos", "dinosaurio"};
        Random r = new Random();
        int n = r.nextInt(palabras.length);
        return palabras[n];
    }

    public String getPalabraGuionString() {
        return String.valueOf(this.palabraGuion);
    }

    public boolean revelarLetra(char letra) {
        boolean letraAdivinada = false;
        for (int i = 0; i < this.palabraAdivinar.length(); i++) {
            if (this.palabraAdivinar.charAt(i) == letra) {
                this.palabraGuion[i] = letra;
                letraAdivinada = true;
            }
        }
        return letraAdivinada;
    }

    private char[] getPalabraGuion(String palabra) {
        int nletras = palabra.length();
        char[] palabraGuion = new char[nletras];
        for (int i = 0; i < nletras; i++) {
            palabraGuion[i] = '_';
        }
        return palabraGuion;
    }

    public boolean hayGuion() {
        for (char l : this.palabraGuion) {
            if (l == '_') return true;
        }
        return false;
    }
}

