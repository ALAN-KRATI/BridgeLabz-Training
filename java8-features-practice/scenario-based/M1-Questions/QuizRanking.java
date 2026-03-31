import java.util.*;

class Student {
    String name;
    String dept;
    int q1, q2, q3;

    Student(String name, String dept, int q1, int q2, int q3) {
        this.name = name;
        this.dept = dept;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    int total() {
        return q1 + q2 + q3;
    }
}

public class QuizRanking { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] p = line.split(" ");

            if (p[0].equals("Record")) {
                String name = p[1];
                String dept = p[2];
                int q1 = Integer.parseInt(p[3]);
                int q2 = Integer.parseInt(p[4]);
                int q3 = Integer.parseInt(p[5]);

                list.add(new Student(name, dept, q1, q2, q3));
                System.out.println("Record Added: " + name);
            }

            else if (p[0].equals("Top")) {

                if (list.isEmpty()) {
                    System.out.println("No Records Available");
                    continue;
                }

                String key = p[1];

                if (key.equals("Q1") || key.equals("Q2") || key.equals("Q3")) {
                    int max = Integer.MIN_VALUE;

                    for (Student s : list) {
                        int val = key.equals("Q1") ? s.q1 : key.equals("Q2") ? s.q2 : s.q3;
                        max = Math.max(max, val);
                    }

                    for (Student s : list) {
                        int val = key.equals("Q1") ? s.q1 : key.equals("Q2") ? s.q2 : s.q3;
                        if (val == max) {
                            System.out.println(s.name + " " + val);
                        }
                    }
                }

                else {
                    int max = Integer.MIN_VALUE;
                    boolean found = false;

                    for (Student s : list) {
                        if (s.dept.equals(key)) {
                            found = true;
                            max = Math.max(max, s.total());
                        }
                    }

                    if (!found) {
                        System.out.println("Department Not Found");
                        continue;
                    }

                    for (Student s : list) {
                        if (s.dept.equals(key) && s.total() == max) {
                            System.out.println(s.name + " " + s.total());
                        }
                    }
                }
            }
        }
    }
}