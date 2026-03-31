import java.util.*;

public class GradingSystem{
  public static void totalAndAveragePerStudent(int[] id, String[] names, int[][] grades){
    int n = grades.length;
    int m = grades[0].length;

    for(int i = 0; i < n; i++){
        int sum = 0;
        for(int j = 0; j < m; j++){
            sum += grades[i][j];
        }
        double average = sum/m;
        System.out.println("Student Name: " + names[i] + " ID: " + id[i] + " Total: " + sum + " Average: " + average);
    }
  } 

  public static void highestGradePerSubject(int[][] grades){
    int n = grades.length;
    int m = grades[0].length;

    for(int i = 0; i < m; i++){
        int max = 0;
        for(int j = 0; j < n; j++){
            if(grades[j][i] > max){
                max = grades[j][i];
            }
        }
        System.out.println("Maximum grade of subject " + (i+1) + ": " + max);
    }
  }

  public static void classAverage(int[][] grades){
    int n = grades.length;
    int m = grades[0].length;
    int sum = 0;
    int total = n*m;

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            sum += grades[i][j];
        }
    }

    System.out.println("Overall Average of Class: " + sum/total);
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of Students: ");
    int n = sc.nextInt();
    System.out.println("Enter number of Subjects: ");
    int m = sc.nextInt();

    int[] id = new int[n];
    String[] names = new String[n];
    int[][] grades = new int[n][m];

    for(int i = 0; i < n; i++){
        System.out.println("\nEnter ID of student " + (i+1) + ": ");
        int ids = sc.nextInt();
        id[i] = ids;

        sc.nextLine();

        System.out.println("Enter name of student " + (i+1) + ": ");
        String name = sc.nextLine();
        names[i] = name;
    }

    for(int i = 0; i < n; i++){
        System.out.println("\nEnter grade of student for all the subjects for student " + (i+1) + ": ");
        for(int j = 0; j < m; j++){
            int score = sc.nextInt();
            grades[i][j] = score;
        }
    }

    System.out.println();
    totalAndAveragePerStudent(id, names, grades);
    System.out.println();
    highestGradePerSubject(grades);
    System.out.println();
    classAverage(grades);
    System.out.println();
  }
}