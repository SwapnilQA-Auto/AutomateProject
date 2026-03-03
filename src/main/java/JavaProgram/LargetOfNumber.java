package JavaProgram;

public class LargetOfNumber {
    static void main() {

        int a=55;
        int b=6;
        int c=100;
        System.out.println(a+" " +b+" "+c);

        if(a>b && a>c){
            System.out.println(a+" is larget number");
        }
        else if(b>a && b>c){
            System.out.println(b+" is larget number");
        }
        else {
            System.out.println(c+" is larget number");
        }

        //ternary operator
        int larget=a>b?a:b;
        larget=c>larget?c:larget;
        System.out.println(larget);

    }
}
