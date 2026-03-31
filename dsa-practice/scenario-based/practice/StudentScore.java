import java.util.*;

public class StudentScore{
    public static double averageScore(int[] scores){
        int sum = 0;

        for(int i : scores){
            sum += i;
        }

        return sum/scores.length;
    }

    public static void highLowScore(int[] scores){
        int high = 0, low = 10000;

        for(int i : scores){
            if(high < i){
                high = i;
            }
            if(low > i){
                low = i;
            }
        }

        System.out.println("Highest Score: " + high);
        System.out.println("Lowest Score: " + low);
    }

    public static void scoreAboveAverage(int[] scores){
        double average = averageScore(scores);

        System.out.println("\nAbove average marks: ");
        for(int i : scores){
            if(i > average){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];

        for(int i = 0; i < n; i++){
            scores[i] = sc.nextInt();
        }

        System.out.println("\nAverage Score: " + averageScore(scores));
        highLowScore(scores);
        scoreAboveAverage(scores);

    }
}