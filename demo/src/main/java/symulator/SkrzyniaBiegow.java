package symulator;
import symulator.Sprzeglo;

public class SkrzyniaBiegow extends Komponent {
    public int aktualnyBieg;
    private int iloscBiegow;
    void zwiekszBieg(){if(aktualnyBieg<iloscBiegow){
        System.err.println(this.iloscBiegow);
        this.sprzeglo.setStanSprzegla(true);
//        try {wait(300);}
//        catch(InterruptedException e){}
        aktualnyBieg+=1;
        this.sprzeglo.setStanSprzegla(false);
        }
    };
    void zmniejszBieg(){
        this.sprzeglo.setStanSprzegla(true);
//        try {wait(300);}
//        catch(InterruptedException e){}
        System.err.println("zmniejszenie Biegow");
        if(aktualnyBieg>1){aktualnyBieg -=1;}
        else{System.err.println("aktualnyBieg: " + aktualnyBieg);}
        this.sprzeglo.setStanSprzegla(false);
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