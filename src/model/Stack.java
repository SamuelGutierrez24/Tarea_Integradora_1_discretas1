package model;

public class Stack <T> implements Istack<T>{

    private Snode<T> first;

    @Override
    public boolean isEmpty() {
        if(first == null){
            return true;
        }else
        return false;
    }

    @Override
    public T top() {
        
        return first.getObj();
    }

    @Override
    public void push(T obj, int lab, boolean isEgress) {

        Snode<T> node = new Snode<T>(obj, lab, isEgress);
        node.setNext(first);
        first = node;
        
    }

    @Override
    public T pop() {
        
        Snode<T> node = first;
        first = first.getNext();
        return node.getObj();

    }
    




}

