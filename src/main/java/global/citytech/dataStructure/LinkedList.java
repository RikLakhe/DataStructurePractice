package global.citytech.dataStructure;

public class LinkedList {

    private Node head;

    public void initialTesting() {
        throw new IllegalArgumentException("Testing connected");
    }

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
            insertAtStart(data);
        }else{
            Node n = head;
            for (int i = 0; i < index-1; i++) {
                n = n.next;
            }

            node.next = n.next;
            n.next = node;
        }

    }

    public void removeAtIndex(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node n = head;
            Node n1;
            for (int i = 0; i < index-1; i++) {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
        }
    }

    public void pop() {
        Node n = head;
        int i = 0;
        if (head != null) {
            while (n.next != null) {
                i++;
                n = n.next;
            }

            if (n != head) {
                Node temp = head;
                for (int j = 0; j < i - 1; j++) {
                    temp = temp.next;
                }
                temp.next = null;
            } else {
                head = null;
            }
        }
    }

    public void show() {
        Node node = head;
        if (head == null) {
            System.out.println("Empty List");
        } else {
            while (node.next != null) {
                System.out.println(node.data);
                node = node.next;
            }
            System.out.println(node.data);
        }
    }

    public int getItemAtIndex(int index) {
        Node n = head;
        if(n==null){
            throw new ArrayIndexOutOfBoundsException("There is no data!");
        }else{
            for (int i = 0; i < index ; i++) {
                if(n.next != null){
                    n = n.next;
                }else{
                    throw new ArrayIndexOutOfBoundsException("There is no data in given index!");
                }
            }
            return n.data;
        }
    }
}
