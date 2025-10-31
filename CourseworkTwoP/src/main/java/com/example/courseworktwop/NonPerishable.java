package com.example.courseworktwop;

/**
 * Class to represent a NonPerishable object.
 */
public class NonPerishable implements Deliverable {
    private final SortingOffice sender;
    private final SortingOffice recipient;
    private final double weight;
    private final boolean fragile;
    private boolean broken = false;


    /**
     * NonPerishable constructor
     * stores the defined NonPerishable attributes.
     */
    public NonPerishable(SortingOffice sender, SortingOffice recipient, double weight, boolean fragile) {
        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;
        this.fragile = fragile;
        this.broken = false;
    }

    /**
     * sender getter method
     *
     * @return sender
     */
    public SortingOffice getSender() {
        return sender;
    }

    /**
     * recipient getter method.
     *
     * @return recipient
     */
    public SortingOffice getRecipient() {
        return recipient;
    }

    /**
     * void process method.
     * Determines whether item is fragile.
     *
     * @param sortingOffice
     */
    public void process(SortingOffice sortingOffice) {
        if (fragile && "X560Y320CScotland".equals(sortingOffice.getLocation())) {
            broken = true;
        }
    }

    /**
     * Checks what type of NonPerishable item has been delivered.
     * returns a String statement on receipt about the type of NonPerishable item purchased.
     */
    public String getReceipt() {
        if (fragile && !broken) {
            return "Fragile Non-Perishable delivered to " + getRecipient().getLocation() + ".";
        } else if (fragile) {
            return "Fragile Non-Perishable delivered to " + getRecipient().getLocation() + ". Item is broken.";
        } else {
            return "Non-Perishable delivered to " + getRecipient().getLocation() + ".";
        }
    }
}