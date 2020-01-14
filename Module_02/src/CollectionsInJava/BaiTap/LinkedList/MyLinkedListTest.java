package CollectionsInJava.BaiTap.LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        class Students{
            private int id;
            private String name;

            public Students() {
            }

            public Students(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        MyLinkedList<Students> mylist = new MyLinkedList();
        Students student1 = new Students(1,"tran minh trieu");
        mylist.addFirst(student1);
        for (int i = 0; i<mylist.size;i++) {
            Students student = (Students)(mylist.get(i));
            System.out.println(student.getName().toString());
        }
    }
}
