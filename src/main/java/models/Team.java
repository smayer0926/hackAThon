package models;

import java.util.ArrayList;

public class Team {
    private String nameOfTeam;
    private static ArrayList<Team> allTeams = new ArrayList<Team>();
    private int teamId;
    private ArrayList<Member> teamMembers;

    public Team(String nameOfTeam) {
        this.nameOfTeam = nameOfTeam;
        allTeams.add(this);
        teamId = allTeams.size();
        teamMembers = new ArrayList<Member>();
    }
    public static void clearAllTeams() {
        allTeams.clear();
    }
    public static Team findById(int id){
        return allTeams.get(id-1);
    }
    public void addMember(Member member){
        teamMembers.add(member);
    }
    public void update(String nameOfTeam) {
        this.nameOfTeam = nameOfTeam;
    }


    //Getters
    public String getNameOfTeam() {
        return nameOfTeam;
    }

    public static ArrayList<Team> getAllTeams() {
        return allTeams;
    }

    public int getTeamId() {
        return teamId;
    }

    public ArrayList<Member> getTeamMembers() {
        return teamMembers;
    }
}

