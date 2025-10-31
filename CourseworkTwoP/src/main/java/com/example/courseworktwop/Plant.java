package com.example.courseworktwop;

/**
 * SubClass to represent a Plant object.
 * Inherited from Perishable.
 */
public class Plant extends Perishable {
    /**
     * Plant Class Constructor
     * stores the attributes;
     *
     * @param sender
     * @param recipient
     */
    public Plant(SortingOffice sender, SortingOffice recipient) {
        super(sender, recipient);
    }

    /**
     * process method
     *
     * @param sortingOffice
     */
    public void process(SortingOffice sortingOffice) {
        locations.add(sortingOffice);
        if (locations.size() > 3) {
            expired = true;
        }
    }

    /**
     * Sender getter method
     *
     * @return sender
     */
    public SortingOffice getSender() {
        return sender;
    }

    /**
     * Receipient getters method
     *
     * @return recipient
     */
    public SortingOffice getRecipient() {
        return recipient;
    }

    /**
     * Receipt getters method.
     * returns String statement based on whether the delivered plant is expired or not.
     */
    public String getReceipt() {
        if (expired) {
            return "WARNING! Expired Plant delivered to " + getRecipient().getLocation() + ".";
        } else {
            return "Plant delivered to " + getRecipient().getLocation() + ".";
        }

    }
}
