import java.util.StringTokenizer;

public class StringTokenization{
    public static void main(String[] args) {
        String input = "hello world  two    spaces";
        StringTokenizer stringTokenization = new StringTokenizer(input);
        while(stringTokenization.hasMoreTokens())
            System.out.print(stringTokenization.nextToken()+"|");
        stringTokenization = new StringTokenizer(input, " ");
        System.out.println();
        while(stringTokenization.hasMoreTokens())
            System.out.print(stringTokenization.nextToken()+"|");
        System.out.println();
        stringTokenization = new StringTokenizer(input, " ", true);
        while(stringTokenization.hasMoreTokens())
            System.out.print(stringTokenization.nextToken()+"|");
    }    
}