package model;

public class Node <T> implements Comparable<Node <T>>  {
    
    private int key;
    private T value;


    public Node(int key, T value){
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public T getValue() {
        return value;
    }

    @Override
    public int compareTo(Node <T>  o) {
        
        if(key < o.getKey()){
            return -1;
        }
        else if(key>o.getKey()){
            return 1;
        }else{
            return 0;
        }
        
    }
}
