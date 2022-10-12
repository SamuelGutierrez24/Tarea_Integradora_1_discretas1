package model;


public class Control<T extends Comparable<T>> {
    
    private PriorityQueue<T> hematology;
    private PriorityQueue<T> general;
    public Control(){
        hematology = new PriorityQueue<T>(); 
        general = new PriorityQueue<>();
    
    }

    public void searchClient(String id){
        
    }

}
