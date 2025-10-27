package zadania;
import zadania.Zoo;

public class test {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.fill();
        System.out.println(zoo.sum());
    }
}
