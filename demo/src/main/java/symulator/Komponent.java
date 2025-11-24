package symulator;

public abstract class Komponent {
    private String producent;
    private String model;
    private String nazwa;
    private int waga;
    private int cena;
    public int getWaga() {
        return waga;
    };
    public int getCena() {
        return cena;
    };
    public String getnazwa(){return nazwa;};

    public String  getProducent() {
        return producent;
    };
    public String getModel() {
        return model;
    };

    public Komponent(String producent, String model, String nazwa, int waga, int cena) {
        this.producent = producent;
        this.model = model;
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
    }
}
