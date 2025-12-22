import java.util.Scanner;
public class QuadraticRoots {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble(); 
        double c = sc.nextDouble();

        double[] roots = findRoots(a, b, c);

        if (roots.length == 0) System.out.println("No real roots");
        else for (double r : roots) System.out.println("Root: " + r);
    }

        public static double[] findRoots(double a, double b, double c) {
        double roots = Math.pow(b, 2) - 4 * a * c;
        
        if (roots < 0) return new double[]{};
        else if (roots == 0) return new double[]{-b / (2 * a)};
        else {
            double root1 = (-b + Math.sqrt(roots)) / (2 * a);
            double root2 = (-b - Math.sqrt(roots)) / (2 * a);
            return new double[]{root1, root2};
        }
    }
}
