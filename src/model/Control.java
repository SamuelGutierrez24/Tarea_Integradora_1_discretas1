package model;


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

    public String showPriorityQ(int lab){
        String out = "";

        if(lab == 1){


             User [] forPrint = hematology.clone();
            forPrint = sortIntegerArrayInsertion(forPrint);
            for(int i = forPrint.length-1;i>=0;i--){
                out += "----" +  forPrint[i].toString();
            }


        }else{

            User [] forPrint = general.clone();
            forPrint = sortIntegerArrayInsertion(forPrint);
            for(int i = forPrint.length-1;i>=0;i--){
                out += "----" +  forPrint[i].toString();
            }


        }
        return out;
    }

    public User[] sortIntegerArrayInsertion(User [] array) {
    
        
        for (int rojo = 1; rojo < array.length; rojo++) {
            int valorRojo = array[rojo].getKey(); //guardar prioridad
            int verde = rojo-1; //indice
            int valorVerde = array[verde].getKey(); //guardar prioridad
            while ( verde > -1 && (valorVerde = array[verde].getKey()) > valorRojo ) {
                valorVerde = array[verde].getKey();
                array[verde+1] = array[verde];
                verde--;
            }
            array[verde+1] = array[rojo];
        }
       
        return array;
       
    }

}
       



    


    





    


