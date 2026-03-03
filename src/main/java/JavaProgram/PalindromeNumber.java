package JavaProgram;

import java.util.Scanner;

public class PalindromeNumber {

    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Numerb: ");

        int num = scanner.nextInt();
        int pali=num;
        int rev=0;
        while (num!=0){

            rev=rev*10+num%10;
            num=num/10;
        }
        System.out.println(rev);
        if(pali==rev){
            System.out.println("Number is palidendrom");
        }
        else System.out.println("Number is not palinderom");

    }
}
