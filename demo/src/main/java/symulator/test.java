package symulator;
import symulator.Samochod;
public class test {
    public static void main(String[] args) {

        //potrzebne, żeby móc się odnieść bezpośrednio do tworzonych obiektów:
        Pozycja pos = new Pozycja (1, 1);
        Silnik silnik = new Silnik("volvo", "xc90",
                "robert", 123587, 1238974,
                7000);
        Sprzeglo sprzeglo = new Sprzeglo("volvo", "xc90",
                12387, 847,
                "Robert");
        SkrzyniaBiegow skrzyniaBiegow= new SkrzyniaBiegow("volvo", "xc90",
                "robert", 12387, 84774,
                1, 5,sprzeglo);
        Samochod samochod = new Samochod(100,
                "volvo", 123, true,
                pos,silnik,skrzyniaBiegow);


        samochod.wlacz();
//        for(int i=1;i<=5;i++){samochod.;}
        System.out.println("siema");

    }
}
