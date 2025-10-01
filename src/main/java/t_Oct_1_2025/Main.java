package t_Oct_1_2025;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.addFirst(23);
        list.addFirst(34);
        list.addFirst(56);
        System.out.println("\nInitial List: " + list + "\n");

        list.addFirst(78);
        System.out.println("Add First: " + list + "\n");

        list.addLast(100);
        System.out.println("Add Last: " + list + "\n");

        list.removeFirst();
        System.out.println("Remove First: " + list + "\n");

        list.removeLast();
        System.out.println("Remove Last: " + list + "\n");

        list.clear();
        System.out.println("After Clear: " + list);



    }
}

class Node {

    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.getData() + "";
    }
}

class LinkedList {

    private Node head;

    public LinkedList() {
        head = null;
    }

    public void clear() {
        head = null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        else {
            Node pointer = head;
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(newNode);
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = head.getNext();
        }
    }

    public void removeLast() {

        if (head == null) {
            return;
        } else if (head.getNext() == null) {
            head = null;
        } else {
                Node pointer1 = head;
                Node pointer2 = head.getNext();
                while (pointer2.getNext() != null) {
                    pointer1 = pointer2;
                    pointer2 = pointer2.getNext();
                }
                pointer1.setNext(null);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node pointer = head;
        while (pointer != null) {
            sb.append(pointer.getData());
            pointer = pointer.getNext();
            if (pointer != null) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }
}