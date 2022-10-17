package model;

public class User {
    private String name; 
    private int age;
    private int key;
    private String id;
    private Gender geneder;
    private boolean pregnancy;
    private boolean illness;
    


    public User(String name, int age, String id, Gender geneder, boolean pregnancy, boolean illness, int key) {
        this.name = name;
        this.age = age;
        this.key = key;
        this.id = id;
        this.geneder = geneder;
        this.pregnancy = pregnancy;
        this.illness = illness;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public String getName() {
        return name;
    }
    public void setIllness ( boolean illness) {
        this.illness = illness;
    }
    public boolean getIllness()
    { return illness;
    }

    public void setPregnancy ( boolean pregnancy) {this.pregnancy = pregnancy;}
    
    public boolean getPregnancy() {
    		return pregnancy;
    }
}
