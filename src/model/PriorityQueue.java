package model;

import java.util.concurrent.ExecutionException;

public class PriorityQueue <T>  implements IPriorityQueue<T> {
    
    private Iheap<T> heap;

    public PriorityQueue(){
        heap = new Heap<T>();
    }
    
    public PriorityQueue(Node<T> [] array, int length){
        heap = new Heap<>(array, length);
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
    public T extract() throws Exception {
        return heap.extract();
    }

    @Override
    public void increase(int obj, int k) {
        // TODO Auto-generated method stub
        
    }
    public void extractByUndo(T user)throws Exception{
        heap.extractByUndo( user);
    }
    
    public int getHeapsize(){
        return heap.getHeapsize();
    }
    public Node<T> [] clone(){
        return heap.clone();
    }

}
