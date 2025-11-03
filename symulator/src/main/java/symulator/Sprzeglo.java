package symulator;

public class Sprzeglo extends Komponent {
    public Sprzeglo(String producent, String model, int waga, int cena, String nazwa) {
        super(producent, model, nazwa, waga, cena);
        this.stanSprzegla=true;
    }
    public void wcisnij(){this.stanSprzegla=true;};
    public void zwolnij(){this.stanSprzegla=false;};
    private boolean stanSprzegla;

}
