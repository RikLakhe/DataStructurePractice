package global.citytech.dataStructure;

public class CircularLinkedList {
    private Node head;

    public void insert(int data) {
        Node node = new Node();
        node.data = data;

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != head) {
                n = n.next;
            }
            n.next = node;

        }

        node.next = head;
    }

    public void insertAtStart(int data) {
        Node node = new Node();
        node.data = data;

        Node n = head;
        while (n.next != head) {
            n = n.next;
        }

        n.next = node;
        node.next = head;
        head = node;
    }

    public void insertAtIndex(int data, int index) {
        Node node = new Node();
        node.data = data;

        if (index == 0) {
            insertAtStart(data);
        }
        Node n = head;
        for (int i = 0; i < index-2; i++) {
            n = n.next;
        }

        node.next = n.next;
        n.next = node;
    }

    public void removeAtIndex(int index) {
        if (index == 0) {
            head = head.next;

            Node n = head;
            while (n.next != head) {
                n = n.next;
            }
            n.next = head;

        } else {
            Node n = head;
            Node n1 = null;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1;
        }
    }

    public void show() {
        Node node = head;
        if (head == null) {
            System.out.println("Empty List");
        } else {
            while (node.next != head) {
                System.out.println(node.data);
                node = node.next;
            }
            System.out.println(node.data);
        }
    }
}
