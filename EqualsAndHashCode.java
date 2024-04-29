class A{
    int x;
    String y;
    A(int x, String y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int hashCode() {
        int hash = y.hashCode();
        hash += 31 * (x+"").hashCode();
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if(this.hashCode() == obj.hashCode()){
            if(this == obj)return true;
            if(obj == null || this.getClass() != obj.getClass())return false;
            A input = (A)obj;
            return this.x == input.x && this.y.equals(input.y);
        }else{
            return false;
        }
    }
}

public class EqualsAndHashCode {
    public static void main(String[] args) {
        A a = new A(1, "3");
        A a1 = new A(1, "3");
        A a2 = new A(2, "4");
        System.out.println(a.equals(a1));
        System.out.println(a.equals(a2));
    }
}
