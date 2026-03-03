package JavaProgram;

import java.util.Random;

public class RandomNumberString {
    static void main() {

        Random random = new Random();
       int ran= random.nextInt(999);
       System.out.println(ran);
       System.out.println(Math.random());

    }
}
