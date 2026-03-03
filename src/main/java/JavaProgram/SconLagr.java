package JavaProgram;

public class SconLagr {
    static void main() {
        int[] num1 = {10, 5, 20, 100, 20};
        int st=0;
        int sec=0;
        for(int i=0;i< num1.length;i++){
            for(int j=i+1;j< num1.length;j++){
                if(num1[i]>num1[j]){
                   st=num1[i];
                }
            }



        }
        System.out.println(st);


        }

       }
