package JavaProgram;

public class SumOfDigit {
    static void main() {
        int a=99;
        int sum=0;
        while (a>0){
            sum=sum+a%10;
            a=a/10;
        }
        System.out.println("sum of digit "+sum);

    }
}
