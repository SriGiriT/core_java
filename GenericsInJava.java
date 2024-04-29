// this is how we can specify the upper bound of the generics

// Type parameters in generics
// T - Type
// E - Element
// N - Number
// K, V - Key, Value type
class StorageClassWithUpperBound<N extends Number>{
    
}
class StorageClass<T>{
    public T value;
    public T getValue(){
        return value;
    }
    public void setValue(T value){
        this.value = value;
    }
}
public class GenericsInJava {
    public static void main(String[] args) {
        StorageClass<Integer> storageObject = new StorageClass();
        StorageClass<String> storageObject1 = new StorageClass();
        storageObject.setValue(100);
        storageObject1.setValue("value");
        System.out.println(storageObject.getValue());
        System.out.println(storageObject1.getValue());
    }
}
