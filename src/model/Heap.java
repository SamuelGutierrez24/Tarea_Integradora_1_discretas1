package model;

public class Heap <T> implements Iheap <T>{

    private Node<T> [] heapA;
    private int heapSize = 0;
    
    public Heap(){
        heapA = (Node<T>[]) new Node[200];
    }
    
    public Heap(Node<T> [] array, int i){
        heapA = array;
        heapSize = i;
    }
    
    @Override
    public void maxHepify(int i) {
       
        ;
        int l = leftS(i);
        int r = rightS(i);
        int largest;

        if(l<=heapA.length && heapA[l]!= null && heapA[l].compareTo(heapA[i]) > 0){
             largest = l;
        }else{
            largest = i;
        }
        if(r<=heapA.length && heapA[r] != null && heapA[r].compareTo(heapA[largest])>0){
            largest = r;
        }
        if(largest != i){
            Node <T> user = heapA[i];
            heapA[i] = heapA[largest];
            heapA[largest] = user;
            maxHepify(largest);
        }
        
        
        
    }

    @Override
    public void buildMaxHeap() {
        int start = (heapSize-2)/2;
        for(int i = start;i>=0;i--){
            maxHepify(i);
        }
    }

    @Override
    public int parent(int i) {
        i += 1;
        int out = i/2;
        return out-1;
    }

    @Override
    public int leftS(int i) {
        i+=1;
        int out= 2*i;
        return out-1;  
    }

    @Override
    public int rightS(int i) {
        i+=1;
        int out = 2*i+1;
        return out-1;
    }
    @Override
    public void insertU(T user,int key) throws Exception{
        
        Node<T> node = new Node<T>(Integer.MIN_VALUE, user);
        if(heapSize != heapA.length){
            heapA [heapSize] = node;
            increaseKey(heapSize, key);
            heapSize = heapSize+1;
        }else{
            throw new Exception("The queue is full");
        }
        
    }

    @Override
    public void increaseKey(int i, int key) {
        if(key<heapA[i].getKey()){
            System.out.println("Error new key is smaller");
        }else{
            heapA[i].setKey(key);

            while(i>0 && heapA[parent(i)].getKey()<heapA[i].getKey()){
                Node<T> node = heapA[parent(i)];
                heapA[parent(i)] = heapA[i];
                heapA[i] = node;
                i = parent(i);
            }
        }
    }
    public void heapSort(){
        
        for(int i = heapSize;i>=2;i--){
            Node<T> node = heapA[0];
            heapA[0] = heapA[i];
            heapA[i] = node;
            heapSize = heapSize-1;
            maxHepify(0);
        }
    }
    @Override
    public T getRoot() throws Exception{
        
        if(heapA[0] == null){
            throw new Exception("The queue is empty");
        }else
        return heapA[0].getValue();
    }
    @Override
    public T extract() throws Exception{
        if(heapA[0] == null){
            throw new Exception("The queue is empty");
        }else{
            Node<T> node = heapA[0];
            heapA[0] = heapA[heapSize-1];
            heapA[heapSize-1] = null;
            heapSize = heapSize-1;
            maxHepify(0);
            return node.getValue();



            /*heapSize = heapSize-1;
            int j = 1;
            for(int i = 0; i<= heapSize-1 && j<= heapSize;i++){
                heapA[i] = heapA[j];
            }
            return node.getValue();*/
        }
    }

    public void buildMaxHeap2() {
        heapSize = heapSize-1;
        int start = (heapSize-2)/2;
        for(int i = start;i>=0;i--){
            maxHepify(i);
        }
    }
    @Override
    public void extractByUndo(T user)throws Exception{

        boolean flag = true;
        int position = 0;
        for(int i = 0;i<=heapSize-1 || !flag;i++){
            if(heapA[i].equals(user)){
                heapA[i]=null;
                flag = false;
                position = i;
            }
        }

        for(int i = position;i<=heapSize-2;i++){

            if(heapA[i+1] != null){
                heapA[i] = heapA[i+1];
            }
        }

        buildMaxHeap2();
        

    }
    @Override
    public int getHeapsize(){
        return heapSize;
    }
    @Override
    public Node<T> [] clone(){
        return heapA.clone();
    }


    


}