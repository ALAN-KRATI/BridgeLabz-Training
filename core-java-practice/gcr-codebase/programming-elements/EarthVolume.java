public class EarthVolume{
    public static void main(String[] args){
        double radiusInkm = 6378;
        double radiusInMile = 6378 * 1.6;
        double volumeInKm = (4/3) * 3.14 * radiusInkm * radiusInkm * radiusInkm;
        double volumeInMile = (4/3) * 3.14 * radiusInMile * radiusInMile * radiusInMile;

        System.out.println("The volume of earth in cubic kilometers is " + volumeInKm + " and cubic miles is " + volumeInMile);
    }
}