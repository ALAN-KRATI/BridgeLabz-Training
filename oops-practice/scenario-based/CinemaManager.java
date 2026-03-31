import java.util.*;

public class CinemaManager{

    static List<String> titles = new ArrayList<>();
    static List<String> showtimes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        while(true){
            System.out.println("----------Cinema Time----------");
            System.out.println("1. Add a movie.");
            System.out.println("2. Search a movie.");
            System.out.println("3. Display Shows.");
            System.out.println("4. Exit");
            System.out.println();
            System.out.println("Enter you choice(1-4): ");
            int choice  = sc.nextInt();
            sc.nextLine();
        
            switch(choice){
                case 1:
                    System.out.println("\n\n Enter Movie Name: ");
                    String name = sc.nextLine();
                    System.out.println("\n Enter show time: ");
                    String time = sc.nextLine();
                    addMovie(name, time);
                    break;

                case 2:
                    System.out.println("\n Enter the movie you'd like to search: ");
                    String search = sc.nextLine();
                    searchMovie(search);
                    break;
                
                case 3:
                    displayAllMovies();
                    break;
                
                case 4:
                    System.out.println("GoodBye....!");
                    return;
                
                default:
                    System.err.println("Invalid option!!!");
            }

        }
    }


    public static void addMovie(String name, String time){
        titles.add(name);
        showtimes.add(time);
        System.out.println("Movie added successfully!!!");
    }

    public static void searchMovie(String keyword){
        boolean b = false;

        for(int i =0; i < titles.size(); i++){
            if(titles.get(i).toLowerCase().contains(keyword.toLowerCase())){
                System.out.println(titles.get(i) + " - Showtime: " + showtimes.get(i));
                b = true;
            }

            if(!b) { System.out.println("No matching movies found."); }
        }
    }

    public static void displayAllMovies(){
        for(int i = 0; i < titles.size(); i++){
            System.out.println((i+1) + titles.get(i) + " - Showtime: " + showtimes.get(i));
        }
    }

}