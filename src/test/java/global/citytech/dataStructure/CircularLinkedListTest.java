package global.citytech.dataStructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircularLinkedListTest {

    @Test(expected = IllegalArgumentException.class)
    public void doInitialCircularLinkedListTesting() {
        CircularLinkedList circularList = new CircularLinkedList();
        circularList.initialTesting();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void doGetItemAtIndexCircularLinkedListWithoutAddingTesting() {
        CircularLinkedList circularList = new CircularLinkedList();
        try{
            circularList.getItemAtIndex(2);
        }catch (ArrayIndexOutOfBoundsException err){
            String message = "There is no data!";
            assertEquals(message, err.getMessage());
            throw err;
        }
    }

    @Test
    public void doInsertCircularLinkedListTesting() {
        CircularLinkedList circularList = new CircularLinkedList();
        circularList.insert(0);
        circularList.insert(1);
        circularList.insert(2);
        circularList.insert(3);
        circularList.insert(4);
        circularList.insert(5);
        int result = circularList.getItemAtIndex(20);
        assertEquals(2,result);
    }

    @Test
    public void doInsertAtStartLinkedListTesting() {
        CircularLinkedList circularList = new CircularLinkedList();
        circularList.insert(33);
        circularList.insert(5);
        circularList.insert(54);
        circularList.insert(46);
        circularList.insertAtStart(11);
        int result = circularList.getItemAtIndex(0);
        assertEquals(result, 11);
    }

    @Test
    public void doInsertAtIndexLinkedListTesting() {
        CircularLinkedList circularList = new CircularLinkedList();
        circularList.insert(33);
        circularList.insert(5);
        circularList.insert(54);
        circularList.insert(46);
        circularList.insertAtIndex(11,2);
        int result = circularList.getItemAtIndex(2);
        assertEquals(11,result);
    }

    @Test
    public void doInsertAtIndexZeroLinkedListTesting() {
        CircularLinkedList circularList = new CircularLinkedList();
        circularList.insert(33);
        circularList.insert(5);
        circularList.insert(54);
        circularList.insert(46);
        circularList.insertAtIndex(11,0);
        int result = circularList.getItemAtIndex(2);
        assertEquals(5,result);
    }

    @Test
    public void doRemoveAtIndexLinkedListTesting() {
        CircularLinkedList circularList = new CircularLinkedList();
        circularList.insert(33);
        circularList.insert(5);
        circularList.insert(54);
        circularList.insert(46);
        circularList.removeAtIndex(20);
        int result = circularList.getItemAtIndex(20);
        assertEquals(54,result);
    }

    @Test
    public void doRemoveAtIndexZeroLinkedListTesting() {
        CircularLinkedList circularList = new CircularLinkedList();
        circularList.insert(33);
        circularList.insert(5);
        circularList.insert(54);
        circularList.insert(46);
        circularList.removeAtIndex(0);
        int result = circularList.getItemAtIndex(2);
        assertEquals(46,result);
    }
}
