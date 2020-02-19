package com.hef.chapter11.item79;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Date 2020/2/18
 * @Author lifei
 */
public class ConcurrentObservableSet<E> extends ForwardingSet<E>{
    public ConcurrentObservableSet(Set<E> s) {
        super(s);
    }
    private final Set<ConcurrentSetObserver<E>> observers = new CopyOnWriteArraySet<>();
    public void addObserver(ConcurrentSetObserver<E> observer){
        observers.add(observer);
    }

    public boolean removeObserver(ConcurrentSetObserver<E> observer){
        return observers.remove(observer);
    }

    private void notifyElementAdded(E element){
        for (ConcurrentSetObserver<E> observer : observers) {
            observer.added(this, element);
        }
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added)
            notifyElementAdded(element);
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element: c){
            // Calls notifyElementAdded
            result |= add(element);
        }
        return result;
    }
}
