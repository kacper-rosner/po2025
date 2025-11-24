package symulator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class simcontroller {

    @FXML private ImageView carImageView;
    @FXML private Button dodaj_nowy;
    @FXML    private void dodaj_nowy_Button(){
        Samochod samochod = new Samochod();
    };
    @FXML    private Button usun_samochod;
    @FXML    private void usun_samochod_Button(){
    };
    @FXML    private Label helloLabel;
    @FXML    private ComboBox<String> tools;
    @FXML    private TextField carModelField;
    @FXML    private TextField carRegField;
    @FXML    private TextField carWeightField;
    @FXML    private TextField carColorField;
    @FXML    private TextField carSpeedField;
    @FXML    private TextField gearboxNameField;
    @FXML    private TextField gearboxPriceField;
    @FXML    private TextField gearboxWeightField;
    @FXML    private TextField gearboxCurrentGearField;
    @FXML    private Button increaseGearButton;
    @FXML    private void increaseGear_Button(){

    };
    @FXML    private BorderPane mainPane;
    @FXML    private Button carModelButton;@FXML    private void carModel_Button(){
    };
    @FXML    private Button decreaseGearButton;
    @FXML    private void decreaseGear_Button(){
    };
    @FXML    private Button wlaczsamochodButton;
    @FXML    private void wlaczsamochod_Button(){
    };
    @FXML    private Button wylaczsamochodButton;
    @FXML    private void wylaczsamochod_Button(){
    };
    @FXML    private Button resetButton;
    @FXML    private void reset_Button(){
    };
    @FXML    private Button gasButton;
    @FXML    private void gas_Button(){
    };
    @FXML    private Button brakeButton;
    @FXML    private void brake_Button(){
    };
    @FXML    private TextField engineNameField;
    @FXML    private TextField enginePriceField;
    @FXML    private TextField engineWeightField;
    @FXML    private TextField engineRpmField;




}
