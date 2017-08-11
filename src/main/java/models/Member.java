package models;


import java.util.ArrayList;

public class Member {
    private String participantName;
    private int id;
    private static ArrayList<Member> allMembers = new ArrayList<Member>();
    private int age;
    private String description;

    public Member(String name, int age, String description) {
        this.participantName = name;
        this.age = age;
        this.description = description;
        allMembers.add(this);
        this.id = allMembers.size();
    }
    public static void clearAllEvents(){
        allMembers.clear();
    }

    public static Member findById(int particpantId){
        return allMembers.get(particpantId-1);
    }
    public void update(String name, int age, String description) {
        this.participantName = name;
        this.age = age;
        this.description = description;
    }


    //Getters
    public String getName() {
        return participantName;
    }
    public static ArrayList<Member> getAllMembers() {
        return allMembers;
    }
    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }
    public String getDescription() {
        return description;
    }


}
