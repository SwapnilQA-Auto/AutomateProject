package JavaProgram;

public class Star {
    int m1(String a){
       // System.out.println(a);
        return 10;
    }
    static void main() {
        for(int i= 1; i<=5; i++)
        {

            for(int j=i; j<=i; j++)
            {
                System.out.println(i);
            }

            System.out.println();
        }
        Star star=new Star();
        int b=star.m1("abc");
        System.out.println(b);



    }
}
