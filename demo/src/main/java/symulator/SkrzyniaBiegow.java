package symulator;
import symulator.Sprzeglo;

public class SkrzyniaBiegow extends Komponent {
    protected int aktualnyBieg;
    private int iloscBiegow;
    void zwiekszBieg(){if(aktualnyBieg<iloscBiegow){aktualnyBieg+=1;}};
    void zmniejszBieg(){
        if(aktualnyBieg>1){aktualnyBieg -=1;}
    };
    private Sprzeglo sprzeglo;
    public int getGear(){return this.aktualnyBieg;};
    public SkrzyniaBiegow(String producent, String model, String nazwa, int waga, int cena, int aktualnyBieg, int iloscBiegow, Sprzeglo sprzeglo) {
        super(producent, model, nazwa, waga, cena);
        this.aktualnyBieg = aktualnyBieg;
        this.iloscBiegow = iloscBiegow;
        this.sprzeglo = sprzeglo;
    }
}