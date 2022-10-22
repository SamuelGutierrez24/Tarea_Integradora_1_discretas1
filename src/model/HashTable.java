package model;

import java.util.ArrayList;

public class HashTable <T, K> implements IhashTable<T, K> {
    
    private HashNode<T,K> [] hashB;

    public HashTable(){
        hashB = (HashNode<T , K>[]) new HashNode[83];
    }

    @Override
    public void insert(K key, T value) {
        int position = hash(key);
        int firstHash = -1;
        int i = 1;
        System.out.println(position);
        
        while(hashB[position] != null && position != firstHash ){
            
            firstHash = hash(key);
            position = hash(i,key);
            i++;
        }
        System.out.println(position);

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
        double value = 0;
        int upgrade = 0;
        for(int i = toKey.length()-1;i>=0;i--){

            
            value += toKey.charAt(i)*Math.pow(128, upgrade);

            upgrade++;
        }
        
        double m = 83; //Math.pow(2, 3);
        double a = (Math.sqrt(5)-1)/2;
        int position = (int) ((int) m*((value*a)%1));
    
        return position;
    }

    @Override
    public int hash(int i, K key) {
        String toKey = key.toString();
        double value = 0;
        int upgrade = 0;
        for(int l = toKey.length()-1;l>=0;l--){

            
            value += toKey.charAt(l)*Math.pow(128, upgrade);

            upgrade++;
        }
        
        double m = 83; //Math.pow(2, 3);
        double a = (Math.sqrt(5)-1)/2;
        int position = (int) ((int) m*(value*a%1));
        position = (int) ((int) (position + 7*i  + (5*Math.pow(i,2)))%m);

        return position;
    }

    @Override
    public T search(K key) {
        
        int position = hash(key);
        int firstHash = -1;
        int i = 1;
        boolean flag = false;
        
        if(hashB[position] != null){

            while(i<83 ){
                
                if(hashB[position] != null){
                    
                    if(hashB[position].getKey().equals(key)){
                        flag = true;
                        return hashB[position].getValue();
                    }else{
                        HashNode<T,K> node = hashB[position];
                        
                        while(node.getNext()!= null){
                            
                            if(node.getNext().getKey().equals(key)){
                                return node.getNext().getValue();
                            }else{
                                node = node.getNext();
                            }
                        }
                        position = hash(i,key);
                        i++;

                    }

                }else{
                    position = hash(i,key);
                    i++;
                }
            }
                return null;
        }else{
            return null;
        }
         
    }
    
    public int getLength(){
    	
    	return hashB.length;
    	
    }
    
    public T getValue(int i) {
    	
    	return hashB[i].getValue();	
    	
    }
    
    public boolean isEmpty(int i) {
    	
    	boolean x = false;
    	
    	if(hashB[i] == null) {
    		x = true;
    	}
    	
    	return x;
    }
    
   
        
}
    
    


