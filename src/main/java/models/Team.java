package models;

import java.util.ArrayList;

public class Team {
    private String nameOfTeam;
    private String description;
    private static ArrayList<Team> allTeams = new ArrayList<Team>();
    private static ArrayList<String> members;
    private int id;
    private static int increment;
    private String email;


    public Team(String nameOfTeam, String description) {
        this.nameOfTeam = nameOfTeam;
        this.description = description;
        members = new ArrayList<String>();
        increment++;
        this.id = increment;
        allTeams.add(this);
    }
    public static Team findbyId(int id) {
       return allTeams.get(id-1);
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
    public static ArrayList<String> getMembers() {
        return members;
    }
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void update(String name){
        this.nameOfTeam = name;
    }

//Setters
    public void setMembers(String members, String email) {
        this.members.add(members);
        this.members.add(email);
    }


}
