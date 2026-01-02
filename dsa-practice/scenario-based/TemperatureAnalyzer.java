import java.util.*;

public class TemperatureAnalyzer{
    // Method to calculate average temperature per day
    public static float[] averagePerDay(float[][] temps) {
        float[] averages = new float[7];

        for (int day = 0; day < 7; day++) {
            float sum = 0;
            for (int hour = 0; hour < 24; hour++) {
                sum += temps[day][hour];
            }
            averages[day] = sum / 24;
        }

        return averages;
    }

    // Method to find hottest and coldest day
    public static void findHottestAndColdestDay(float[][] temps) {
        float[] averages = averagePerDay(temps);

        int hottestDay = 0;
        int coldestDay = 0;

        for (int i = 1; i < averages.length; i++) {
            if (averages[i] > averages[hottestDay]) {
                hottestDay = i;
            }
            if (averages[i] < averages[coldestDay]) {
                coldestDay = i;
            }
        }

        System.out.println("Hottest Day: Day " + (hottestDay + 1));
        System.out.println("Coldest Day: Day " + (coldestDay + 1));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float[][] temperatures = {
            // Day 1
            {18.5f, 18.0f, 17.8f, 17.6f, 17.5f, 18.0f, 19.2f, 21.0f,
            23.5f, 25.0f, 26.3f, 27.5f, 28.0f, 28.4f, 28.1f, 27.0f,
            25.5f, 24.0f, 22.5f, 21.0f, 20.0f, 19.5f, 19.0f, 18.7f},

            // Day 2
            {18.2f, 17.9f, 17.6f, 17.4f, 17.3f, 17.9f, 19.0f, 21.2f,
            23.8f, 25.4f, 26.8f, 27.9f, 28.6f, 29.0f, 28.7f, 27.8f,
            26.2f, 24.6f, 23.0f, 21.5f, 20.4f, 19.8f, 19.3f, 18.9f},

            // Day 3
            {19.0f, 18.6f, 18.3f, 18.1f, 18.0f, 18.7f, 20.1f, 22.4f,
            24.9f, 26.7f, 28.0f, 29.2f, 30.0f, 30.4f, 30.1f, 29.0f,
            27.5f, 25.8f, 24.2f, 22.7f, 21.5f, 20.8f, 20.2f, 19.7f},

            // Day 4
            {20.1f, 19.7f, 19.3f, 19.1f, 19.0f, 19.8f, 21.3f, 23.6f,
            26.0f, 27.9f, 29.5f, 30.7f, 31.5f, 31.9f, 31.6f, 30.4f,
            28.8f, 27.0f, 25.3f, 23.8f, 22.6f, 21.8f, 21.1f, 20.6f},

            // Day 5
            {19.6f, 19.2f, 18.9f, 18.7f, 18.6f, 19.3f, 20.7f, 22.9f,
            25.2f, 27.0f, 28.4f, 29.6f, 30.3f, 30.6f, 30.2f, 29.1f,
            27.6f, 25.9f, 24.3f, 22.8f, 21.6f, 20.9f, 20.3f, 19.9f},

            // Day 6
            {18.9f, 18.5f, 18.2f, 18.0f, 17.9f, 18.5f, 19.8f, 21.9f,
            24.0f, 25.7f, 27.0f, 28.2f, 29.0f, 29.4f, 29.1f, 28.0f,
            26.5f, 24.9f, 23.4f, 21.9f, 20.8f, 20.1f, 19.6f, 19.2f},

            // Day 7
            {18.3f, 18.0f, 17.7f, 17.5f, 17.4f, 18.1f, 19.5f, 21.6f,
            23.9f, 25.6f, 26.9f, 28.1f, 28.9f, 29.2f, 28.8f, 27.7f,
            26.1f, 24.5f, 23.0f, 21.6f, 20.5f, 19.9f, 19.3f, 18.9f}
        };


        findHottestAndColdestDay(temperatures);
        System.out.println("Average temperatures: " + Arrays.toString(averagePerDay(temperatures)));

    }
}