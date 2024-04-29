import java.io.*;
/*
 * 
 * I/O stream 
 * --> ByteStream
 *     --> InputStream
 *         --> FileInputStream
 *         --> ByteArrayInputStream
 *         --> ObjectInputStream
 *         --> DataInputStream
 *         --> PipedInputStream
 *     --> OutputStream
 *         --> FileOutputStream
 *         --> ByteArrayOutputStream
 *         --> ObjectOutputStream
 *         --> DataOutputStream
 *         --> PipedOutputStream
 * --> CharacterStream
 *     --> Reader
 *         --> FileReader
 *         --> CharArrayReader
 *         --> StringReader
 *         --> BufferedReader
 *         --> LineNumberReader
 *     --> Writer
 *         --> FileWriter
 *         --> CharArrayWriter
 *         --> StringWriter
 *         --> BufferedWriter
 *         --> PrintWriter
 * 
 * 
 * class level hierarchy 
 * https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/io/package-tree.html
 * FileWriter and BufferedWriter allows to append text onto the file 
 * 
 */
// Reads data as byte by byte
class FileInputOutputStreamClass{
    public static void read(String fileName){
        try(FileInputStream fileInputStream = new FileInputStream(new File(fileName))){
            int val;
            while((val = fileInputStream.read())!=-1){
                System.out.print((char)val);
            }
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    public static void write(String fileName, String newData){
        try(FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName))){
            for(char i:newData.toCharArray()){
                fileOutputStream.write(i);
            }
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
}
// OuputStream implemented by the FilterOutputStream which is extended by BufferedOutputStream
class BufferedInputOutputStream{
    public static void read(String fileName){
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))){
            int val;
            while((val=bufferedInputStream.read()) != -1){
                System.out.print((char)val);
            }
        }catch(IOException iosException){
            iosException.printStackTrace();
        }
    }
    public static void write(String fileName, String newData){
        try(BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName))){
            for(char i:newData.toCharArray()){
                bufferedOutputStream.write(i);
            }
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
// Reads data by character by character
class FileReaderWriterClass{
    public static void read(String fileName){
        try(FileReader fileReader = new FileReader(new File(fileName))){
            int val;
            while((val = fileReader.read()) != -1){
                System.out.print((char)val);
            }
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    public static void write(String fileName, String newData, boolean flag){
        try(FileWriter fileWriter = new FileWriter(new File(fileName), flag)){
            fileWriter.write("\n"+newData);
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
}
// Improve Reader preformance by providing buffer which reduces system calls 
class BufferedReaderWriterClass{
    /*
     * 
     */
    public static void read(String fileName){
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))){
            String line;
            while((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void write(String fileName,String newData, boolean flag){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, flag))){
            bufferedWriter.write("\n"+newData);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
class ObjectInputOutputStreamClass{
    public static void read(String fileName){
        try(ObjectInputStream objectinputStream = new ObjectInputStream(new FileInputStream(fileName))){
            Student obj = (Student)objectinputStream.readObject();
            System.out.println(obj);
        }catch(IOException ioException){
            ioException.printStackTrace();
        }catch(ClassNotFoundException classNotFoundException){
            classNotFoundException.printStackTrace();
        }
    }
    public static void write(String fileName, Student student){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            objectOutputStream.writeObject(student);
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
}
class DataInputOuputStreamClass{
    @SuppressWarnings("deprecation")
    public static void read(String fileName){
        try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fileName))){
            int val1 = dataInputStream.readInt();
            double val2 = dataInputStream.readDouble();
            String val3 = dataInputStream.readLine();
            System.out.printf("%d, %e, %s", val1, val2, val3);
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    public static void write(String fileName, int val1, double val2, String val3){
        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(fileName))){
            dataOutputStream.writeInt(val1);
            dataOutputStream.writeDouble(val2);
            dataOutputStream.writeBytes(val3);
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
}
// which can be used to implement read write operation in multithreaded env
class PipedInputOutputStreamClass{
    // final PipedInputStream pipedInputStream = new PipedInputStream();
    // final PipedOutputStream pipedOutputStream = new PipedOutputStream();
    // public static void read(String fileName){
    //     try(PipedInputStream pipedInputStream = new PipedInputStream()){
    //         pipedInputStream.read();
    //     }
    //     catch (IOException e) {
    //     }
    // }
}

public class ReadWriteClass {
    // With Stream
    public static void main(String[] args) {
        String fileName = "C:\\Users\\srigiri-20969\\prog\\git_clone\\core_java\\input.txt";

        // FileReaderWriterClass.read(fileName);
        // FileReaderWriterClass.write(fileName, "Add new line with File Writer with append", true);     
        // Student st = new Student(1002, "Srigiri T");
        // ObjectInputOutputStreamClass.write(fileName, st);
        // ObjectInputOutputStreamClass.read(fileName);
        // DataInputOuputStreamClass.write(fileName, 1, 2.3, "StringData");
        // DataInputOuputStreamClass.read(fileName);
        BufferedInputOutputStream.read(fileName);
        BufferedInputOutputStream.write(fileName, "new lines ");
    }

}