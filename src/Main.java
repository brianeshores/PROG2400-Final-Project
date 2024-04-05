import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Auction auction = new Auction(100); // Minimum bid set to $100
        auction.placeBid(1, 10, 1);
        auction.placeBid(2, 110, 2);
        auction.placeBid(3, 120, 3);
        auction.placeBid(4, 130, 4);
        auction.placeBid(5, 130, 5);
        auction.placeBid(6, 130, 6);
        auction.placeBid(7, 10, 7);
        auction.placeBid(9, 300, 8);
        auction.placeBid(7, 300, 9);
        auction.placeBid(2, 300, 2);
        auction.placeBid(6, 300, 9);




        Bid winner = auction.determineWinner();
        if (winner.bidderId != -1) {
            System.out.println("Winner: Bidder " + winner.bidderId + "\n");
            System.out.println("Winning Bid: $ " + winner.bidAmount + "\n");
        } else {
            System.out.println("No winner found");
        }
    }
}