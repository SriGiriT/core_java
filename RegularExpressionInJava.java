import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionInJava {
    /*
     * Character classes 
     * 
     * [abc] a,b or c
     * [^abc] any character except a, b or c
     * [a-zA-Z] a through z or A through Z, inclusive(range)
     * [a-d[m-p]] a through d, or m through p [a-dm-p](union)
     * [a-z&&[def]] d, e or f (intersection)
     * [a-z&&[^bc]] a through z, except for b and c: [ad-z](subraction)
     * [a-z&&[^m-p]] a through z, and not m through p: [a-lq-z](subraction)
     * 
     * 
     * Regex Quantifier
     * X? - occurs once or not at all 
     * X+ - occurs once or more times
     * X* - X occurs zero or more times 
     * X{n} - X occurs n times only
     * X{n,} - X occurs n or more times
     * X{y,z} - X occurs at least y times but less than z times
     * 
     * Regex Metacharacters
     *  . - any character
     *  \d - any digits [0-9]
     *  \D - any non digit [^0-9]
     *  \s any whitespace character, short for [\t\n\x0B\f\r]
     *  \S any non-whitespace character
     *  \w any word character, short for[a-zA-Z_0-9]
     *  \W any non-word character, show for [^\w]
     *  \b a word boundary
     *  \B a non word boundary
     *  $ - placed at the end of the word
     */
    static String regrexForEmail = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    public static boolean emailCheck(String emailString){
        return Pattern.matches(regrexForEmail, emailString);
    }
    public static boolean isValidPhoneNumber(String matcherString){
        return Pattern.matches("\\d{10}", matcherString);
    }
    public static void regrexFinder(String patteString, String matcherString){
        boolean found = false;
        Pattern pattern = Pattern.compile(patteString);
        Matcher matcher = pattern.matcher(matcherString);
        while(matcher.find()){
            System.out.println("Found text "+matcher.group()+" start ind "+matcher.start()+" end ind "+matcher.end());
            found = true;
        }
        if(!found){
            System.out.println("No match found");
        }
    }
    public static boolean threeWayMatch(){
        // 1st way
        // Pattern p = Pattern.compile(".s");
        // Matcher m = p.matcher("as");
        // boolean isMatched = m.matches();
        
        // 2nd way
        // boolean isMatched = Pattern.compile(".s").matcher("as").matches();

        // 3rd way
        return Pattern.matches(".s", "as");
    }
    public static boolean chechUserName(String matcherString){
        return Pattern.matches("[a-zA-Z_.0-9]{6,50}", matcherString);
    }
    public static void main(String[] args) {
        // regrexFinder("java", "java jva java ja java");
        // System.out.println(isValidPhoneNumber("93839383939"));
        System.out.println(chechUserName("valid_userName38393"));
    }
}
