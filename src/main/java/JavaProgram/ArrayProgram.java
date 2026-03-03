package JavaProgram;

public class ArrayProgram  {


    static void main() {
       String a="S84289W7428@#@*(&#@(*&#937A48P9N87227I908092L";
       String f="";
       int count=0;
       for(int i=0;i<a.length();i++){
           char c=a.charAt(i);
           if(!Character.isDigit(c) && Character.isDigit(c)){
               f=f+c;
               count++;
           }
       }
       System.out.println(f);
        System.out.println(count);
    }
}
