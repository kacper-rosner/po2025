package symulator;

import java.util.ArrayList;

public class Samochod implements Runnable {

    @Override
    public void run() {
        System.err.println("stworzono wątek");
        while (exists) {

            //System.err.println(this.cel + " "+ this.pozycja);
            if (this.cel != null && pozycja.x!=cel.x && pozycja.y!=cel.y) {
                //System.err.println("pozycja != cel");
                jedzdo();
                notifyListeners();

            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            catch (NullPointerException e){System.err.println("to ten błąd");return;}
        }
    }

    private ArrayList<Listener> listeners = new ArrayList<Listener>();
    public void addListener(Listener listener) {
        listeners.add(listener);
    }
    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }
    private void notifyListeners() {
        for (Listener listener : listeners) {
            listener.update();
        }
    }
    public void wlacz(){
        this.silnik.uruchom();
        this.stanWlaczenia=true;
        this.silnik.zwiekszObroty(2000);
    };
    public void setPObroty(int obroty){
        this.silnik.zwiekszObroty(obroty);
    }
    public void setMObroty(int obroty){
        this.silnik.zmniejszObroty(obroty);
    }
    public void wylacz(){
        this.silnik.zatrzymaj();
        while(this.skrzyniaBiegow.aktualnyBieg!=1){this.skrzyniaBiegow.zmniejszBieg();};
    };
    public void jedzdo(){
        double deltat = 2;

                double odleglosc = Math.sqrt(Math.pow(this.cel.x - this.pozycja.x, 2) +
                        Math.pow(this.cel.y - pozycja.y, 2));

                double dx = getPredkosc() * deltat * (this.cel.x - this.pozycja.x) /
                        odleglosc;
//                System.err.println("predkosc to:  "+getPredkosc());
//                System.err.println("delta to:  "+deltat);
//                System.err.println("odleglosc to:  "+odleglosc);

                double dy = getPredkosc() * deltat * (this.cel.y - this.pozycja.y) /
                        odleglosc;
                this.pozycja.x += dx;
                this.pozycja.y += dy;
            if(odleglosc<5.0){
                this.pozycja.x=this.cel.x;
                this.pozycja.y=this.cel.y;
            dy=0;
            dx=0;}
//        System.err.println("dx= " + dx + " " + "dy= " + dy + " pozycja x: " + this.pozycja.x + " pozycja y: " + this.pozycja.y + " cel x: " + this.cel.x + " this.cel.y " + this.cel.y);

    };
    public int getWaga(){
        int sum=0;
        sum+=this.silnik.getWaga();
        sum+=this.skrzyniaBiegow.getWaga();
        return sum;};
    public boolean exists=true;
    public Pozycja getPozycja(){return this.pozycja;};
    public String getModel(){return this.model;};
    public float getPredkosc(){
        setSpeed();
        return this.predkosc;};
    private SkrzyniaBiegow skrzyniaBiegow;
    private Silnik silnik;
    private Pozycja pozycja;
    private float predkosc;
    private boolean stanWlaczenia;
    private int nrRejest;
    private String model;
    private int predkoscmax;
    private Pozycja cel;
    public void setCel (Pozycja cel) {
        this.cel = cel;
    }
    public Pozycja getCel(){return this.cel;};
    private String imgId;
    public String getImgId() {return imgId;}
    public void setImgId(String imgId) {this.imgId = imgId;}

    public String getObjName(){
        return Integer.toString(nrRejest) + " " + model;
    };

    public Samochod(int predkoscmax, String model, int nrRejest, boolean stanWlaczenia, Pozycja pozycja, Silnik silnik, SkrzyniaBiegow skrzyniaBiegow) {
        this.predkoscmax = predkoscmax + 1;
        this.model = model;
        this.nrRejest = nrRejest;
        this.stanWlaczenia = stanWlaczenia;
        this.pozycja = pozycja;
        this.silnik = silnik;
        this.skrzyniaBiegow = skrzyniaBiegow;
        this.cel=pozycja;
        Thread thread = new Thread(this);
        thread.start();
        this.setSpeed();
    }

    public int getReg() {return this.nrRejest;}

    public int getMaxSpeed() {return this.predkoscmax;}
    public void setSpeed(){
        if(this.stanWlaczenia){
        this.predkosc = (float) (this.getEngRpm() * this.getGearCurr()) /1000;
        }
    }
    public String getEngName() {return this.silnik.getnazwa();  }

    public int getEngPrice() {return this.silnik.getCena();    }

    public int getEngRpm() {return this.silnik.getRpm();    }
    public int getEngMaxRpm(){return this.silnik.getMaxRpm();    }

    public int getEngWeight() { return this.silnik.getWaga();    }


    public String getGearName() {return this.skrzyniaBiegow.getnazwa();   }
    public void setMGear(){
        System.err.println("Próba zmniejszenia biegu");
        System.err.println(this.stanWlaczenia);

        if(this.stanWlaczenia && this.getEngRpm()<=3000){
            this.setPObroty(1500);
            this.skrzyniaBiegow.zmniejszBieg();}}
    public void setPGear(){
        if(this.stanWlaczenia && this.getEngRpm()>=3000){
            this.setMObroty(1500);
            this.skrzyniaBiegow.zwiekszBieg();}}

    public int getGearCurr() {return this.skrzyniaBiegow.aktualnyBieg;    }

    public int getGearWeight() {return this.skrzyniaBiegow.getWaga();    }

    public int getGearPrice() {return this.skrzyniaBiegow.getCena();
    }
}

