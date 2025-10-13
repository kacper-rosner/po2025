import java.util.Random;
import java.util.ArrayList;

public class Lotto2 {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i =0;i<=5;i++){

            boolean k=false;
            int a=0;
            while (k==false) {
                //System.out.println("false "+a);
                a=r.nextInt(49 - 1 + 1) + 1;
                if (num.isEmpty()){
                    k=true;
                }
                else {
                    for (int element : num) {
                        k = false;
                        if (element == a) {
                            break;
                        }
                        k = true;
                        //System.out.println("True");
                    }
                }
            }
            num.add(a);
            //System.out.println(a);
        }
        System.out.println(num);
    }
}
