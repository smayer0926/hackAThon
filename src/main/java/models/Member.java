package models;


import java.util.ArrayList;

public class Member {
    private String participantName;



    private int particpantId;
    private static ArrayList<Member> allMembers = new ArrayList<Member>();

    public Member(String name) {
        this.participantName = name;
        allMembers.add(this);
        this.particpantId = allMembers.size();
    }
    public static void clearAllEvents(){
        allMembers.clear();
    }

    public static Member findById(int particpantId){
        return allMembers.get(particpantId-1);
    }
    public void update(String name) {
        this.participantName = name;
    }


    //Getters
    public String getName() {
        return participantName;
    }
    public static ArrayList<Member> getAllEvents() {
        return allMembers;
    }
    public int getParticpantId() {
        return particpantId;
    }


}
