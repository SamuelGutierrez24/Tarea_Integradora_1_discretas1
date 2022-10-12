package model;

public class Snode<T> {
    private T obj; 
    private Snode<T> next;

    public Snode(T obj){
        this.obj = obj;
        this.next = null;
    }

    public T getObj() {
        return obj;
    }

    public void setNext(Snode<T> next) {
        this.next = next;
    }
    public Snode<T> getNext() {
        return next;
    }
    
}
