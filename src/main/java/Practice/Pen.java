package Practice;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Pen {

    String color;
    String type; //ballpoint or Gel

    public void write (){
        System.out.println("Writing something");
    }

    public void printcolor (){
        System.out.println(this.color);
    }

}
