package com.hef.chapter11.item79;

/**
 * @Date 2020/2/17
 * @Author lifei
 */
public interface SetObserver<E> {

    // Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}
