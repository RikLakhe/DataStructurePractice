package global.citytech.dataStructure;


public class Runner {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        CircularLinkedList circularList = new CircularLinkedList();

        circularList.insert(13);
        circularList.insert(52);
//        circularList.insertAtStart(11);
//        circularList.insertAtStart(13);
//        circularList.insert(99);
//        circularList.insertAtIndex(88,2);
        circularList.removeAtIndex(1);
        circularList.show();
//        list.insert(52);
//        list.insert(2);
//        list.insert(74);
//        list.insert(45);
//        list.insert(57);
//        list.insertAtStart(22);
//        list.insertAtIndex(53,2);
//        list.pop();
//        list.pop();
//        list.pop();
//        list.insert(88);
//        list.show();
    }
}
