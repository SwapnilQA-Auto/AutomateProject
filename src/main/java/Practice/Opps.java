package Practice;

public class Opps {

    public Opps() {
        System.out.println("Hello Constructor");
    }

    public static void main (String args []){
        Opps op = new Opps();
        Pen pen = new Pen();
        pen.color="blue";
        pen.type="Gell";
        pen.write();
        pen.printcolor();

        Pen pen1 = new Pen();
        pen1.color="black";
        pen1.printcolor();

        Student s = new Student();
        s.name="Swapnil";
        s.age=59;
        s.printInfo(s.name, s.age);
    }

    // three type of constructor
    //class name same
    // do not return


}

