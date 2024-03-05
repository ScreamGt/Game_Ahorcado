package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ventana1Controller {
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;
    @FXML
    private Button btn_login;
    @FXML
    private Button btn_register;
    @FXML
    private Label Wrong;

    @FXML
    public void btn_login_control(MouseEvent event) {
    	String username = user.getText(); 
        String pass = password.getText(); 
        
        boolean sesionIniciada = Jugador.iniciarSesion(username, pass);
        
        if (sesionIniciada) {
        	try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ventana2.fxml"));
                BorderPane root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) btn_login.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Wrong.setText("El Usuario no existe");
        }
    }
 
    @FXML
    public void btn_register_control(MouseEvent event) {
    	String username = user.getText(); 
        String pass = password.getText();
        Wrong.setText("Registrado exitosamente");
        Jugador jugador = new Jugador(username, pass);
        jugador.registrar(username, pass);
    }
}


