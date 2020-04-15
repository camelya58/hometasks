package hometask24;

public class Lesson24 {
    public static void main(String[] args) {
        Platyfish platyfish = new Platyfish("Platyfish");
        System.out.println(platyfish.name);
        platyfish.eat();
        platyfish.swim();
        platyfish.sleep();

        Speakable penquin = new Penguin("Penguin");
        penquin.speak();

        Animal lion = new Lion("Lion");
        System.out.println(lion.name);
        lion.eat();
        lion.sleep();

        Mammal lion2 = new Lion("Lion2");
        System.out.println(lion2.name);
        lion2.eat();
        lion2.sleep();
        lion2.run();
        lion2.speak();
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
abstract class Fish extends Animal{
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
abstract class Mammal extends Animal implements Speakable{
    Mammal(String name) {
        super(name);
        this.name = name;
    }
    abstract void run();
}
abstract class Bird extends Animal implements Speakable{
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
class Penguin extends Bird{
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

class Platyfish extends Fish{
    Platyfish(String name){
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