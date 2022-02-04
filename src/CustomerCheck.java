import java.util.ArrayList;

public class CustomerCheck
{
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check)
    {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices()
    {
        double total = 0;
        for (MenuItem a : check) {
            total += a.getPrice();
        }
        return total;
    }

    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies()
    {
        double total = totalPrices();
        boolean hasDaily = false;
        for (MenuItem a : check) {
            if (a.isDailySpecial()) {
                hasDaily = true;
            }
        }
        return !hasDaily && total >= 40;
    }

    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck()
    {
      double total = totalPrices();
      double original = total;
      if (couponApplies()){
          total *= .75;
      }
      int customers = 0;
      for (MenuItem a : check) {
          if (a.isEntree()) {
              customers++;
          }
      }
      if (customers >= 6) {
          total += original * .2;
      }
      return total;
    }
}