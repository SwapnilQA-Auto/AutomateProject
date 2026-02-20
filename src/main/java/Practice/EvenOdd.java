package Practice;

public class EvenOdd {
    static void main() {

     /*   int i;
        int j;
        int countEven = 0;
        int countOdd= 0;

        for(i=0;i<=100;i++){
            if(i%2==0){
                System.out.println(i+" is Even number");
                countEven=countEven+i;
            }
        }
        System.out.println("All even count is "+countEven);
        for(j=0;j<=20;j++){
            if(j%2!=0){
                System.out.println(j+" is Odd number");
                countOdd=countOdd+j;
            }
        }
        System.out.println("All odd count is "+countOdd);  */


        Encap en= new Encap();
        en.setName("Swapnil Mowade");
        en.setSalary(90);
        System.out.println("Name is "+ en.getName());
        System.out.println("Salary is "+ en.getSalary()+ "$");


    }
}
