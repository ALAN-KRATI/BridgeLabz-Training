import java.util.*;

public class AnalyzeString{
    public static int paraLength(StringBuilder  sb){
        String para = sb.toString();
        String[] words = para.split("\\s+");
        return words.length;
    }

    public static String largestWord(StringBuilder sb) {
        String para = sb.toString();
        String[] words = para.split("\\s+");
        int max = 0;
        String largest = "";

        for(String word : words){
            if(word.length() > max){
                max = word.length();
                largest = word;
            }
        }

        return largest;
    }

    public static StringBuilder replaceWord(String replaceWord, String replaceWith, StringBuilder sb){
        String para = sb.toString();
        String[] words = para.split(" ");
        StringBuilder sbb = new StringBuilder();

        for(int i = 0; i < words.length; i++){
            if(words[i].equals(replaceWord)){
                sbb.append(replaceWith + " ");
            }
            else sbb.append(words[i] + " ");
        }

        return new StringBuilder(sbb.toString().trim());

    }

    public static void displayText(StringBuilder sb){
        System.out.println(sb.toString());
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.equals("")) break;
            sb.append(line);
        }

        boolean b = true;
        while(b){
            System.out.println("\n---------- Choice Bar ----------");
            System.out.println("1. Length of paragaraph.");
            System.out.println("2. Largest Word in the paragraph.");
            System.out.println("3. Replace word with another.");
            System.out.println("4. Exit.");

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println(paraLength(sb));
                    break;
                case 2:
                    System.out.println("Largest word: " + largestWord(sb));
                    break;
                case 3:
                    String replaceWord = sc.next();
                    String replaceWith = sc.next();
                    sb = replaceWord(replaceWord, replaceWith, sb);
                    displayText(sb);
                    break;
                case 4:
                    b = false;
                    System.out.println("\nExiting...");
                    break;
            }
        }
    }
}