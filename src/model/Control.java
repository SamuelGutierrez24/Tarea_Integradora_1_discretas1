package model;

import java.util.ArrayList;

import Read.ToJsonReader;
import Read.ToJsonWriter;

public class Control {
    
    private PriorityQueue<User> hematology;
    private PriorityQueue<User> general;
    private HashTable<User,String > hashMap;
    private Stack<User> czGeneral;
    private Stack<User> czHematology;
    public Control(){
    	
        hematology = new PriorityQueue<>(); 
        general = new PriorityQueue<>();
        hashMap = new HashTable<>();
        czGeneral = new Stack<>();
        czHematology = new Stack<>();
           
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

    public String searchClient(String id){

        //Comprobamos que 
        User user= hashMap.search(id);
        
        if(user != null){
            return user.toString();
        }else{
            return "He is not registered.\n";
        }
    }

    public void putInPriorityQ(int lab, String id) throws Exception{
        
        //Extraemos el usuario de la base de datos
        User user = hashMap.search(id);
        int priority = asignPriority(user);
        user.setKey(priority);
        if(lab == 1){
            hematology.insert(user,priority );
            czHematology.push(user, lab, false);
        }else{
            general.insert(user, priority);
            czGeneral.push(user, lab, false);
        }
    }

   
    public void registerClient(String name, int age, String id, int gender1, boolean pregnancy, boolean illness,  int key){
    	Gender gender = null;

        switch(gender1){
            case 1:
                gender = Gender.FEMALE;
            break;
            case 2 :
                gender = Gender.MALE;
            break;
        }
      
        User user = new User( name, age,  id,  gender, pregnancy,  illness, key);
        //Insertamos el usuario en la base de datos
        hashMap.insert(id,user);
    }

    

    public String outOfTheQueue(int lab) throws Exception{

        if(lab == 1){
            User user = hematology.extract();
            czHematology.push(user,lab, true);
        }else{
            lab = 2;
            User user = general.extract();
            czGeneral.push(user,lab, true);
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
                //System.out.println(hashMap.getValue(i) + " - " + hashMap.getValue(i).getId() + " - " + hashMap.getValue(i).getGender());
                
                if(hashMap.getNext(i) != null){
        			
        			HashNode<User, String> node = hashMap.getNext(i);
        			users.add(node.getValue());

        			while (node.getNext() != null){
        				users.add(node.getValue());
        			}
                }

    		} 
    		
    	}
    	
    	String x = "";
    	
    	for(int j = 0; j < users.size(); j++) {
    		x += users.get(j);
    	}
    	
    	ToJsonWriter.write(users);
    	
    	//System.out.println(x.toString());
    }
    
    public void loadTxt() {
    	
    	if(ToJsonReader.read() != null) {
    	
    		for(int i = 0; i < ToJsonReader.read().size(); i++) {
    	
    			hashMap.insert(ToJsonReader.read().get(i).getId(), ToJsonReader.read().get(i));  
    	
    		}
    	} else {
    		System.out.println("No hay nada en la base de datos.");
    	}
    	
    }
    



    public String undo(int lab) throws Exception{
        boolean isEgress;
        String out = "Done.";

        if(lab == 1){
            
            if(czHematology.isEmpty()==false){

                isEgress = czHematology.topIsEgress();
                User user = czHematology.pop();

                if(isEgress == true){
                    hematology.insert(user, 20);
                }else{
                    
                    hematology.extractByUndo(user);
                }
            }else{
                out = "The stack is empty";
            }    

        }else{

            if(czGeneral.isEmpty() == false){
                isEgress = czGeneral.topIsEgress();
                User user = czGeneral.pop();
                if(isEgress == true){
                    general.insert(user, 20);
                }else{

                    general.extractByUndo(user);
                }
            }else{
                out = "The stack is empty";
            }    

        }
        return out;
    }

    public String showPriorityQ(int lab) throws Exception{
    	
    	String out = "";

        if(lab == 1){
            int length= hematology.getHeapsize();
          PriorityQueue<User> forPrint = new PriorityQueue<>(hematology.clone(), length) ;
          int i = 1;
          while(forPrint.getHeapsize()>0){
            out += "["+ i +"] " + forPrint.extract().toString() + "\n";
          }

        }else{
            int length = general.getHeapsize();
            PriorityQueue<User> forPrint = new PriorityQueue<>(general.clone(), length) ;
            int j = 1;
          while(forPrint.getHeapsize()>0){
            out += "[" + j +"] " + forPrint.extract().toString() + "\n";
          }
        }

        return out;
    }

     public User[] sortIntegerArrayInsertion(User [] array) {
    
        
        for (int rojo = 1; rojo < array.length; rojo++) {
            int valorRojo = array[rojo].getKey(); //guardar prioridad
            User userRojo = array[rojo];
            int verde = rojo-1; //indice
            int valorVerde = array[verde].getKey(); //guardar prioridad
            while ( verde > -1 && (valorVerde = array[verde].getKey()) > valorRojo ) {
                valorVerde = array[verde].getKey();
                array[verde+1] = array[verde];
                verde--;
            }
            //if(array[verde].getKey() == array[rojo].getKey()) {
            //	System.out.println("Prueba");
            //}
            array[verde+1] = userRojo;
        }
       
        return array;

    }

}
       



    


    





    


