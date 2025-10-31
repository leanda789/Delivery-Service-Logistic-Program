package com.example.courseworktwop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
/**
 * Class to hold data that is added to the "database".
 * You may add methods to this class.
 */
public class Data {
    /**
     * Attributes to save our data to the "database"
     */
    private static final ArrayList<SortingOffice> sortingOffices = new ArrayList<>();
    private static final Stack<Deliverable> deliverables = new Stack<>();
    private static final Stack<Deliverable> processedDeliverables = new Stack<>();
    /**
     * read Sorting Offices method
     * reads in the text file "sortingOffices.txt".
     */
    public static void readSortingOffices() {
        try {
            File inputFile = new File("sortingOffices.txt");
            Scanner in = new Scanner(inputFile);
            while (in.hasNextLine()) {
                int x = in.nextInt();
                int y = in.nextInt();
                String country = in.next();
                boolean international = in.nextBoolean();
                ArrayList<String> postCodes = new ArrayList<>();
                String[] postcodesInput = in.next().split(",");
                Collections.addAll(postCodes, postcodesInput);
                SortingOffice sort = new SortingOffice(x, y, country, international, postCodes);
                sortingOffices.add(sort);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }
    /**
     * read Deliverables method
     * reads in the csv file "deliverables.csv".
     */
    public static void readDeliverables() {
        try {
            Scanner scanner = new Scanner(new File("deliverables.csv"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] row = line.split(",");
                SortingOffice sender = findSortingOffice(row[0]);
                SortingOffice recipient = findSortingOffice(row[1]);
                String itemType = row[2];
                if (itemType.equals("Plant")) {
                    Deliverable plant = new Plant(sender, recipient);
                    deliverables.push(plant);
                } else if (itemType.equals("Produce")) {
                    Deliverable produce = new Produce(sender, recipient);
                    deliverables.push(produce);
                } else {
                    double weight = Double.parseDouble(row[3]);
                    boolean fragile = Boolean.parseBoolean(row[4]);
                    Deliverable nonPerishable = new NonPerishable(sender, recipient, weight, fragile);
                    deliverables.push(nonPerishable);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * addConnections method.
     * determines connections between:
     * international & non-international sorting offices.
     */
    public static void addConnections() {
        for (SortingOffice sortingOffice : sortingOffices) {
            if (sortingOffice.isInternational()) {
                for (SortingOffice sortingOffice2 : sortingOffices) {
                    if ((sortingOffice2.isInternational()) && (!sortingOffice.equals(sortingOffice2))) {
                        sortingOffice.addConnection(sortingOffice2);
                    } else if (sortingOffice.getCountry().equals(sortingOffice2.getCountry())
                            && !sortingOffice.equals(sortingOffice2)) {
                        sortingOffice.addConnection(sortingOffice2);
                    }
                }
            } else {
                for (SortingOffice sortingOffice2 : sortingOffices) {
                    if (sortingOffice.getCountry().equals(sortingOffice2.getCountry())
                            && sortingOffice2.isInternational()) {
                        sortingOffice.addConnection(sortingOffice2);
                    }
                }
            }
        }
    }
    /**
     * Method to return the Stack of deliverables
     *
     * @return stack of deliverables
     */
    public static Stack<Deliverable> getDeliverables() {
        return deliverables;
    }
    /**
     * Method to return the sorting offices
     *
     * @return array list of sorting offices
     */
    public static ArrayList<SortingOffice> getSortingOffices() {
        return sortingOffices;
    }
    /**
     * Method to return the completed deliverables.
     *
     * @return stack of completed deliverables.
     */
    public static Stack<Deliverable> getProcessedDeliverables() {
        return processedDeliverables;
    }
    public static SortingOffice findSortingOffice(String postCode) {
        for (SortingOffice sortingOffice : sortingOffices) {
            if (sortingOffice.getPostCodes().contains(postCode)) {
                return sortingOffice;
            }
        }
        return null;
    }
    /**
     * findSortingOffice method.
     *
     * @param id determines if sorting Office equals the id.
     * @return sortingOffice
     * or
     * @return null
     */
    public static SortingOffice findSortingOffice(int id) {
        for (SortingOffice sortingOffice : sortingOffices) {
            if (sortingOffice.getiD() == id) {
                return sortingOffice;
            }
        }
        return null;
    }
    /**
     * printReceipts method.
     * Writes the file "receipts.txt".
     * prints recipient's receipt.
     */
    public static void printReceipts() {
        try {
            FileWriter receipt = new FileWriter("receipts.txt");
            for (int i = processedDeliverables.size() - 1; i >= 0; i--) {
                receipt.write(processedDeliverables.get(i).getReceipt() + "\n");
            }
            receipt.close();
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
/**
 * DO NOT EDIT ANY CODE ABOVE THIS COMMENT. You may need to write additional methods below.
 **/
