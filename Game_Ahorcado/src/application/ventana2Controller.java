package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent; 
import javafx.stage.Stage;

public class ventana2Controller {
    private Stage stage;
    private juego juego;

    @FXML
    private TextField letra;
    @FXML
    private Label lbl_palabra;
    @FXML
    private Label lbl_intentos;
    @FXML
    private Label wrong2;
    @FXML
    private Button btn_probar;
    @FXML
    private ImageView npc_5;
    @FXML
    private ImageView npc_4;
    @FXML
    private ImageView npc_3;
    @FXML
    private ImageView npc_2;
    @FXML
    private ImageView npc_1;
    @FXML
    private ImageView npc_0;

    @FXML
    public void initialize() {
        juego = new juego();
        actualizarInterfaz();
    }

    @FXML
    public void btn_probar_controller(MouseEvent event) {
        String letraIngresada = letra.getText();
        if (letraIngresada.length() == 1) {
            char letra = letraIngresada.charAt(0);
            boolean letraAdivinada = juego.revelarLetra(letra);
            if (letraAdivinada = false) {
                juego.decrementarIntentos();
            }
            actualizarInterfaz();
        } else {
            wrong2.setText("Ingrese solo una letra.");
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void actualizarInterfaz() {
        lbl_palabra.setText(juego.getPalabraGuionString());
        lbl_intentos.setText(String.valueOf(juego.getIntentos()));
        actualizarImagenNPC(String.valueOf(juego.getIntentos()));
        if (juego.juegoTerminado()) { 
            cerrarVentana();
        }
    }

    private void actualizarImagenNPC(String intentosRestantes) {
        npc_5.setVisible(intentosRestantes.equals("5"));
        npc_4.setVisible(intentosRestantes.equals("4"));
        npc_3.setVisible(intentosRestantes.equals("3"));
        npc_2.setVisible(intentosRestantes.equals("2"));
        npc_1.setVisible(intentosRestantes.equals("1"));
        npc_0.setVisible(intentosRestantes.equals("0"));
    }

    private void cerrarVentana() {
        stage.close();
    }
}
