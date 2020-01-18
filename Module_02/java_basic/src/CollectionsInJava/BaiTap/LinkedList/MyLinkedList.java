package CollectionsInJava.BaiTap.LinkedList;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {

    public Node head;
    public int size;

    public class Node {
        public Node next;
        public Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public MyLinkedList() {
        size = 0;
    }

    public MyLinkedList(Node head) {
        this.head = head;
        size = 0;
    }

    public MyLinkedList(Object headData) {
        head = new Node(headData);
        size = 0;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || size <= index)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || size < index)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    public void add(E data) {
        addFirst(data);
    }

    public void addFirst(E data) {
        Node e = new Node(data);
        e.next = head;
        head = e;
        size++;
    }

    public void addLast(E data) {
        if (head == null)
            addFirst(data);
        else {
            Node x = head;

            while (x.next != null)
                x = x.next;

            x.next = new Node(data);
            size++;
        }
    }

    public void add(int index, E data) {
        checkPositionIndex(index);

        if (index == 0)
            addFirst(data);
        else {
            Node x = head;

            for (int i = 0; i < index - 1; i++)
                x = x.next;

            x.next = new Node(data, x.next);
            size++;
        }
    }

    public Object get(int index) {
        checkElementIndex(index);
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x.data;
    }

    public int size() {
        return size;
    }


    public Object remove() {
        return removeFirst();
    }

    public Object removeFirst() {
        if (size == 0)
            throw new NoSuchElementException();
        else {
            Object temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
    }

    public Object removeLast() {
        if (size <= 1)
            return removeFirst();
        else {
            Node x = head;

            while (x.next.next != null)
                x = x.next;

            Object temp = x.next.data;
            x.next = null;
            size--;
            return temp;
        }
    }

    public void remove(int index) {
        checkElementIndex(index);

        if (index == 0)
            removeFirst();
        else {
            Node x = head;
            for (int i = 0; i < index - 1; i++)
                x = x.next;

            x.next = x.next.next;
            size--;
        }
    }

    public void remove(Object data) {
        removeFirst(data);
    }


    public void removeFirst(Object data) {
        Node x = head;

        for (int i = 0; i < size; i++, x = x.next)
            if (x.data.equals(data)) {
                remove(i);
                return;
            }
    }

    public void removeLast(Object data) {
        int lastOccurrence = -1;
        Node x = head;

        for (int i = 0; i < size; i++, x = x.next)
            if (x.data.equals(data))
                lastOccurrence = i;

        if (lastOccurrence != -1)
            remove(lastOccurrence);
    }

    public void removeAll(Object data) {
        Node x = head;

        for (int i = 0; i < size; x = x.next)
            if (x.data.equals(data))
                remove(i);
            else
                i++;
    }


    public void clear() {
        head = null;
        size = 0;
    }


    public Object set(int index, Object newData) {
        checkElementIndex(index);

        Node x = head;
        for (int i = 0; i < index; i++)
            x = x.next;

        Object temp = x.data;
        x.data = newData;
        return temp;
    }


    public boolean contains(Object o) {
        for (Node x = head; x != null; x = x.next) {
            if (x.data.equals(o)) {
                return true;
            }
        }
        return false;
    }

//
//    public String toString() {
//        if (head == null) {
//            return "null";
//        } else {
//            StringBuilder stringView = new StringBuilder();
//
//            // using StringBuilder inside loops is very efficient
//            for (Node x = head; x != null; x = x.next)
//                stringView.append(x.toNodeString());
//
//            return stringView.toString();
//        }
//    }
//
//
//    public String debugString() {
//        return toString() + " (size: " + size + ")";
//    }
}
