package model;

public interface IhashTable <T, K> {
    public void insert(K key, T value);
    public int hash(K key);
    public int hash(int i, K key);
    public T search(K key);
}
