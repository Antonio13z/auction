/**
 * Maintain details of someone who participates in an auction.
 * @author David J. Barnes and Michael Kolling.
 * @version 2006.03.30
 */
public class Person
{
    // The name of this person.
    private final String name;

    /**
     * Create a new person with the given name.
     * @param name The person's name.
     */
    public Person(String name)
    {
        this.name = name;
    }

    /**
     * @return The person's name.
     */
    public String getName()
    {
        return name;
    }
    
    public void bidFor(int lotNumber, Auction subasta, long value)
    {
        Lot selectedLot = subasta.getLot(lotNumber);
        if(selectedLot != null) {
            boolean successful = selectedLot.bidFor(new Bid(this, value));
            if(successful) {
                System.out.println("The bid for lot number " +
                                   lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                                   " already has a bid of: " +
                                   highestBid.getValue());
            }
        }
    }

}
