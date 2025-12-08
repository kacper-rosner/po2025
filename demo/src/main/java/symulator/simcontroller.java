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

//    private ArrayList<Samochod> listasamochodow=new ArrayList<>();
    private Samochod curr_samochod;

    void refresh(){
        carModelField.setText(String.valueOf(curr_samochod.getModel()));
        carRegField.setText(String.valueOf(curr_samochod.getReg()));
        carWeightField.setText(String.valueOf(curr_samochod.getWaga()));
        carSpeedField.setText(String.valueOf(curr_samochod.getSpeed()));
        engineNameField.setText(String.valueOf(curr_samochod.getEngName()));
        enginePriceField.setText(String.valueOf(curr_samochod.getEngPrice()));
        engineRpmField.setText(String.valueOf(curr_samochod.getEngRpm()));
        engineWeightField.setText(String.valueOf(curr_samochod.getEngWeight()));
        gearboxNameField.setText(String.valueOf(curr_samochod.getGearName()));
        gearboxCurrentGearField.setText(String.valueOf(curr_samochod.getGearCurr()));
        gearboxPriceField.setText(String.valueOf(curr_samochod.getGearPrice()));
        gearboxWeightField.setText(String.valueOf(curr_samochod.getGearWeight()));
    };
    @FXML
    public void initialize(){
        Sprzeglo sprzeglo1 = new Sprzeglo("abc","def",1000,1000,"1");
        Sprzeglo sprzeglo2 = new Sprzeglo("abc","def",1000,1000,"1");
        Silnik silnik1 = new Silnik ("abc","def","1",1000,1000,10000);
        Silnik silnik2 = new Silnik ("abc","def","1",1000,1000,10000);
        SkrzyniaBiegow skrzynia1 = new SkrzyniaBiegow("abc","def","1",1000,1000,1,8,sprzeglo1);
        SkrzyniaBiegow skrzynia2 = new SkrzyniaBiegow("abc","def","1",1000,1000,1,8,sprzeglo2);
        Samochod testCar1 = new Samochod(120, "Model A", 1234, false, new Pozycja(0,0), silnik1, skrzynia1);
        Samochod testCar2 = new Samochod(150, "Model B", 5678, false, new Pozycja(0,0), silnik2, skrzynia2);
        samochody.add(testCar1);
        samochody.add(testCar2);
        initializeComboBoxChooseCar();
        curr_samochod = testCar1;
    }
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
        samochody.add(samochod);
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
        chooseCar.setConverter(new SamochodConverter());
        chooseCar.setItems(samochody);
        chooseCar.setOnAction(event -> {
            curr_samochod =chooseCar.getSelectionModel().getSelectedItem();
            refresh();
        });
    }

}
