package Practice;

public class Condition {



   public static void main(String[] args) {
       int count=0;


       for (int i =0; i<=10;i++){
           if(i%2==0){
               System.out.println("Even "+i);
               count=count+i;

           }
           else {
               System.out.println("Odd "+i);
           }
       }
       System.out.println(count);




   }


}
