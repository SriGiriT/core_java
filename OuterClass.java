class AnotherClass{
    public static void anotherClassMethod(){
        OuterClass.InnerClass2 innerClass2 = new OuterClass().new InnerClass2();
        innerClass2.method();
    }
}

abstract class AnotherAbstractClass{
    abstract void print();
}

public class OuterClass {
    int id = 10;
    // we can have private/protected/default/public/static/final inner class
    private class InnerClass1{
        int id = 100;
        public void method(){
            int id = 1000;
            System.out.println(id);
            System.out.println(this.id);
            System.out.println(OuterClass.this.id);
        }
        public class InnerInnerClass1{

        }

    }
    protected class InnerClass2{
        int id = 100;
        public void method(){
            InnerClass1 innerClass1 = new InnerClass1();
            innerClass1.method();
        }
    }
    static class InnerClass3{

    }
    abstract class InnerClass7{

    }
    public class InnerClass4{
        public void innerClass4(){
            InnerClass2 innerClass2 = new InnerClass2();
            System.out.println(innerClass2.id);
        }
    }
    interface InnerInterface{

    }
    // we can extend non abstract inner class and implements interfaces
    class InnerClass5 extends InnerClass2 implements InnerInterface{

    }
    // we can also extends abstract inner classes too 
    class InnerClass6 extends InnerClass7{

    }

    public static void main(String[] args) {
        // how we create object for inner class
        OuterClass.InnerClass1 innerClass1 =  new OuterClass().new InnerClass1();
        innerClass1.method();
        // how we create object for nested inner class
        OuterClass.InnerClass1.InnerInnerClass1 innerInnerClass1 = new OuterClass().new InnerClass1().new InnerInnerClass1();


        // InnerClass4 innerClass4 = new OuterClass().new InnerClass4();
        // innerClass4.innerClass4();


        //Local Inner class
        // we only have final and abstract local inner class alone
        class localInnerClass{

        }
        // Calling inner class from another class
        AnotherClass.anotherClassMethod();


        // Anonymous class
        AnotherAbstractClass anotherAbstractClass = new AnotherAbstractClass() {
            public void print(){
                System.out.println("print from another abstract class");
            }
        };
        anotherAbstractClass.print();
    }
}
class TestClass1{
    // public static void main(String[] args) {
    //     System.out.println("Testclass 1");
    // }
}
class TestClass2{
    // public static void main(String[] args) {
    //     System.out.println("Testclass 2");
    // }
}