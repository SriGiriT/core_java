import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Throwable class is parent class for the error and exception
 * error can't be handled 
 * exception can be handled 
 * exception is inturn divided into two typed 
 * checked exception and unchecked exception
 */

public class ErrorException {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        try{
            int[] arr = new int[Integer.MAX_VALUE];
            arr[0] = 10;

        }catch (OutOfMemoryError e){
            e.printStackTrace();
        }

        try{
            File file = new File("newFile.txt");
            FileReader reader = new FileReader(file);
            reader.close();

        }catch(FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
        }catch(IOException ioException){
            
        }

        try{
            String a=null;
            System.out.println(a.length());
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }
    }


}
