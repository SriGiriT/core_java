import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/*
 * Throwable class is parent class for the error and exception
 * error can't be handled 
 * exception can be handled 
 * exception is inturn divided into two typed 
 * checked exception and unchecked exception
 */

public class ErrorException {
    public static void main(String[] args) {
        try{
            int[] arr = new int[Integer.MAX_VALUE];

        }catch (OutOfMemoryError e){
            e.printStackTrace();
        }

        try{
            File file = new File("newFile.txt");
            FileReader reader = new FileReader(file);

        }catch(FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
        }

        try{
            String a=null;
            System.out.println(a.length());
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }
    }


}
