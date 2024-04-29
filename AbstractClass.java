import java.util.ArrayList;

/*
* If you want a class to contain a particular method but you want the actual implementation of that method to be determined by child classes, you can declare the method in the parent class as an abstract.
* Rules to be followed while defining constructors in an abstract class:
* Abstract classes can have constructors, but they cannot be instantiated directly. The constructors are used when a concrete subclass is created.
* There may be one or greater abstract methods in an abstract class, which signifies that those methods are not implemented by means of the class. To be instantiated, a subclass that extends an abstract class with abstract methods should implement the methods. It means that each abstract method declared within an abstract class need to have an implementation if a subclass needs to be a concrete class and be able to be instantiated. In other words, the functionality that the abstract class left open must be filled in by the subclass.
* When a subclass extends an abstract class with constructors, the subclass needs to call one of the constructors inside the superclass with the help of super key-word. Because the superclass constructor initializes the state of the object and units up any vital resources. If the subclass does now not call one of the constructors in the superclass, the object will not be well initialized and will now not function efficiently/correctly.
* It is feasible to define more than one constructor in an abstract class, similar to some other class. However, each constructor has to be defined with a different parameter list. It lets in subclasses to pick out which constructor to call based on their specific needs.
* */

abstract class ClassWithoutAbstractMethods{
    public int x;
}
abstract class Shape{
    protected int x;
    protected int y;
    Integer z;
    ArrayList<Integer> arr;
    public Shape(){
        this.x = 0;

        this.y = 0;
        arr = new ArrayList<>();
    }
    public Shape(int x, int y){
        this.x = x;
        this.y = y;
        arr = new ArrayList<>();
    }
    public void printCoordinate(){
        System.out.printf("(x=%d, y=%d)\n", x, y);
    }
    public abstract double getArea();
}

class Circle extends Shape{
    protected double radius;
    Circle(){
        super();
        this.radius = 0;
    }
    Circle(double radius){
        super();
        this.radius = radius;
    }
    Circle(double radius, int x, int y){
        super(x, y);
        this.radius = radius;
    }
    Circle(Circle circle){
        super(circle.x, circle.y);
        this.radius = circle.radius;
    }
    @Override
    public double getArea() {
        arr.add((int)radius);
        return this.radius*this.radius*3.14;
    }
}
public class AbstractClass {
    public static void main(String[] args) {
        // call constructor without parameters
        Circle circle = new Circle(8.3);
        System.out.println( circle.getArea());
        // call constructor with parameters
        Shape shape = new Circle(4, 2, 3);
        System.out.println(shape.getArea());
        shape.printCoordinate();
        // call copy constructor
        Shape shape1 = new Circle((Circle)shape);
        Shape shape2 = new Circle(circle);
        shape1.printCoordinate();
        shape2.printCoordinate();
        // we can't able to instantiate even without abstract method in our abstract class
        ClassWithoutAbstractMethods clas = new ClassWithoutAbstractMethods() {

        };
        System.out.println(clas.getClass());
    }
}
