package Practice;

public class Cat extends Animal{


    public static void makeNoise(){
        System.out.println("Cat meows");
    }
    static void main() {

        Animal aaa= new Cat();
        Animal.makeNoise();



    }
}
