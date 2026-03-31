import java.io.*;

public class ReadFileLine {

    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
           
            FileReader fileRead = new FileReader("input.txt");

            read = new BufferedReader(fileReader);

            String line;
            while ((line = read.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } 
    }
}
