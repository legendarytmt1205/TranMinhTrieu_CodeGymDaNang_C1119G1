package CollectionsInJava.BaiTap.ArrayList;

import java.util.Arrays;


public class MyList<E> {
    private int size = 0;

    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity: " + capacity) ;
        }
    }

    //change size when add object(if size = length)
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E remove(int index) {
        return null;
    }

    private int size() {
        return this.size;
    }

    public boolean contains(E e) {
        for (int i = 0; i<elements.length; i++) {
            if (e == elements[i]) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E e) {
        int index = 0;
        for (int i = 0; i<elements.length; i++) {
            if (e == elements[i]) {
               index = i;
            }
        }
        return index;
    }

    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
        return true;
    }
}
