public class EarthVolume{
    public static void main(String[] args){
        double rkm = 6378;
        double rMile = 6378 * 1.6;
        double vKm = (4/3) * 3.14 * rkm * rkm * rkm;
        double vMile = (4/3) * 3.14 * rMile * rMile * rMile;

        System.out.println("The volume of earth in cubic kilometers is " + vKm + " and cubic miles is " + vMile);
    }
}