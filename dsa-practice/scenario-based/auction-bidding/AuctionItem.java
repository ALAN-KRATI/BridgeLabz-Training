import java.util.TreeMap;

public class AuctionItem {

    private String itemName;
    private TreeMap<Bid, User> bids = new TreeMap<>();

    public AuctionItem(String itemName){
        this.itemName = itemName;
    }

    // place bid
    public void placeBid(User user, double amount) throws InvalidBidException {

        if(!bids.isEmpty()){
            Bid highest = bids.lastKey();

            if(amount <= highest.getAmount()){
                throw new InvalidBidException("Bid must be higher than current highest bid: " + highest.getAmount());
            }
        }

        bids.put(new Bid(amount), user);
    }

    public void showHighestBid(){
        if(bids.isEmpty()){
            System.out.println("No bids yet.");
            return;
        }

        Bid highest = bids.lastKey();
        User winner = bids.get(highest);

        System.out.println("Highest Bidder: " + winner);
        System.out.println("Bid Amount: " + highest);
    }

    public void showAllBids(){
        System.out.println("\nAll Bids (Lowest → Highest):");
        bids.forEach((bid, user) -> System.out.println(user + " -> " + bid));
    }
}