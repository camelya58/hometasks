package hometask25;

public class Lesson25{
    public static void main(String[] args) {
        Animal a1 = new Lion("Leva");
        Animal a2 = new Penguin("Kovalski");
        Animal a3 = new Platyfish("Mechenosec");
        Mammal m1 = new Lion("Leva2");
        Bird b1 = new Penguin("Kovalski2");
        Fish f1 = new Platyfish("Mechenosec2");
        Lion l1 = new Lion("Leva3");
        Penguin p1 = new Penguin("Kovalski3");
        Platyfish f2 = new Platyfish("Mechenosec3");
        Speakable s1 = new Lion("Leva4");
        Speakable s2 = new Penguin("Kovalski4");
        Speakable[] speakables = {m1, b1, l1,p1, s1,s2};
        Animal[] animals = {a1, a2, a3, m1, b1, f1, l1, p1, f2};
        for (Speakable var : speakables){
            if (var instanceof Lion){
                Lion l2 = (Lion)var;
                System.out.println(l2.name);
                l2.eat();
                l2.sleep();
                l2.run();
                l2.speak();
            }
            else if (var instanceof Penguin){
                Penguin p2 = (Penguin)var;
                System.out.println(p2.name);
                p2.eat();
                p2.sleep();
                p2.fly();
                p2.speak();
            }
            System.out.println("_____________________");
        }

        for (Animal var : animals){
            if (var instanceof Lion){
                Lion l3 = (Lion)var;
                System.out.println(l3.name);
                l3.eat();
                l3.sleep();
                l3.run();
                l3.speak();
            }
            else if (var instanceof Penguin){
                Penguin p3 = (Penguin)var;
                System.out.println(p3.name);
                p3.eat();
                p3.sleep();
                p3.fly();
                p3.speak();
            }
            else if (var instanceof Platyfish){
                Platyfish f3 = (Platyfish) var;
                System.out.println(f3.name);
                f3.eat();
                f3.sleep();
                f3.swim();
            }
            System.out.println("_____________________");
        }
    }

}
abstract class Animal {
    String name;
    Animal(String name){
        this.name = name;
    }

    abstract void eat();
    abstract  void sleep();
}
abstract class Fish extends Animal {
    Fish(String name){
        super(name);
        this.name = name;
    }
    @Override
    void sleep(){
        System.out.println("It's very interesting to watch fishes sleeping.");
    }
    abstract  void swim();
}

interface Speakable {
    default void speak(){
        System.out.println("Somebody speaks.");
    }
}
abstract class Mammal extends Animal implements Speakable {
    Mammal(String name) {
        super(name);
        this.name = name;
    }
    abstract void run();
}
abstract class Bird extends Animal implements Speakable {
    Bird(String name) {
        super(name);
    }
    abstract void fly();
    @Override
    public void speak() {
        System.out.println(name + "sings.");
    }
}

class Lion extends Mammal {
    Lion(String name){
        super(name);
        this.name = name;
    }
    @Override
    void eat() {
        System.out.println("Lion likes meat as any predator. ");
    }
    @Override
    void sleep() {
        System.out.println("Lion sleeps most of the day.");
    }
    @Override
    void run() {
        System.out.println("Lion is not the most fastest cat.");
    }
}
class Penguin extends Bird {
    Penguin(String name){
        super(name);
    }

    @Override
    void eat() {
        System.out.println("Penguin likes to eat fishes.");
    }

    @Override
    void sleep() {
        System.out.println("Penguin are sleeping near each other.");
    }

    @Override
    void fly() {
        System.out.println("Penguins can't fly.");
    }

    @Override
    public void speak() {
        System.out.println("Penguins can't sing as nightingale.");
    }
}

class Platyfish extends Fish {
    Platyfish(String name) {
        super(name);
    }

    @Override
    void swim() {
        System.out.println("Platyfish is an attractive fish which is swimming fast.");

    }

    @Override
    void eat() {
        System.out.println("Platyfish is not predatory fish, it's eating a forage.");
    }
}