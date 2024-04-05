import java.util.HashMap;
import java.util.PriorityQueue;

public class Auction {
    private HashMap<Integer, Integer> bidMap; // Hash table to store bidder ID and corresponding bid amount
    private PriorityQueue<Bid> bidQueue; // Priority queue to maintain bids in descending order

    private int minimumBid;

    public Auction(int minimumBid) {
        this.minimumBid = minimumBid;
        this.bidMap = new HashMap<>();
        this.bidQueue = new PriorityQueue<>((a, b) -> {
            if (a.bidAmount != b.bidAmount) {
                return b.bidAmount - a.bidAmount; // Highest bid first
            } else {
                return a.bidId - b.bidId; // Earlier bidder first in case of tie
            }
        });
    }

    // Method to place a bid
    public void placeBid(int bidderId, int bidAmount, int bidId) {
        if (bidAmount >= minimumBid) {
            bidMap.put(bidderId, bidAmount);
            bidQueue.offer(new Bid(bidderId, bidAmount, bidId));
        }
    }

    public Bid determineWinner() {
        if (!bidQueue.isEmpty()) {
            return bidQueue.peek(); // Winner is the bidder at the front of the queue
        }
        return null;
    }
}