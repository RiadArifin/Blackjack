
/**
 * A class for deck
 * @author Md.Riad Arifin (A00395462)
 */
import java.util.*;

public class deck {

    public final int SIZE = 52;
    private int remaining = 52;

    private card[] cards = new card[SIZE];
    private Random randomiser = new Random();
    int k = 0;

    public deck() {
        //int k=0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 13; i++) {
                cards[k] = new card(j, i);
                //++k;
                //System.out.println("card " + k + " is " + cards[k]);
                ++k;
            }
        }
    }

   public void shuffle() {
        for (int i = 0; i < 52; i++) {
            Random randomiser = new Random();
            int j = randomiser.nextInt(SIZE);
            card swap = cards[j];
            cards[j] = cards[i];
            cards[i] = swap;
        }
    }

    public card draw() throws Exception {
        if (remaining == 0) {
            throw new Exception("No cards in deck");
        }
        remaining--;
        return (cards[remaining]);
    }

}
