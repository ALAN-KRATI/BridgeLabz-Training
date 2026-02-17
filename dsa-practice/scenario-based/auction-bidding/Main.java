public class Main {

    public static void main(String[] args){

        AuctionItem laptop = new AuctionItem("Gaming Laptop");

        User u1 = new User("Alice");
        User u2 = new User("Bob");
        User u3 = new User("Charlie");

        try{

            laptop.placeBid(u1, 10000);
            laptop.placeBid(u2, 15000);
            laptop.placeBid(u3, 14000); 

        }catch(InvalidBidException e){
            System.out.println(e.getMessage());
        }

        laptop.showAllBids();
        laptop.showHighestBid();
    }
}