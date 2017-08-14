package models;

import java.util.ArrayList;

public class Team {
    private String nameOfTeam;
    private String description;
    private static ArrayList<Team> allTeams = new ArrayList<Team>();
    private static ArrayList<String> allMembers;
    private int id;
    private static int increment;


    public Team(String nameOfTeam, String description) {
        this.nameOfTeam = nameOfTeam;
        this.description = description;
        allMembers = new ArrayList<String>();
        increment++;
        this.id = increment;
        allTeams.add(this);
    }
    public static Team findbyId(int id) {
        Team find= null;
        for (Team newTeam : allTeams){
            if(newTeam.getId() == id){
                find = newTeam;
            }
        }
        return find;
    }

    public static void clearAllTeams() {
        allTeams.clear();
    }


//Getters
    public String getNameOfTeam() {
        return nameOfTeam;
    }
    public String getDescription() {
        return description;
    }
    public static ArrayList<Team> getAllTeams() {
        return allTeams;
    }
    public static ArrayList<String> getAllMembers() {
        return allMembers;
    }
    public int getId() {
        return id;
    }
    public static int getIncrement() {
        return increment;
    }
    public void update(String name){
        this.nameOfTeam = nameOfTeam;
    }

//Setters
    public void setMembers(String members) {
        this.allMembers.add(members);
    }


}
