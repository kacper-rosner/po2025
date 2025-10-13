import java.util.Random;
import java.util.ArrayList;

public class Lotto3 {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> userInput = new ArrayList<Integer>();
        for (String arg : args){
            try {
                userInput.add(Integer.parseInt(arg));
            }
            catch (NumberFormatException e) {
                System.out.println("");
            }
        }

        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i =0;i<=5;i++){

            boolean k=false;
            int a=0;
            while (k==false) {
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
                    }
                }
            }
            num.add(a);
        }
        System.out.println(num);
        System.out.println(userInput);
        float success=0;
        for (int element : num) {
            for (int b : userInput ){
                if (element == b){
                    success++;
                }
            }
        }
        System.out.println(success);
    }
}
