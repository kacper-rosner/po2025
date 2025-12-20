package symulator;



public class Silnik extends Komponent
{
    private int maxobroty;
    private int obroty;
    public void zwiekszObroty(int plus){
        if(this.obroty+plus<maxobroty){this.obroty += plus;}
        else System.err.println("NIE MECZ SILNIKA ZA DUZO");

    };
    public void zmniejszObroty(int minus){
        if(this.obroty-minus < 1500){
            System.err.println("NIE MECZ SILNIKA ZA MALO");
        }else{
        this.obroty -= minus;}
    };
    public void uruchom(){
        if(this.obroty==0){
            this.obroty=2000;}};
    public void zatrzymaj(){this.obroty=0;};

    public Silnik(String producent, String model, String nazwa, int waga, int cena, int maxobroty) {
        super(producent, model, nazwa, waga, cena);
        this.maxobroty = maxobroty;
        this.obroty = 0;
    }

    public int getMaxRpm() {return this.maxobroty;}
    public int getRpm(){return this.obroty;}

}
