package model;

public class HashTable <T, K> implements IhashTable<T, K> {
    private HashNode<T,K> [] hashB;

    public HashTable(){
        hashB = (HashNode<T , K>[]) new HashNode[83];
    }

    @Override
    public void insert(K key, T value) {
        int position = hash(key);
        int firstHash = -1;
        int i = 0;

        while(hashB[position] != null || position != firstHash ){
            
            firstHash = hash(key);
            position = hash(i,key);
            i++;
        }

        HashNode<T,K> node = new HashNode<T,K>(key, value);
        if(firstHash == position){

            if(hashB[position]!=null){
                HashNode<T,K> node2 = hashB[position];
                node.setNext(node2);
                hashB[position] = node;
            }
        }else{
            hashB[position] = node;
        }
    }

    @Override
    public int hash(K key) {
        
        String toKey = key.toString();
        int value = -1;
        int upgrade = 0;
        for(int i = toKey.length()-1;i>=0;i--){

            
            value += toKey.charAt(i)*Math.pow(128, upgrade);

            upgrade++;
        }
        
        double m = 83; //Math.pow(2, 3);
        double a = (Math.sqrt(5)-1)/2;
        int position = (int) ((int) m*(value*a%1));
    
        return position;
    }

    @Override
    public int hash(int i, K key) {
        String toKey = key.toString();
        int value = -1;
        int upgrade = 0;
        for(int l = toKey.length()-1;l>=0;i--){

            
            value += toKey.charAt(l)*Math.pow(128, upgrade);

            upgrade++;
        }
        
        double m = Math.pow(2, 3);
        double a = (Math.sqrt(5)-1)/2;
        int position = (int) ((int) m*(value*a%1));
        position = (int) ((int) position + 1*i  + (2*Math.pow(i,2))%m);

        return position;
    }

    @Override
    public T search(K key) {
        
        int position = hash(key);
        int firstHash = -1;
        int i = 0;
        boolean flag = false;
        while(flag == false && i<8 ){
            
            firstHash = hash(key);

            if(hashB[position].getKey()== key){
                flag = true;
            }else if(firstHash == position && i>0){
                flag = true;
            }else{
                
                position = hash(i,key);
                i++;
            }

        }

        if(firstHash == position){
        
            if(hashB[position] != null){
                HashNode<T,K> node = hashB[position];
                while(node.getKey()!= key){
                    
                    if(node.getNext() != null){
                        node = node.getNext();
                    }else{
                        return null;
                    }
                    
                }
                return node.getValue();
            }else{
                return null;
            }

        }else{
            HashNode<T,K> node = hashB[position];
            return node.getValue();
        }
    
    }
    

    
    
   
        
}
    
    


