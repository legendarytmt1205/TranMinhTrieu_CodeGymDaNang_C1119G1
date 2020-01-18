package CollectionsInJava.ThucHanh.LinkedListBasic;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList lkList = new MyLinkedList(10);

        //lkList.addFirst(2);
        //lkList.addFirst(12);
        //lkList.addFirst(15);
        //lkList.add(4, 9);
        lkList.add(4, 9);

        lkList.printList();
    }
}

