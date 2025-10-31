package com.example.courseworktwop;

import java.util.ArrayList;
/**
 * Class to represent a Sorting Office object.
 */
public class SortingOffice {
    private static int nextID = 1;
    private final ArrayList<SortingOffice> connections = new ArrayList<>();
    private final int iD;
    private final int x;
    private final int y;
    private final String location;
    private final String country;
    private final boolean international;
    private ArrayList<String> postCodes = new ArrayList<>();
    /**
     * SortingOffice Class Constructor
     * stores the attribute;
     *
     * @param x
     * @param y
     * @param country
     * @param international
     * @param postCodes
     */
    public SortingOffice(int x, int y, String country, boolean international, ArrayList<String> postCodes) {
        this.x = x;
        this.y = y;
        this.country = country;
        this.international = international;
        this.iD = nextID;
        nextID++;
        this.postCodes = postCodes;
        this.location = "X" + getX() + "Y" + getY() + "C" + getCountry();
    }
    /**
     * x getter method
     *
     * @return x
     */
    public int getX() {
        return x;
    }
    /**
     * y getter method
     *
     * @return y
     */
    public int getY() {
        return y;
    }
    /**
     * country getter method
     *
     * @return country
     */
    public String getCountry() {
        return country;
    }
    /**
     * international getters method
     *
     * @return international
     */
    public boolean isInternational() {
        return international;
    }
    /**
     * location getter method
     *
     * @return location
     */
    public String getLocation() {
        return location;
    }
    /**
     * postCode getter method
     *
     * @return post.toString
     */
    public String getPostCodes() {
        StringBuilder post = new StringBuilder();
        for (String Postcode : postCodes) {
            post.append(Postcode).toString();
        }
        return post.toString();
    }
    /**
     * iD getter method
     *
     * @return iD
     */
    public int getiD() {
        return iD;
    }
    /**
     * Connections ArrayList getter method
     *
     * @return connections
     */
    public ArrayList<SortingOffice> getConnections() {
        return connections;
    }
    /**
     * void method addConnections
     *
     * @param sortingOffice adds sortingOffice to the arrayList "connections".
     */
    public void addConnection(SortingOffice sortingOffice) {
        connections.add(sortingOffice);
    }
    /**
     * toString method
     *
     * @return location + international + postCodes
     */
    @Override
    public String toString() {
        return getLocation() + isInternational() + getPostCodes();
    }
}
