import java.util.*;

class Booking {
    String passengerId;
    int seatCount;
    double fare;

    Booking(String p, int s, double f) {
        passengerId = p;
        seatCount = s;
        fare = f;
    }
}

class Train {
    String trainId, source, destination;
    int totalSeats;
    double baseFare;
    int bookedSeats = 0;
    List<Booking> bookings = new ArrayList<>();

    Train(String id, String s, String d, int t, double b) {
        trainId = id;
        source = s;
        destination = d;
        totalSeats = t;
        baseFare = b;
    }

    int availableSeats() {
        return totalSeats - bookedSeats;
    }
}

public class SeatAllocation {
    static List<Train> trains = new ArrayList<>();

    static Train findTrain(String id) {
        for (Train t : trains)
            if (t.trainId.equals(id))
                return t;
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }

            String[] p = line.split(" ");

            if (p[0].equals("ADDTRAIN")) {
                if (findTrain(p[1]) == null) {
                    trains.add(new Train(p[1], p[2], p[3], Integer.parseInt(p[4]), Double.parseDouble(p[5])));
                }
            }

            else if (p[0].equals("BOOK")) {
                Train t = findTrain(p[1]);
                int seats = Integer.parseInt(p[3]);

                if (t == null || t.availableSeats() < seats) {
                    System.out.println("Booking failed");
                } else {
                    double fare = seats * t.baseFare + seats * 25;
                    t.bookedSeats += seats;
                    t.bookings.add(new Booking(p[2], seats, fare));
                    System.out.println("BOOKED " + p[1] + " " + p[2] + " " + (int)fare);
                }
            }

            else if (p[0].equals("CANCEL")) {
                Train t = findTrain(p[1]);
                if (t == null) {
                    System.out.println("Cancellation failed");
                    continue;
                }

                boolean found = false;
                Iterator<Booking> it = t.bookings.iterator();
                while (it.hasNext()) {
                    Booking b = it.next();
                    if (b.passengerId.equals(p[2])) {
                        t.bookedSeats -= b.seatCount;
                        it.remove();
                        System.out.println("CANCELLED " + p[1] + " " + p[2]);
                        found = true;
                        break;
                    }
                }

                if (!found)
                    System.out.println("Cancellation failed");
            }

            else if (p[0].equals("ROUTE")) {
                boolean found = false;
                for (Train t : trains) {
                    if (t.source.equals(p[1]) && t.destination.equals(p[2])) {
                        System.out.println(t.trainId + " " + t.availableSeats());
                        found = true;
                    }
                }
                if (!found)
                    System.out.println("No trains available");
            }

            else if (p[0].equals("SUMMARY")) {
                boolean any = false;
                for (Train t : trains) {
                    double sum = 0;
                    for (Booking b : t.bookings)
                        sum += b.fare;

                    if (sum > 0)
                        any = true;

                    System.out.println(t.trainId + " " + (int)sum);
                }
                if (!any)
                    System.out.println("No revenue generated");
            }
        }
    }
}