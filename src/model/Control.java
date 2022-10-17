package model;


public class Control {
    
    private PriorityQueue<User> hematology;
    private PriorityQueue<User> general;
    private HashTable<User,String > hashMap;
    private Stack<User> cz;
    public Control(){
        hematology = new PriorityQueue<>(); 
        general = new PriorityQueue<>();
        hashMap = new HashTable<>();
        cz = new Stack<>();

    
    }

    public boolean searchClientBool(String id){

        //Comprobamos que 
        User user= hashMap.search(id);
        
        if(user != null){
            return true;
        }else{
            return false;
        }
    }

    public void putInPriorityQ(int lab, String id) throws Exception{
        
        //Extraemos el usuario de la base de datos
        User user = hashMap.search(id);
        if(lab == 1){
            int priority = asignPriority(user);
            hematology.insert(user,priority );
        }else{
            general.insert(user, lab);
        }
    }

   
    public void registerClient(String name, int age, String id, int gender1, boolean pregnancy, boolean illness,  int key){
        Gender gender;
        if(gender1 ==1){
        gender = Gender.MALE;

      }else{
            gender = Gender.FEMALE;

      }
        User user = new User( name, age,  id,  gender, pregnancy,  illness, key);
        //Insertamos el usuario en la base de datos
        hashMap.insert(id,user);
    }

    

    public String outOfTheQueue(int lab) throws Exception{

        if(lab == 1){
            User user = hematology.extract();
            cz.push(user,lab);
        }else{
            lab = 2;
            User user = general.extract();
            cz.push(user,lab);
        }        
        return "Done.";
    }
    
    public int asignPriority(User user) {
        
        int priority=0; 
        if (user.getAge()>=65){

             priority=1;

        }else if(user.getPregnancy()==true){
            
            priority=1;
        
        } else if(user.getIllness()==true){

            priority=1;
                 
        }
        return priority;
    }

       

}

    


    





    


