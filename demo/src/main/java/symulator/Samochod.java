package symulator;
import javafx.application.Application;

public class Samochod {
    public void wlacz(){
        this.silnik.uruchom();
        this.stanWlaczenia=true;
    };
    public void wylacz(){
        this.silnik.zatrzymaj();
        while(this.skrzyniaBiegow.aktualnyBieg!=0){this.skrzyniaBiegow.zmniejszBieg();};
    };
    public void jedzdo(Pozycja cel){};
    public int getWaga(){
        int sum=0;
        sum+=this.silnik.getWaga();
        sum+=this.skrzyniaBiegow.getWaga();
        return sum;};
    //public void getAktPredkosc(){return predkosc;};
    private SkrzyniaBiegow skrzyniaBiegow;
    private Silnik silnik;
    private Pozycja aktualnaPozycja;
    private boolean stanWlaczenia;
    private int nrRejest;
    private String model;
    private int predkoscmax;

    public Samochod(int predkoscmax, String model, int nrRejest, boolean stanWlaczenia, Pozycja pozycja, Silnik silnik, SkrzyniaBiegow skrzyniaBiegow) {
        this.predkoscmax = predkoscmax;
        this.model = model;
        this.nrRejest = nrRejest;
        this.stanWlaczenia = stanWlaczenia;
        this.aktualnaPozycja = pozycja;
        this.silnik = silnik;
        this.skrzyniaBiegow = skrzyniaBiegow;
    }
}
