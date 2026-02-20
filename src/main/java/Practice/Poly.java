package Practice;

import org.openqa.selenium.Platform;

public class Poly {

    public static void login (String username, int password){
        System.out.println("login using username");
    }
    public static void login (int account, int password){
        System.out.println("login using account");

    }
    public static void login (char c, int password){
        System.out.println("login using c");

    }

    static void main() {
        login("swapnil",872);
    }
}
