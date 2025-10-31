package com.example.courseworktwop;


/**
 * SubClass to represent a Produce object.
 * Inherited from Perishable.
 */
public class Produce extends Perishable {
    private String currentLocation;
    private String trackingLocation;

    /**
     * Produce Class constructor
     * Stores the attributes Produce;
     *
     * @param sender
     * @param recipient
     */
    public Produce(SortingOffice sender, SortingOffice recipient) {
        super(sender, recipient);
        this.currentLocation = "";
        this.trackingLocation = "";
    }

    /**
     * Sender getter method.
     *
     * @return sender
     */
    public SortingOffice getSender() {
        return sender;
    }

    /**
     * Recipient getter method
     *
     * @return recipient
     */
    public SortingOffice getRecipient() {
        return recipient;
    }

    /**
     * Receipt getter method
     * returns a String statement based on if a product is expired or not.
     */
    public String getReceipt() {
        if (expired) {
            return "WARNING! Expired Produce delivered to " + getRecipient().getLocation() + ". Produce route: " + trackingLocation + ".";
        } else {
            return "Produce delivered to " + getRecipient().getLocation() + ". Produce route: " + trackingLocation + ".";
        }
    }

    /**
     * process method.
     *
     * @param sortingOffice
     */
    public void process(SortingOffice sortingOffice) {

        locations.add(sortingOffice);
        currentLocation = locations.get(locations.size() - 1).getLocation();
        if (sortingOffice == recipient) {
            trackingLocation += currentLocation;
        } else {
            trackingLocation += currentLocation + ",";
        }
    }
}