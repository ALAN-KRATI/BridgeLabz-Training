import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ExamSystem exam = new ExamSystem();
        Scanner sc = new Scanner(System.in);
        boolean b = true;

        while(b){

            displayQuestions();
            System.out.println("\n----- Online Exam Proctor -----");
            System.out.println("1. Visit Question");
            System.out.println("2. Submit Answer");
            System.out.println("3. Submit Exam");
            System.out.println("4. Exit");

            System.out.println("Enter you choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter question id you visiting: ");
                    int id1 = sc.nextInt();
                    sc.nextLine();
                    exam.visitQuestion(id1);
                    break;

                case 2:
                    System.out.println("Enter question id you answering: ");
                    int id2 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter your answer: ");
                    String ans1 = sc.nextLine();
                    exam.sumbitAnswer(id2, ans1);
                    break;

                case 3:
                    exam.calculateScore();
                    break;
                    
                case 4:
                    b = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void displayQuestions(){
        System.out.println("----- Online Exam Question Paper -----");
        System.out.println("1. What is Java?");
        System.out.println("2. Which is OOPs?");
        System.out.println("3. Which langauge is 100% OO");
        System.out.println("4. Which keyword is used to refer to the current class attributes?");
        System.out.println("5. Which keyword is used to call parent class constructor?");
    }
}
