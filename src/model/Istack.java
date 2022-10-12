package model;

public interface Istack <T> {
    
    public boolean isEmpty();

    public T top();

    public void push(T obj);

    public T pop();

}
