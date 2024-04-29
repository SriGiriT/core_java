// special data type which contains a set of predefined constants
// An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).
enum Colors{
    RED, 
    GREEN,
    BLUE,
    YELLO,
    GRAY,
    BLACK,
    WHITE
}
public class Enumuration {
    public static void main(String[] args) {
        Colors fColor = Colors.GREEN;
        System.out.println(fColor);
        switch (fColor) {
            case RED:
                System.out.println("Red Color");
                break;
            case GREEN:
                System.out.println("Green Color");
                break;
            case GRAY:
                System.out.println("Gray Color");
                break;
            case BLUE:
                System.out.println("Blue Color");
                break;
            case BLACK:
                System.out.println("Black Color");
                break;
            case WHITE:
                System.out.println("White Color");
                break;
            case YELLO:
                System.out.println("Yello Color");
                break;
            default:
                break;
        }
        for(Colors color:Colors.values()){
            System.out.println(color);
        }
    }
}
