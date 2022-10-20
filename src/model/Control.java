package model;

import java.util.ArrayList;

import Read.ToJsonReader;
import Read.ToJsonWriter;

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
        int priority = asignPriority(user);
        if(lab == 1){
            
            hematology.insert(user,priority );
            cz.push(user, lab, false);
        }else{
            general.insert(user, priority);
            cz.push(user, lab, false);
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
            cz.push(user,lab, true);
        }else{
            lab = 2;
            User user = general.extract();
            cz.push(user,lab, true);
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
    
    public void hashMapToTxt() {
    	
    	ArrayList<User> users = new ArrayList<>();
    	
    	for(int i = 0; i < hashMap.getLength() ; i++){
    		
    		if(hashMap.isEmpty(i) == false) {
    			users.add(hashMap.getValue(i));
    		}
    		
    	}
    	
    	String x = "";
    	
    	for(int i = 0; i < users.size(); i++) {
    		x += users.get(i);
    	}
    	
    	ToJsonWriter.write(users);
    	
    	System.out.println(x.toString());
    }
    
    public void loadTxt() {
    	
    	for(int i = 0; i < ToJsonReader.read().size(); i++) {
    	
    		hashMap.insert(ToJsonReader.read().get(i).getId(), ToJsonReader.read().get(i));  
    	
    	}
    	
    	
    }
    
   

}

    


    





    


