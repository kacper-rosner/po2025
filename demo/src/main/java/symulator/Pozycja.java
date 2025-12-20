package symulator;

public class Pozycja {
    public double x;
    public double y;
    public void aktualizujPozycje(double deltaX, double deltaY){
        this.x+=deltaX;
        this.y+=deltaY;
    };
    public String getPozycja(){return (String.valueOf(this.x)+","+String.valueOf(this.y));}
    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
