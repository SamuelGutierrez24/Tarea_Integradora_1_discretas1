package model;

public interface Iqueue<T> {
    
    public boolean isEmpty();

    public T front();

    public void queue(T obj);

    public void dequeue();
}
