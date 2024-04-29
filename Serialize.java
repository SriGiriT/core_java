
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;

class Employee implements Externalizable{
    private static final long serialVersionUID = 510034302;
    private int id;
    private String name;
    private String password;
    // private int score;
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        name = (String) in.readObject();
        if(!name.startsWith("123")) System.out.println("corrupted data");
        password = (String) in.readObject();
        if(!password.endsWith("world")) System.out.println("corrupted data");
        name = name.substring(3);
        password = password.substring(0, password.length()-5);
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject("123"+name);
        out.writeObject(password+"world");
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Employee(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public Employee(){}
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name +", password="+ password +"]";
    }
    // public int getScore() {
    //     return score;
    // }
    // public void setScore(int score) {
    //     this.score = score;
    // }
    
}

public class Serialize {
    public static void serialize(Object obj, String fileName) throws IOException, ClassNotFoundException{
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.close();
    }
    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object out = ois.readObject();
        ois.close();
        return out;
    }
    public static void main(String[] args) throws Exception{
        Employee emp = new Employee(1, "emp", "empemp@empemp");
        System.out.println(emp);
        serialize(emp, "save.txt");
        emp = null;
        Employee emp1 = (Employee)deserialize("save.txt");
        System.out.println(emp1);
    }
}
