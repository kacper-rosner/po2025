import java.util.Random;
public class Lotto {
    public static void main(String[] args) {
        Random r = new Random();
        int[] num = new int[6];
        for (int i =0;i<=5;i++){

            boolean k=false;
            int a=0;
            while (k==false) {

                a=r.nextInt(49 - 1 + 1) + 1;
                for (int element : num) {
                    k=false;
                    if (element == a){
                        break;
                    }
                    k=true;
                }
            }
            num[i]=a;
        }
        for (int i =0;i<=5;i++){
            System.out.println(num[i]);
        }
    }
}
