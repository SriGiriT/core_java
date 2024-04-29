
class A{

}
// single inheritance 
class B extends A{

}
// multi level inheritance
class C extends B{

}
interface D{

}
interface E{

    
}
// multiple inheritance 
class F extends C implements D, E{

}

interface Flyer{
    public void fly();    
}
interface Swimmer{
    public void swim();    
}
class Animal{
    public void eat(){
        System.out.println("Animal is eating");
    }
}
class Bird extends Animal implements Flyer{
    @Override
    public void fly() {
        System.out.println("Bird can fly");
    }
}
class Fish extends Animal implements Swimmer{
    @Override
    public void swim() {
        System.out.println("Fish can swim");
    }
}
// Hybrid inhertance
class Duck extends Bird implements Swimmer{
    @Override
    public void fly() {
        super.fly();
        System.out.println("Duck can fly too");
    }
    @Override
    public void swim() {
        System.out.println("Duck can swim too");
    }
} 
public class InheritanceInJava{
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.eat();
        duck.fly();
        duck.swim();
    }
}