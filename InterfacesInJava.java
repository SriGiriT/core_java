import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/*
* Writing an interface is similar to writing a class.
* However, a class describes the attributes and behaviors of an object.
* An interface contains behaviors that a class implements.
* Unless the class that implements the interface is abstract, all the methods of the interface need to be defined in the class.
* An interface is not extended by a class; it is implemented by a class.
* An interface can extend multiple interfaces.
* */



/*
* Rules for defining overriding methods in Java Interfaces
* Checked exceptions should not be declared on implementation methods other than the ones declared by the interface method or subclasses of those declared by the interface method.
* method d is an example for the above point
* The signature of the interface method and the same return type or subtype should be maintained when overriding the methods.
* method b is an example for the above point
* An implementation class itself can be abstract and if so, interface methods need not be implemented.
* Class A need not to implements all the abstract methods into it
* */


interface ParentInterface{
    public void a();
    public Collection<String> b();
    public void d() throws IOException;
}

interface childInterface extends ParentInterface{
    public void dd() throws FileNotFoundException;
    public void d() throws FileNotFoundException;
}

abstract class A implements ParentInterface{
    @Override
    public void a() {
        System.out.println("a");
    }
    abstract void c();
}
class B extends A{
    @Override
    public ArrayList<String> b() {
        System.out.println("b");
        return new ArrayList<>();
    }
    // overloading of override method
    public void b(int a){
        System.out.println(a);
    }

    @Override
    void c() {
        System.out.println("c");
    }

    @Override
    public void d() throws FileNotFoundException {

    }
}

/*
* A class can implement more than one interface at a time.
* A class can extend only one class, but implement many interfaces.
* An interface can extend another interface, in a similar way as a class can extend another class.
* */
interface X{

}
interface Y{

}
class Q extends B implements X, Y{

}

class W implements X, Y{

}
interface Z extends X, Y{

}



// interface without any methods is called tagging interface
/*
* Creates a common parent − As with the EventListener interface, which is extended by dozens of other interfaces in the Java API, you can use a tagging interface to create a common parent among a group of interfaces. For example, when an interface extends EventListener, the JVM knows that this particular interface is going to be used in an event delegation scenario.
* Adds a data type to a class − This situation is where the term, tagging comes from. A class that implements a tagging interface does not need to define any methods (since the interface does not have any), but the class becomes an interface type through polymorphism.
* */
interface CommonShape{

}
class CircleClass implements CommonShape{
    public void draw(){
        System.out.println("O");
    }
}
class SquareClass implements CommonShape{
    public void draw(){
        System.out.println("[]");
    }
}
public class InterfacesInJava {
    public static void printShape(CommonShape shape){
        if(shape instanceof CircleClass){
            ((CircleClass)shape).draw();
        }else if(shape instanceof SquareClass){
            ((SquareClass)shape).draw();
        }
    }
    public static void main(String[] args) {
        CommonShape circleClass = new CircleClass();
        printShape(circleClass);
    }
}