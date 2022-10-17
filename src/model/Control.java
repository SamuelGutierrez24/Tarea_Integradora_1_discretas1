package model;

public class Control<T extends Comparable<T>> {
    
    private PriorityQueue<T> hematology;
    private PriorityQueue<T> general;
    public Control(){
        hematology = new PriorityQueue<T>(); 
        general = new PriorityQueue<T>();
        
    
    }

    
    
  
    public void asignPriorityGeneral(User user) throws Exception{
    	int priority=0; 
    	 if (user.getAge()>=65){

             priority=1;
             general.insert(null, priority);

    	 }else if(user.getPregnancy()==true){
             priority=1;
             general.insert(null, priority);
             } else if(user.getIllness()==true){
                 priority=1;
                 general.insert(null, priority);
                 }else {
                	 
                	 priority=0;
                	 general.insert(null, priority);
                	 
                 }
    }
    	 
    	 public void asignPriorityhematology(User user) throws Exception{
    	    	int priority=0;
    	    	 if (user.getAge()>=65){

    	             priority=1;
    	             hematology.insert(null, priority);

    	    	 }else if(user.getPregnancy()==true){
    	             priority=1;
    	             hematology.insert(null, priority);
    	             } else if(user.getIllness()==true){
    	                 priority=1;
    	                 hematology.insert(null, priority);
    	                 }else {
    	                	 
    	                	 priority=0;
    	                	 hematology.insert(null, priority);
    	                	 
    	                 }
    	 
    	 
    }
    	 
}

    


    





    


