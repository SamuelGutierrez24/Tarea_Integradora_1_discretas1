package model;

public class Snode<T> {
    private T obj; 
    private int lab;
    private boolean isEgress;
    private Snode<T> next;

    public Snode(T obj, int lab,boolean isEgress){
        this.obj = obj;
        this.next = null;
        this.lab = lab;
        this.isEgress = isEgress;
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
    public int getLab() {
        return lab;
    }
    public void setLab(int lab) {
        this.lab = lab;
    }
    public void setEgress(boolean isEgress) {
        this.isEgress = isEgress;
    }
    public boolean getEgress(){
        return this.isEgress;
    }
    
    
}
