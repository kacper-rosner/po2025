
package symulator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DodajSamochodController {
    private ObservableList<Samochod> samochodyC =  FXCollections.observableArrayList();
    public void setSamochody(ObservableList<Samochod> abc){this.samochodyC = abc; };
    public void setSilniki(ObservableList<Silnik> abc) {
        this.silnikiC = abc;
        if (chooseEng != null) {
            initializeComboBoxChooseEng();
        }
    }
    public void setSkrzynie(ObservableList<SkrzyniaBiegow> abc) {
        this.skrzynieC = abc;
        if (chooseGear != null) {
            initializeComboBoxChooseGear();
        }
    }

        @FXML
        public void initialize () {
            initializeComboBoxChooseEng();
            initializeComboBoxChooseGear();
        }
        @FXML
        public Label helloLabel;
        public Button dodaj_nowy;
        @FXML private void dodaj_nowy () {
            int predkoscmax = 100;
            String model = carModelField.getText();
            int nrRejest = Integer.parseInt(carRegField.getText());
            boolean stanwlaczenia = false;
            Pozycja pozycja = new Pozycja(0, 0);
            Samochod samochod = new Samochod(predkoscmax, model, nrRejest, stanwlaczenia, pozycja, curr_eng, curr_gear);
            samochodyC.add(samochod);
            System.out.println("Dodano samochod");
            Stage stage = (Stage) dodaj_nowy.getScene().getWindow();
            stage.close();
        }
        ;
        public Button anuluj_but;
        @FXML public void anuluj123456 () {
            Stage stage = (Stage) anuluj_but.getScene().getWindow();
            stage.close();
        }
        public TextField carModelField;
        public TextField carRegField;
        public TextField carWeightField;
        public TextField carSpeedField;
        public TextField gearboxNameField;
        public TextField gearboxPriceField;
        public TextField gearboxWeightField;
        public TextField gearboxCurrentGearField;
        public TextField engineNameField;
        public TextField enginePriceField;
        public TextField engineWeightField;
        public TextField engineRpmField;
        public ComboBox<SkrzyniaBiegow> chooseGear;
        public ComboBox<Silnik> chooseEng;
        public Button dodajNowyGear;
        @FXML private void dodajNowyGear () {
            String model = "123";
            Sprzeglo sprzeglo = new Sprzeglo("def", model, 1000, 1000, "def");
            SkrzyniaBiegow skrzyniaBiegow = new SkrzyniaBiegow("def", model, gearboxNameField.getText(), Integer.parseInt(gearboxWeightField.getText()), Integer.parseInt(gearboxPriceField.getText()), Integer.parseInt(gearboxCurrentGearField.getText()), 10, sprzeglo);
            skrzynieC.add(skrzyniaBiegow);
        }
        ;
        @FXML private void dodajNowyEng () {
            String model = "123";
            Silnik silnik = new Silnik("def", model, engineNameField.getText(), Integer.parseInt(engineWeightField.getText()), Integer.parseInt(enginePriceField.getText()), Integer.parseInt(engineRpmField.getText()));
            silnikiC.add(silnik);
        }
        ;
        public Button dodajNowyEng;
        private Silnik curr_eng;
        private SkrzyniaBiegow curr_gear;
        @FXML private void dodajNowy () {
        }
        ;
        //private ObservableList<Silnik> silnikiC =  FXCollections.observableArrayList();
        //private ObservableList<SkrzyniaBiegow> skrzynieC =  FXCollections.observableArrayList();
        private ObservableList<Silnik> silnikiC;
        private ObservableList<SkrzyniaBiegow> skrzynieC;

        void initializeComboBoxChooseEng () {
            chooseEng.setConverter(new SilnikConverter());
            chooseEng.setItems(silnikiC);
            chooseEng.setOnAction(event -> {
                curr_eng = chooseEng.getSelectionModel().getSelectedItem();
                refresh_eng();
            });
        }

        void initializeComboBoxChooseGear () {
            chooseGear.setConverter(new SkrzyniaBiegowConverter());
            chooseGear.setItems(skrzynieC);
            chooseGear.setOnAction(event -> {
                curr_gear = chooseGear.getSelectionModel().getSelectedItem();
                refresh_gear();
            });
        }
        void refresh_eng () {
            engineNameField.setText(String.valueOf(curr_eng.getnazwa()));
            enginePriceField.setText(String.valueOf(curr_eng.getCena()));
            engineRpmField.setText(String.valueOf(curr_eng.getRpm()));
            engineWeightField.setText(String.valueOf(curr_eng.getWaga()));

        }
        void refresh_gear () {
            gearboxNameField.setText(String.valueOf(curr_gear.getnazwa()));
            gearboxCurrentGearField.setText(String.valueOf(curr_gear.getGear()));
            gearboxPriceField.setText(String.valueOf(curr_gear.getCena()));
            gearboxWeightField.setText(String.valueOf(curr_gear.getWaga()));

        }



    
        
}
