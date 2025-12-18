public class PenDivision{
    public static void main(String[] args){
        int pens = 14;
        int stud = 3;
        int ps = pens / stud;
        int remain = pens % stud;

        System.out.println("The pens per student is " + ps + " and the remaining pens not distributed is " + remain);
    }
}