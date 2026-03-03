package JavaProgram;


import java.awt.*;

public class ReverseString {
    static void main() {
        //Using normal string
        String original = "Hello";
        String reverse = "";
        int len = original.length();
        for (int i = len - 1; i >= 0; i--) {
            reverse = reverse + original.charAt(i);
        }
        System.out.println(reverse);
//Using aaray
        String arry = "Swapnil";
        char[] aa = arry.toCharArray();
        int le = aa.length;
        String abc = " ";
        for (int i = le - 1; i >= 0; i--) {
            abc = abc + aa[i];
        }
        System.out.println(abc.trim());


        //using string aaray
        String name="Swapnil Mowade";
        String mn="";
        String o=" ";

        String []aaa = name.split(" ");// swapnil Mowade
        int f =aaa.length;
        for(String a:aaa){
            String z="";
            int c=a.length();
            for(int i =c-1;i>=0;i--){
                z=z+a.charAt(i);
            }
            mn=mn+z+" ";
        }
        System.out.println(mn.trim());
        int cc=aaa.length;
        for(int i =cc-1;i>=0;i--){
            o=o+aaa[i]+" ";
        }
        System.out.println(o.trim());

        StringBuffer stringBuffer=new StringBuffer("Swam");
       StringBuffer abhc= stringBuffer.reverse();
       System.out.println(abhc);



    }

}
