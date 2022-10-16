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
        return true;

    }

    public T searchClient(String id ){
        return hashMap.search(id);
    }

    public void putInPriorityQ(int lab, String id){


        T user = searchClient(id);


    }

}
