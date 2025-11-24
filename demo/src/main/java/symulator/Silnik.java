package symulator;



public class Silnik extends Komponent
{
    private int maxobroty;
    private int obroty;
    public void zwiekszObroty(int plus){};
    public void zmniejszObroty(int minus){};
    public void uruchom(){this.obroty=2000;};
    public void zatrzymaj(){this.obroty=0;};

    public Silnik(String producent, String model, String nazwa, int waga, int cena, int maxobroty) {
        super(producent, model, nazwa, waga, cena);
        this.maxobroty = maxobroty;
        this.obroty = 2000;
    }
}
