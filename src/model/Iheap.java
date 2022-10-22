package model;
public interface Iheap<T> {
    
    public void maxHepify(int i);
    public void buildMaxHeap();
    public int parent(int i);
    public int leftS(int i);
    public int rightS(int i);
    public void increaseKey(int i, int key);
    public void insertU(T t,int key)throws Exception;
    public T getRoot()throws Exception;
    public T extract()throws Exception;
    public void extractByUndo(T user) throws Exception;
    public int getHeapsize();
    public Node<T> [] clone();
    
    
}
