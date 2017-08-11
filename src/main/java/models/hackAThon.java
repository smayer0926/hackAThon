package models;


import java.util.ArrayList;

public class hackAThon {


    private String name;
    private int id;


    private static ArrayList<hackAThon> allEvents = new ArrayList<hackAThon>();

    public hackAThon(String name) {
        this.name = name;
        allEvents.add(this);
        this.id = allEvents.size();
    }
    public static void clearAllEvents(){
        allEvents.clear();
    }

    public static hackAThon findById(int id){
        return allEvents.get(id-1);
    }


    //Getters
    public String getName() {
        return name;
    }
    public static ArrayList<hackAThon> getAllEvents() {
        return allEvents;
    }
    public int getId() {
        return id;
    }



}
