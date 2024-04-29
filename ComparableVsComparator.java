import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Student implements Comparable<Student>, Serializable{
    private static final long serialVersionUID = 871038740;    
    int roll_no;
    String name;
    Student(int roll_no, String name){
        this.roll_no = roll_no;
        this.name = name;
    }
    @Override
    public int compareTo(Student o) {
        if(this.roll_no == o.roll_no)return 0;
        else if(this.roll_no > o.roll_no) return 1;
        else return -1;
    }
    @Override
    public String toString() {
        return roll_no+"-"+name;
    }
}

public class ComparableVsComparator {
    public static void main(String[] args) {
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(new Student(500, "zyan"));
        arr.add(new Student(400, "abishek"));
        arr.add(new Student(100, "shalmal"));
        Collections.sort(arr);
        for(Student st:arr){
            System.out.println(st);
        }
        System.out.println();
        // Comparator
        // based on name
        Collections.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student arg0, Student arg1) {
                return arg0.name.compareTo(arg1.name);
            }
        });

        // Iterator
        Iterator<Student> it = arr.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
}
