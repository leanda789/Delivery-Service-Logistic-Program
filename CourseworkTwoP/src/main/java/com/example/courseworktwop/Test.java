package com.example.courseworktwop;
import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {

        ArrayList<String> postCodes = new ArrayList<>();
        postCodes.add("AD");

        /**
         * Stage 1
         */
        SortingOffice sort = new SortingOffice(100, 100, "England", true, postCodes);
        System.out.println("Postcode: " +postCodes);
        System.out.println("Location: " +sort.getLocation());
        System.out.println("SortingOffice: " +sort);

        /**
         * Stage 2
         */
        NonPerishable non = new NonPerishable(new SortingOffice(100, 23, "England", true, postCodes), new SortingOffice(34, 30, "France", true, postCodes), 20.5, true);
        System.out.println("Sender: " + non.getSender());

        /**
         * Stage 3
         */
        Perishable per = new Perishable(new SortingOffice(23, 24, "Wales", false, postCodes), new SortingOffice(24, 26, "Wales", false, postCodes));
        System.out.println("Sender: " + per.getSender());
        System.out.println("Recipient: " + per.getRecipient());


    }
}
