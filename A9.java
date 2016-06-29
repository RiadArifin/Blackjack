

/**
 * A program to play blackjack
 * @author Md.Riad Arifin (A00395462)
 */
import java.io.*;
import java.util.*;

public class A9 {

    /**
     * @param args the command line arguments
     */
    
    //creating some private variables
    private static int k = 0;
    private static int dealerScore = 0;
    private static int playerScore = 0;
    
    static card[] pHand = new card[52];
    static card[] dHand = new card[52];
    static deck d = new deck();

    public static void main(String[] args) throws Exception {

        //assigning scanner
        Scanner kbd = new Scanner(System.in);
        
        //assigning some variables
        int round = 0;

        char isCard = 'y';
        char isRound = 'y';

        int i = 0;

        d.shuffle();

        //a while loop to repeat the entire round
        while (isRound == 'y') {
            i = 0;
            k = 0;
            ++round;
            dealerScore = 0;
            playerScore = 0;
            System.out.printf("Round %d\n", round);
            int j = i + 2;
            System.out.print("You have: ");
            d.shuffle();
            try {
                for (i = i; i < j; i++) {

                    pHand[i] = d.draw();
                    System.out.print(pHand[i] + ",");
                    if (pHand[i].valueOf() == 1 && (playerScore + 11) <= 17) {
                        playerScore += 11;
                    } else {

                        playerScore += pHand[i].valueOf();
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            dHand[k] = d.draw();
            dealerScore += dHand[k].valueOf();

            if (playerScore <= 17) {
                System.out.print("[Score " + playerScore + "]");
            } else {
                System.out.print("[ Bust,Score " + 0 + "]");
            }

            System.out.print("\nDealer has:" + dHand[k] + "[Score " + dealerScore + "]");

            while (playerScore <= 17 && isCard == 'y') {

                System.out.print("\n>> Another card (y/n)? ");
                isCard = kbd.next().charAt(0);
                if (isCard == 'y') {
                    ++i;
                    pHand[i - 1] = d.draw();
                    if (pHand[i - 1].valueOf() == 1 && (playerScore + 11) <= 17) {
                        playerScore += 11;
                    } else {

                        playerScore += pHand[i - 1].valueOf();
                    }
                    System.out.print("You have: ");
                    for (int h = 0; h < i; h++) {
                        System.out.print(pHand[h] + ",");
                    }
                    if (playerScore <= 17) {
                        System.out.print("[Score " + playerScore + "]");
                    } else {
                        System.out.print("[ Bust,Score " + 0 + "]");
                    }
                    System.out.print("\nDealer has:" + dHand[k] + "[Score " + dealerScore + "]");
                }
            }

            if (isCard == 'n') {
                System.out.println("\n** Dealer turns her card over. **");
                ++k;

                dealerRecord(k);

                while (dealerScore < 17) {
                    System.out.println("\n** Dealer draws a card. **");
                    ++k;

                    dealerRecord(k);

                }
                if (dealerScore < playerScore) {
                    System.out.println("\nDealer loses, you win!");
                } else if (21 < dealerScore) {
                    System.out.println("\nDealer busts, you win!");
                } else if (playerScore < dealerScore) {
                    System.out.println("\nDealer wins, you lose!");
                } else {
                    System.out.println("\nA tie, nobody wins!");
                }
            }

            System.out.print("\n>> Play another round (y/n)? ");
            isRound = kbd.next().charAt(0);
        }

    }

    public static void dealerRecord(int k) {

        try {
            dHand[k] = d.draw();
            if (dHand[k].valueOf() == 1 && (dealerScore + 11) <= 21) {
                dealerScore += 11;
            } else {
                dealerScore += dHand[k].valueOf();
            }
            System.out.print("Dealer has:");
            for (int h = 0; h <= k; h++) {
                System.out.print(dHand[h] + ",");
            }
            if (dealerScore <= 21) {
                System.out.print("[Score " + dealerScore + "]");
            } else if (dealerScore <= 21 && dHand[k].valueOf() == 1) {

            } else {
                System.out.print("[ Bust,Score " + 0 + "]");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
