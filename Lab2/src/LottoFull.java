import java.util.Random;
import java.util.ArrayList;
import java.io.*;

public class LottoFull {
    public static void main(String[] args) {
        int success=0;
        int licznik=0;
        long abcdef=System.currentTimeMillis();
        while(success!=6) {
            licznik++;

            Random r = new Random();

            ArrayList<Integer> user = new ArrayList<Integer>();
            for (int i = 0; i <= 5; i++) {

                boolean k = false;
                int a = 0;
                while (k == false) {
                    a = r.nextInt(49 - 1 + 1) + 1;
                    if (user.isEmpty()) {
                        k = true;
                    } else {
                        for (int element : user) {
                            k = false;
                            if (element == a) {
                                break;
                            }
                            k = true;
                        }
                    }
                }
                user.add(a);
            }

            ArrayList<Integer> num = new ArrayList<Integer>();
            for (int i = 0; i <= 5; i++) {

                boolean k = false;
                int a = 0;
                while (k == false) {
                    a = r.nextInt(49 - 1 + 1) + 1;
                    if (num.isEmpty()) {
                        k = true;
                    } else {
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

            success=0;
            for (int element : num) {
                for (int b : user) {
                    if (element == b) {
                        success++;
                    }
                }
            }
        }
        System.out.println(success);
        System.out.println(licznik);
        System.out.println(System.currentTimeMillis()-abcdef);
    }
}
