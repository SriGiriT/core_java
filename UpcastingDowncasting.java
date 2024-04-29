class Parent{
    public void parent_method(){
        System.out.println("parent method in parent class");
    }
    public void parent_specific_method(){
        System.out.println("parent specific method");
    }
}

class Child extends Parent{
    @Override
    public void parent_method(){
        System.out.println("parent method in child class");
    }
    public void child_method(){
        System.out.println("Child method in child class");
    }

}

public class UpcastingDowncasting {
    public static void main(String[] args) {
        Parent ref = new Child();
        // Upcasting the parent class reference only can able to access the child class scope of methods.
        ref.parent_method();
        // ref.child_method();
        Child child_ref = (Child)ref;
        // Downcasting by doing this we can now able to access the child class objects too.
        child_ref.child_method();
        child_ref.child_method();
        // Parent parent = child_ref;
        // parent.child_method();
    }
}

