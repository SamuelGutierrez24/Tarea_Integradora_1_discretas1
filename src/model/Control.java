package model;


public class Control<T extends Comparable<T> , K> {
    
    private PriorityQueue<T> hematology;
    private PriorityQueue<T> general;
    private HashTable<T,String> hashMap;
    public Control(){
        hematology = new PriorityQueue<>(); 
        general = new PriorityQueue<>();
        hashMap = new HashTable<>();

    
    }

    public void searchClient(String id){
        System.out.println("hola");
    }

    public void registerClient(String name, int age, String id, int gender1, boolean pregnancy, boolean illness,  int key){
        Gender gender;
        if(gender1 ==1){
        gender = Gender.MALE;

      }else {
            gender = Gender.FEMALE;

      }
        User user = new User( name, age,  id,  gender, pregnancy,  illness, key);



    }

}
