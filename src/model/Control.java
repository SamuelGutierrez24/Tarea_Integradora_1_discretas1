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

    public boolean searchClientBool(String id){
        T user = hashMap.search(id);
        if(user != null){
            return true;
        }else{
            return false;
        }
    }

    public void putInPriorityQ(int lab, String id) throws Exception{
        T user = hashMap.search(id);
        if(lab == 1){

            //int priory = 
            hematology.insert(user,lab );
        }else{
            general.insert(user, lab);
        }
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

    

    public String outOfTheQueue(int lab){

        


        return "Done.";
    }

}
