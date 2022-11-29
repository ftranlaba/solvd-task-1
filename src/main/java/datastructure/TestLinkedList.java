package datastructure;

public class TestLinkedList {

    public static void print(Object o){
        System.out.println(o);
    }

    public static void main(String[] args){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        print("CHECKING EMPTY LINKED LIST");
        print(list.toString());
        print("ADDING ELEMENTS");
        list.add(1);
        list.add(2);
        list.add(3);
        print(list.toString());
        print("INSERTING INTEGER 21 AT POSITION 1");
        list.insert(21, 1);
        print(list.toString());
        print("INSERTING INTEGER 33 AT THE END");
        list.insert(33, 4);
        print(list.toString());
        print("REMOVE LAST ELEMENT");
        list.remove(4);
        print(list.toString());
        print("OUT OF BOUNDS CHECK: REMOVING 100th element");
        list.remove(100);
        print(list.toString());
        print("REMOVE INTEGER 21 OBJECT");
        Integer o = new Integer(21);
        list.remove(o);
        print(list.toString());
    }
}
