package JavaProgram;

public class PalindromeString {
    static void main() {
        String name="Madam";
        String reve=" ";

        int num=name.length();
        for(int i=num-1;i>=0;i--){
            reve=reve+name.charAt(i);
        }
        if(name.equalsIgnoreCase(reve.trim()))
        {
            System.out.println("String is palidrome: "+reve.trim());
        }
        else System.out.println("String is not palindrome: "+reve.trim());





    }
}
