package model;

public interface IPriorityQueue<T> {
       
    public void insert(T obj, int key) throws Exception;

    public T maximu()throws Exception;

    public T extract() throws Exception;

    public void increase(int obj,int k);
}
