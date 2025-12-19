public class PenDivision{
    public static void main(String[] args){
        int pens = 14;
        int students = 3;
        int penPerStudent = pens / students;
        int remaining = pens % students;

        System.out.println("The pens per student is " + penPerStudent + " and the remaining pens not distributed is " + remaining);
    }
}