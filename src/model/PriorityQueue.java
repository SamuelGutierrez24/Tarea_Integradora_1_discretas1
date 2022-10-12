package model;

import java.util.concurrent.ExecutionException;

public class PriorityQueue <T extends Comparable<T>> implements IPriorityQueue<T> {
    
    private Iheap<T> heap;

    public PriorityQueue(){
        heap = new Heap<T>();
    }

    @Override
    public void insert(T obj,int key)throws Exception {
        heap.insertU(obj,key);
        
    }

    @Override
    public T maximu()throws Exception {
        return heap.getRoot();
        
    }

    @Override
    public T extract() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void increase(int obj, int k) {
        // TODO Auto-generated method stub
        
    }
}
