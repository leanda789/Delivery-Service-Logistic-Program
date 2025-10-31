package com.example.courseworktwop;
import java.util.ArrayList;

/**
 * Class to represent a Perishable object.
 * Implements the Deliverable interface class.
 */
public class Perishable implements Deliverable {
    public SortingOffice sender;
    public SortingOffice recipient;
    public boolean expired;
    public ArrayList<SortingOffice> locations = new ArrayList<>();

    public Perishable() {
        this.expired = false;
    }

    /**
     * Perishable constructor
     * stores the attributes;
     *
     * @param sender
     * @param recipient
     */
    public Perishable(SortingOffice sender, SortingOffice recipient) {
        this.sender = sender;
        this.recipient = recipient;
        this.expired = false;
    }

    /**
     * Sorting Office process method
     *
     * @param sortingOffice
     */
    public void process(SortingOffice sortingOffice) {
    }

    /**
     * Sender getters method.
     *
     * @return
     */
    public SortingOffice getSender() {
        return sender;
    }

    /**
     * Recipient getters method.
     *
     * @return recipient.
     */
    public SortingOffice getRecipient() {
        return recipient;
    }

    /**
     * Receipt getters method.
     *
     * @return null.
     */
    public String getReceipt() {
        return null;
    }


}