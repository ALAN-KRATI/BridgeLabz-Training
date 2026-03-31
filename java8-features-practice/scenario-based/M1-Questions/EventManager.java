import java.util.*;

abstract class Festival {
    String name, location, date;

    Festival(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    abstract void display();
}

class MusicFestival extends Festival {
    String headliner, genre;
    int price;

    MusicFestival(String name, String location, String date, String headliner, String genre, int price) {
        super(name, location, date);
        this.headliner = headliner;
        this.genre = genre;
        this.price = price;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Headliner: " + headliner);
        System.out.println("Music Genre: " + genre);
        System.out.println("Ticket Price: " + price);
    }
}

class FoodFestival extends Festival {
    String cuisine;
    int stalls, fee;

    FoodFestival(String name, String location, String date, String cuisine, int stalls, int fee) {
        super(name, location, date);
        this.cuisine = cuisine;
        this.stalls = stalls;
        this.fee = fee;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Cuisine: " + cuisine);
        System.out.println("Number of Stalls: " + stalls);
        System.out.println("Entry Fee: " + fee);
    }
}

class ArtFestival extends Festival {
    String artType;
    int artists, fee;

    ArtFestival(String name, String location, String date, String artType, int artists, int fee) {
        super(name, location, date);
        this.artType = artType;
        this.artists = artists;
        this.fee = fee;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Art Type: " + artType);
        System.out.println("Number of Artists: " + artists);
        System.out.println("Exhibition Fee: " + fee);
    }
}

public class EventManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Festival> map = new HashMap<>();

        while (true) {
            String line = sc.nextLine();
            if (line.equals("EXIT")) break;

            String[] p = line.split(" ");

            if (p[0].equals("ADD_FESTIVAL")) {
                String type = p[1];

                if (type.equals("MUSIC")) {
                    map.put(p[2], new MusicFestival(p[2], p[3], p[4], p[5], p[6], Integer.parseInt(p[7])));
                } 
                else if (type.equals("FOOD")) {
                    map.put(p[2], new FoodFestival(p[2], p[3], p[4], p[5], Integer.parseInt(p[6]), Integer.parseInt(p[7])));
                } 
                else if (type.equals("ART")) {
                    map.put(p[2], new ArtFestival(p[2], p[3], p[4], p[5], Integer.parseInt(p[6]), Integer.parseInt(p[7])));
                }
            }

            else if (p[0].equals("DISPLAY_DETAILS")) {
                Festival f = map.get(p[1]);
                if (f != null) f.display();
            }
        }
    }
}