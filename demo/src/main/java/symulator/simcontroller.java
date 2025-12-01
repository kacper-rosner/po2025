package symulator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.util.*;

public class simcontroller {

    private ArrayList<Samochod> listasamochodow=new ArrayList<>();
    private Samochod curr_samochod;

    void refresh(){
        carModelField.setText(String.valueOf(curr_samochod.get);
    };

    @FXML private ImageView carImageView;
    @FXML private Button dodaj_nowy;
    @FXML    private void dodaj_nowy_Button(){
        int predkoscmax = 100;
        String model = carModelField.getText();
        int nrRejest = Integer.parseInt(carRegField.getText());
        boolean stanwlaczenia = false;
        Pozycja pozycja = new Pozycja(0,0);
        Silnik silnik = new Silnik("def",model,engineNameField.getText(),Integer.parseInt(engineWeightField.getText()),Integer.parseInt(enginePriceField.getText()),Integer.parseInt(engineRpmField.getText()));
        Sprzeglo sprzeglo = new Sprzeglo("def",model,1000,1000,"def");
        SkrzyniaBiegow skrzyniaBiegow=new SkrzyniaBiegow("def",model,gearboxNameField.getText(),Integer.parseInt(gearboxWeightField.getText()),Integer.parseInt(gearboxPriceField.getText()),Integer.parseInt(gearboxCurrentGearField.getText()),10,sprzeglo);

        Samochod samochod = new Samochod(predkoscmax,model,nrRejest,stanwlaczenia,pozycja,silnik,skrzyniaBiegow);
        listasamochodow.add(samochod);
    };
    @FXML    private Button usun_samochod;
    @FXML    private void usun_samochod_Button(){
    };
    @FXML    private Label helloLabel;
    @FXML    private ComboBox<String> tools;
    @FXML    private TextField carModelField;
    @FXML    private TextField carRegField;
    @FXML    private TextField carWeightField;
    @FXML    private TextField carSpeedField;
    @FXML    private TextField gearboxNameField;
    @FXML    private TextField gearboxPriceField;
    @FXML    private TextField gearboxWeightField;
    @FXML    private TextField gearboxCurrentGearField;
    @FXML    private Button increaseGearButton;
    @FXML    private void increaseGear_Button(){

    };
    @FXML    private BorderPane mainPane;
    @FXML    private Button carModelButton;
    @FXML    private void carModel_Button(){
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

    @FXML    private ComboBox<Samochod> chooseCar;
    private ObservableList<Samochod> samochody =  FXCollections.observableArrayList();
    void initializeComboBoxChooseCar() {
        chooseCar.setItems(samochody);
        chooseCar.setOnAction(event -> {
            curr_samochod =chooseCar.getSelectionModel().getSelectedItem();
            refresh();
        });
    }

}
