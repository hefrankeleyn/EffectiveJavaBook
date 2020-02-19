package com.hef.chapter11.item79;

/**
 * @Date 2020/2/18
 * @Author lifei
 */
public interface ConcurrentSetObserver<E> {

    // Invoked when an element is added to the observable set
    void added(ConcurrentObservableSet<E> set, E element);
}
