package JavaProgram;

public class MinMaxArray {
    public static void main(String[] args) {
//find min and max number
        int[] numbers = {30, 5, 19, 9};
        int min=numbers[0];
        int max=numbers[0];
        for(int a:numbers){
            if(a<min){
                min=a;
            }
            if(a>max){
                max=a;
            }
        }
        System.out.println(min);
        System.out.println(max);

    }
}
