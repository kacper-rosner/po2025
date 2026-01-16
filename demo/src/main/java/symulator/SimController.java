package symulator;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Random;

import java.io.IOException;

public class SimController implements Listener {
    @Override
    public void update(){refresh();};

    @FXML private Pane mapPane;
    @FXML private ImageView carImageView;
    @FXML private Button dodaj_nowy;
    //    public void dodaj_nowy_Button(String model, String reg, int weight, ){};
    @FXML    public void dodaj_nowy_Button(){
        int predkoscmax = 30;
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
        curr_samochod.exists=false;
        Platform.runLater(() -> {

//            javafx.scene.Node nodeToRemove = mapPane.lookup("#" + curr_samochod.getImgId());

//            if (nodeToRemove != null) {
                mapPane.getChildren().remove(curr_samochod.getImg());
//            }
        });
        samochody.remove(curr_samochod);
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
        curr_samochod.setPGear();
        curr_samochod.setSpeed();
        refresh();
    };
    @FXML    private BorderPane mainPane;
    @FXML    private Button carModelButton;
    @FXML    private void carModel_Button(){
    };
    @FXML    private Button decreaseGearButton;
    @FXML    private void decreaseGear_Button(){

        curr_samochod.setMGear();
        curr_samochod.setSpeed();
        refresh();
    };
    @FXML    private Button wlaczsamochodButton;
    @FXML    private void wlaczsamochod_Button(){
        curr_samochod.wlacz();
        refresh();
    };
    @FXML    private Button wylaczsamochodButton;
    @FXML    private void wylaczsamochod_Button(){
        curr_samochod.wylacz();
        refresh();
    };
    @FXML    private Button resetButton;
    @FXML    private void reset_Button(){
    };
    @FXML    private Button gasButton;
    @FXML    private void gas_Button(){
        curr_samochod.setPObroty(500);
        refresh();
    };
    @FXML    private Button brakeButton;
    @FXML    private void brake_Button(){
        curr_samochod.setMObroty(500);
        refresh();
    };
    @FXML    private TextField engineNameField;
    @FXML    private TextField enginePriceField;
    @FXML    private TextField engineWeightField;
    @FXML    private TextField engineRpmField;
    @FXML    private ComboBox<Samochod> chooseCar;
    public ObservableList<Samochod> samochody =  FXCollections.observableArrayList();
    public ObservableList<Silnik> silniki =  FXCollections.observableArrayList();
    public ObservableList<SkrzyniaBiegow> skrzynie =  FXCollections.observableArrayList();
    int currCarrListLength;

    private Samochod curr_samochod;
    @FXML
    public void initialize(){
        Sprzeglo sprzeglo1 = new Sprzeglo("abc","def",1000,1000,"1");
        Sprzeglo sprzeglo2 = new Sprzeglo("abc","def",1000,1000,"1");
        Silnik silnik1 = new Silnik ("abc","def","1",1000,1000,10000);
        Silnik silnik2 = new Silnik ("abc","def","1",1000,1000,10000);
        silniki.add(silnik1);
        silniki.add(silnik2);

        SkrzyniaBiegow skrzynia1 = new SkrzyniaBiegow("abc","def","1",1000,1000,1,8,sprzeglo1);
        SkrzyniaBiegow skrzynia2 = new SkrzyniaBiegow("abc","def","1",1000,1000,1,8,sprzeglo2);
        skrzynie.add(skrzynia1);
        skrzynie.add(skrzynia2);

        Samochod testCar1 = new Samochod(120, "Model A", 1234, false, new Pozycja(0,0), silnik1, skrzynia1);
        Samochod testCar2 = new Samochod(150, "Model B", 5678, false, new Pozycja(0,0), silnik2, skrzynia2);
        samochody.add(testCar1);
        samochody.add(testCar2);
        initializeComboBoxChooseCar();
        curr_samochod = testCar1;
        mapPane.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();
            Pozycja nowaPozycja = new Pozycja(x, y);
            //System.err.println("sczytana pozycja"+nowaPozycja.getPozycja());
            curr_samochod.setCel(nowaPozycja);
            //System.err.println("getCel: "+curr_samochod.getCel().x + curr_samochod.getCel().y);
        });
        addImg(testCar1);
        addImg(testCar2);

    }

    void refresh(){





        Platform.runLater(() -> {

            if (curr_samochod == null) {return;}
            else {

                try {
                    carModelField.setText(String.valueOf(curr_samochod.getModel()));
                    carRegField.setText(String.valueOf(curr_samochod.getReg()));
                    carWeightField.setText(String.valueOf(curr_samochod.getWaga()));
                    carSpeedField.setText(String.valueOf(curr_samochod.getPredkosc()));
                    engineNameField.setText(String.valueOf(curr_samochod.getEngName()));
                    enginePriceField.setText(String.valueOf(curr_samochod.getEngPrice()));
                    engineRpmField.setText(String.valueOf(curr_samochod.getEngRpm()));
                    engineWeightField.setText(String.valueOf(curr_samochod.getEngWeight()));
                    gearboxNameField.setText(String.valueOf(curr_samochod.getGearName()));
                    gearboxCurrentGearField.setText(String.valueOf(curr_samochod.getGearCurr()));
                    gearboxPriceField.setText(String.valueOf(curr_samochod.getGearPrice()));
                    gearboxWeightField.setText(String.valueOf(curr_samochod.getGearWeight()));


                    curr_samochod.getImg().setTranslateX(curr_samochod.getPozycja().x);
                    curr_samochod.getImg().setTranslateY(curr_samochod.getPozycja().y);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        });
        currCarrListLength = samochody.size();
    }
    ;





    void initializeComboBoxChooseCar() {
        chooseCar.setConverter(new SamochodConverter());
        chooseCar.setItems(samochody);
        chooseCar.setOnAction(event -> {
            curr_samochod =chooseCar.getSelectionModel().getSelectedItem();
            curr_samochod.addListener(this);
            refresh();
        });
    }
    public void openAddCarWindow() throws IOException {
        System.out.println("open add car");
        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("DodajSamochod.fxml"));
        javafx.scene.Parent root = loader.load();
        DodajSamochodController controllerDodaj = loader.getController();
        controllerDodaj.setSamochody(this.samochody);
        controllerDodaj.setSilniki(this.silniki);
        controllerDodaj.setSkrzynie(this.skrzynie);
        controllerDodaj.setSimController(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Dodaj nowy samochód");
        stage.show();
        boolean inAdding = true;
//        while(inAdding){
//            if (samochody.size()>currCarrListLength){
//                 this.addImg(samochody.getLast());
//            }
//        }
    }
    public void addImg(Samochod samochod){
        Platform.runLater(() -> {


        ImageView nowySamochodImgV = new ImageView();
        Random random=new Random();
        try{
            Image image = new Image(getClass().getResourceAsStream("abc.png"));
            nowySamochodImgV.setImage(image);
            nowySamochodImgV.setFitWidth(50.0);
            nowySamochodImgV.setFitHeight(30.0);
            nowySamochodImgV.setId("carIcon_" + String.valueOf(random.nextInt(10000))+(mapPane.getChildren().size()));
            nowySamochodImgV.setLayoutX(samochod.getPozycja().x);
            nowySamochodImgV.setLayoutY(samochod.getPozycja().y);
            samochod.setImg(nowySamochodImgV);
//            samochod.setImgId(nowySamochodImgV.getId());
//            Platform.runLater(() -> {
//                mapPane.getChildren().add(nowySamochodImgV);
//            });
            mapPane.getChildren().add(nowySamochodImgV);
        }
        catch (NullPointerException e){System.out.println(e);return;}
    });}
}
