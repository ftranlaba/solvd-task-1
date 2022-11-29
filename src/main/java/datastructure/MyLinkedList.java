package datastructure;

public class MyLinkedList<T> {
    private Node<T> head;

    public class Node<T>{
        private T someData;
        private Node<T> next;

        public Node(){
            someData = null;
            next = null;
        }

        public Node(T someData, Node<T> next) {
            this.someData = someData;
            this.next = next;
        }
    }

    public MyLinkedList(){}

    public MyLinkedList(T someData, Node<T> next){
        head = new Node<T>(someData, next);
    }

    public void add(T o){
        Node<T> tempNode = head;
        while(true){
            if(tempNode == null){
                tempNode = new Node<T>(o, null);
                break;
            }
            else{
                tempNode = tempNode.next;
            }
        }
    }

    public void insert(T o, int k){
        Node<T> tempNode = head;
        int c = 0;
        while(true){
            if(c > k){
                // ERROR
                break;
            }
            if(c == k - 1 && tempNode.next != null){
                Node newNode = new Node<T>(o, tempNode.next);
                tempNode = newNode.next;
                break;
            }
            else if(c == k - 1 && tempNode.next == null){
                Node newNode = new Node<T>(o, null);
                break;
            }
            else{
                tempNode = tempNode.next;
            }
            c++;
        }
    }

    public void remove(int k){
        Node<T> tempNode = head;
        int c = 0;
        while(true){
            if(c > k){
                // ERROR
                break;
            }
            if(c == k - 1 && tempNode.next != null){
                tempNode.next = tempNode.next.next;
                break;
            }
            else if(c == k - 1 && tempNode.next == null){
                tempNode.next = null;
                break;
            }
            else{
                tempNode = tempNode.next;
            }
            c++;
        }
    }

    public void remove(T o){

    }

}
