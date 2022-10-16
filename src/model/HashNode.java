package model;

public class HashNode<T, K> {
       
    private K key;
    private T value;
    private HashNode<T,K> next;

    public HashNode(K key, T value){
        this.key = key;
        this.value = value;

    }

    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public T getValue() {
        return value;
    }
    public void setNext(HashNode<T, K> next) {
        this.next = next;
    }
    public HashNode<T, K> getNext() {
        return next;
    }

}
