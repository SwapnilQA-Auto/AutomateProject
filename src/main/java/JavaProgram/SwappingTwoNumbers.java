package JavaProgram;

public class SwappingTwoNumbers {

    static void main() {
        //Logic 1- thrird variable
        int aa =10;
        int bb=20;
        System.out.println("Before swappning: "+aa+" "+bb);
        int c=aa;
        aa=bb;
        bb=c;
        System.out.println("Logic 1 After swappning: "+aa+" "+bb);
        //Logic 2- Addtion and Substraction
        int a =10;
        int b=20;
        System.out.println("Before swappning: "+a+" "+b);
        a=a+b; //10+20=30;
        b=a-b; //30-20=10
        a=a-b; //30-10=20
        System.out.println("Logic 2 After swappning: "+a+" "+b);
        //Logic 3- Mutliplicate and division (a&b should not be zero)
        int d =10;
        int e=20;
        System.out.println("Before swappning: "+d+" "+e);
        d=d*e; //10*20=200;
        e=d/e; //200/20=10
        d=d/e; //200/10=20
        System.out.println("Logic 3 After swappning: "+d+" "+e);

        //Logic 4- bitwise XOR ^
        int x=10;
        int z=20;
        System.out.println("Before swappning: "+x+" "+z);
        x=x^z;
        z=x^z;
        x=x^z;
        System.out.println("Logic 4 After swappning: "+x+" "+z);
        // Logic 5- single statement
        int g=10;
        int h=20;
        System.out.println("Before swappning: "+g+" "+h);
        h=g+h-(g=h);
        System.out.println("Logic 5 After swappning: "+g+" "+h);



    }

}
