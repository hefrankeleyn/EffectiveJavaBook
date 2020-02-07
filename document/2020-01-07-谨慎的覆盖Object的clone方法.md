# 谨慎的覆盖Object的clone方法

[toc]

## 前言

前一段时间读了《重构·改善既有代码的设计》这本书，引起了我对程序中的一个细节的注意：

> 将一个可变对象作为参数传递到一个方法，在该方法的内部应当先对该可变对象进行拷贝，然后使用该对象的副本进行操作，避免由于改变原来对象而引发莫名其妙的错误。

后来为了拷贝的方便，我就开始覆盖了Object 的clone方法，用于对象的拷贝。

## 恰当的覆盖`clone()`的姿态

近日在读《Effectiv Java》这本书，读到第十三小节(谨慎的覆盖clone方法)，真是佩服这本书的作者。至此才见识到覆盖`clone()`方法的正确步骤。

### 第一步：实现Cloneable接口

> 通常情况下，实现接口是为了表明类可以为它的客户做些什么。然而，对于Cloneable接口，它改变了超类中受保护方法的行为。

一个类如果实现了Cloneable，Object的clone方法就返回该对象的逐项拷贝，否则就会抛出`CloneNotSupportedException`异常。

### 第二步： 覆盖`clone`方法

覆盖`clone()`方法，并且是共有的方法（即，用public修饰），它的返回类型为类本身。

### 第三步：修改任何需要修改的域

如果每个域包含一个基本类型的值，或者包含一个指向不可变对象的引用，那么被返回的对象则可能正是你所需要的对象。

- 元素类型为基本类型或不可变类型的数组，使用逐项拷贝：`String[] elements=...; elements.clone();`
- 对于可变的对象、数组、集合，使用深度拷贝；

**注意：数组最好使用clone方法复制数组。**


### 示例

```java
package com.hef.chapter3.item13;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @Date 2020/1/7
 * @Author lifei
 */
public class Stack implements Cloneable{
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 3;

    public Stack(){
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY]; // eliminate obsolete reference
    }
    
    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public int size(){
        return size;
    }

    public Object pop(){
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; //
        return result;
    }

    public void ensureCapacity(){
        if (elements.length == size){
            elements = Arrays.copyOf(elements, 2*size + 1);
        }
    }

    @Override
    public Stack clone()  {
        try {
            Stack result =  (Stack) super.clone();
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}

```



## 代替拷贝对象的其他途径：拷贝构造器、拷贝工厂

### 拷贝构造器

`public Yum(Yum yum){...}`

### 拷贝工厂

`public static Yum newInstance(Yum yum){...}`

### 基于接口的拷贝构造器和拷贝工厂

允许客户选择拷贝的实现类型，而不是强迫客户接受原始的实现类型，例如将HashSet拷贝成TreeSet

`public ArrayList(Collection<? extends E> c) {...}`

