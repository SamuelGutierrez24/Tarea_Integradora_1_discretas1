package model;

public interface IPriorityQueue<T> {
       
    public void insert(T obj, int key) throws Exception;

    public T maximu()throws Exception;

    public T extract();

    public void increase(int obj,int k);
}
