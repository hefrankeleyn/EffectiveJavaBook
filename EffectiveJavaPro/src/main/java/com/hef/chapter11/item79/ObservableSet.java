package com.hef.chapter11.item79;

import java.util.*;

/**
 * @Date 2020/2/17
 * @Author lifei
 */
public class ObservableSet<E> extends ForwardingSet<E> {
    public ObservableSet(Set<E> s) {
        super(s);
    }

    private final List<SetObserver<E>> observers = new ArrayList<>();

    public void addObserver(SetObserver<E> observer){
        synchronized (observers){
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer){
        synchronized (observers){
            return observers.remove(observer);
        }
    }

/*    private void notifyElementAdded(E element){
        synchronized (observers){
            for (SetObserver<E> observer : observers) {
                observer.added(this, element);
            }
        }
    }*/

    // 将外来的方法移出同步代码块
    private void notifyElementAdded(E element){
        List<SetObserver<E>> snapshot = null;
        synchronized (observers){
            snapshot = new ArrayList<>(observers);
        }
        for (SetObserver<E> observer : snapshot) {
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

    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver((s, e)-> System.out.println(e));

        for (int i=0; i<100; i++){
            set.add(i);
        }
    }
}
