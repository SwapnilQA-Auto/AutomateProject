package JavaProgram;

import java.util.Scanner;

public class PrimeNumber {
    static void main() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number: ");
        int a=scanner.nextInt();
        int count=0;
        if(a>1){
            for(int i=1;i<=a;i++){
                if(a%i==0){
                    count++;
                }
            }
            if(count==2){
                System.out.println("Prime Number");
            }
            else  System.out.println("Not Prime Number");

        }
        else System.out.println("Number is not Prime");

    }
}
