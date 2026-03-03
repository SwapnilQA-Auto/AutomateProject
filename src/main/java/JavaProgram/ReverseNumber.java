package JavaProgram;

import java.util.Scanner;

public class ReverseNumber {
    static void main() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num=scanner.nextInt();

        // Logic 1 using Algorithm
        int rev=0;
        while (num!=0){
            rev=rev*10+num%10;
            num=num/10;

        }
        System.out.println("Reverse number is: "+rev);

        //StringBuffer
        int numm=scanner.nextInt();
        StringBuffer stringBuffer=new StringBuffer(String.valueOf(numm));
        StringBuffer reverse =stringBuffer.reverse();
        System.out.println("Reverse number is: "+reverse);
        //StringBuilder
        int nummm=scanner.nextInt();
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(nummm);
       StringBuilder re = stringBuilder.reverse();
        System.out.println("Reverse number is: "+re);
    }
}
