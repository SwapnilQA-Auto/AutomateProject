package JavaProgram;

public class CountNumber {

    static void main() {
        int a=123456;
        int count=0;
        while (a>0){
            a=a/10;
            count++;
        }
        System.out.println(count);

        //Count even and odd numbers
        int y=76;
        int countEven=0;
        int countOdd=0;
        while (y>0){
            int re=y%10;
            if(re%2==0){
                countEven++;
            }
            else { countOdd++;}
            y=y/10;
        }
        System.out.println("Even digit "+countEven);
        System.out.println("Odd digit "+countOdd);
    }
}
