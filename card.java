
/**
 * A class for card
 * @author Md.Riad Arifin (A00395462)
 */
public class card {
    
     private static enum suit {
    Hearts, Spades, Clubs, Diamonds, None
  }
  private static enum value {
    Joker, Ace, Two, Three, Four, Five, Six,
    Seven, Eight, Nine, Ten, Jack, Queen, King
  }
 
   private suit mySuit;
  private value myValue;
  
  private suit int2suit (int j) {
    if (j < 0) return (suit.None);
    switch (j) {
      case 0: return (suit.Hearts);
      case 1: return (suit.Clubs);
      case 2: return (suit.Diamonds);
      case 3: return (suit.Spades);
      default:
        // i > 51 (0-51 = regular cards)
        return (suit.None);
    }
  } /* end int2suit() */
  
   private value int2value (int i) {
    switch (i) {
      case  0: return(value.Ace);
      case  1: return(value.Two);
      case  2: return(value.Three);
      case  3: return(value.Four);
      case  4: return(value.Five);
      case  5: return(value.Six);
      case  6: return(value.Seven);
      case  7: return(value.Eight);
      case  8: return(value.Nine);
      case  9: return(value.Ten);
      case 10: return(value.Jack);
      case 11: return(value.Queen);
      case 12: return(value.King);
      default:
        // can never happen, needed to suppress compiler warning
        return (value.Joker);
    }
  } /* end int2value() */
   
    public card (int j,int i) {
        //System.out.println(j+ " " + i);
    mySuit = int2suit(j);
    if (mySuit.equals(suit.None))
      myValue = value.Joker;
    else
      myValue = int2value(i);
     //System.out.println(mySuit+ " " + myValue);
  } /* end constructor */

     public String toString () {
    return (myValue.toString() + " of " + mySuit.toString());
     }

     public  int valueOf () {
    int val = myValue.ordinal();
    if (val >10) val = 10;
    return (val);
  }
     public String suitOf () {
    return mySuit.toString();
  }
}
