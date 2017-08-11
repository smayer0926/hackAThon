package models;


import java.util.ArrayList;

public class hackAThon {


    private String name;


    private static ArrayList<hackAThon> allEvents = new ArrayList<hackAThon>();

    public hackAThon(String name) {
        this.name = name;
        allEvents.add(this);
    }

//Getters
    public String getName() {
        return name;
    }
    public static ArrayList<hackAThon> getAllEvents() {
        return allEvents;
    }

}
