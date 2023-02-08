package datastructure;

public class MyLinkedList<T> {
    private Node<T> head;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    public MyLinkedList(T someData, Node<T> next) {
        head = new Node<T>(someData, next);
        size = 1;
    }

    public void add(T o) {
        if (head == null) {
            head = new Node<T>(o, null);
            size++;
            return;
        }
        Node<T> tempNode = head;
        while (true) {
            if (tempNode.next == null) {
                tempNode.next = new Node<T>(o, null);
                size++;
                break;
            } else {
                tempNode = tempNode.next;
            }
        }
    }

    public void insert(T o, int k) {
        if (k >= size) {
            add(o);
            return;
        }
        Node<T> tempNode = head;
        int index = 0;
        while (true) {
            if (index == k - 1 && tempNode.next != null) {
                Node newNode = new Node<T>(o, tempNode.next);
                tempNode.next = newNode;
                size++;
                break;
            } else if (index == k - 1 && tempNode.next == null) {
                Node newNode = new Node<T>(o, null);
                tempNode.next = newNode;
                size++;
                break;
            } else {
                tempNode = tempNode.next;
            }
            index++;
        }
    }

    public void remove(int k) {
        if (k >= size) {
            return;
        }
        Node<T> tempNode = head;
        int index = 0;
        if (index == k) {
            head = head.next;
            return;
        }
        // k represents the kth node to be removed
        // k - 1 represents the node before the kth node that needs to be removed
        while (true) {
            if (index == k - 1 && tempNode.next.next != null) {
                tempNode.next = tempNode.next.next;
                size--;
                break;
            } else if (index == k - 1) {
                tempNode.next = null;
                size--;
                break;
            } else {
                tempNode = tempNode.next;
            }
            index++;
        }
    }

    public void remove(T o) {
        Node<T> tempNode = head;
        while (true) {
            if (tempNode.next.someData.equals(o) && tempNode.next.next != null) {
                size--;
                tempNode.next = tempNode.next.next;
                break;
            } else if (tempNode.next.someData.equals(o)) {
                size--;
                tempNode.next = null;
                break;
            } else {
                tempNode = tempNode.next;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        Node<T> tempNode = head;
        String output = "";
        while (tempNode != null) {
            output += tempNode.someData + " ";
            tempNode = tempNode.next;
        }
        if (output.equals("")) {
            output = "Linked List is empty";
        }
        return output;
    }

    public class Node<T> {
        private T someData;
        private Node<T> next;

        public Node() {
            someData = null;
            next = null;
        }

        public Node(T someData, Node<T> next) {
            this.someData = someData;
            this.next = next;
        }
    }

}
