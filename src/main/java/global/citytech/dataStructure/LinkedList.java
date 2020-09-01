package global.citytech.dataStructure;

public class LinkedList {

    private Node head;

    public void insert(int data) {
        Node node = new Node();
        node.data = data;

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void insertAtStart(int data) {
        Node node = new Node();
        node.data = data;

        node.next = head;
        head = node;
    }

    public void insertAtIndex(int data, int index) {
        Node node = new Node();
        node.data = data;

        if (index == 0) {
            node.next = head;
            head = node;
        }
        Node n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }

        node.next = n.next;
        n.next = node;
    }

    public void removeAtIndex(int index) {
        if (index == 0) {
            head = head.next;
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

    public void pop() {
        Node n = head;
        int i = 0;
        if(head != null){
            while (n.next != null) {
                i++;
                n = n.next;
            }

            if(n != head){
                Node temp = head;
                for (int j = 0; j < i - 1; j++) {
                    temp = temp.next;
                }
                temp.next = null;
            }else{
                head=null;
            }
        }
    }

    public void show() {
        Node node = head;
        if(head == null){
            System.out.println("Empty List");
        }else {
            while(node.next != null){
                System.out.println(node.data);
                node = node.next;
            }
            System.out.println(node.data);
        }
    }
}
