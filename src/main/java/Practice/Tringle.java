package Practice;

public class Tringle extends Shape{

    public void area (int l, int h){
        System.out.println((1/2*l*h));
    }

    void main() {

        Tringle t = new Tringle();
        t.color="red";
        t.area();
        this.area(5,3);
    }
}
