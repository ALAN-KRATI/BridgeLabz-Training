import java.io.*;

public class UserInputToFile {

    public static void main(String[] args) {
        BufferedReader reads = null;
        FileWriter writes = null;

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            reader = new BufferedReader(isr);

            writes = new FileWriter("output.txt");

            System.out.println("Enter text (type 'exit' to stop):");
            String line;

            while (true) {
                line = reads.readLine();

                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                writes.write(line);
            }

            System.out.println("Input successfully written to file.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
