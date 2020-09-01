package global.citytech.dataStructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test(expected = IllegalArgumentException.class)
    public void doInitialLinkedListTesting() {
        LinkedList list = new LinkedList();
        list.initialTesting();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void doGetItemAtIndexLinkedListWithoutAddingTesting() {
        LinkedList list = new LinkedList();
        try{
            list.getItemAtIndex(2);
        }catch (ArrayIndexOutOfBoundsException err){
            String message = "There is no data!";
            assertEquals(message, err.getMessage());
            throw err;
        }
    }

    @Test
    public void doInsertLinkedListTesting() {
        LinkedList list = new LinkedList();
        list.insert(33);
        int result = list.getItemAtIndex(0);
        assertEquals(result, 33);
    }

    @Test
    public void doInsertAtStartLinkedListTesting() {
        LinkedList list = new LinkedList();
        list.insert(33);
        list.insert(5);
        list.insert(54);
        list.insert(46);
        list.insertAtStart(11);
        int result = list.getItemAtIndex(0);
        assertEquals(result, 11);
    }

    @Test
    public void doInsertAtIndexLinkedListTesting() {
        LinkedList list = new LinkedList();
        list.insert(33);
        list.insert(5);
        list.insert(54);
        list.insert(46);
        list.insertAtIndex(11,2);
        int result = list.getItemAtIndex(2);
        assertEquals(11,result);
    }

    @Test
    public void doRemoveAtIndexLinkedListTesting() {
        LinkedList list = new LinkedList();
        list.insert(33);
        list.insert(5);
        list.insert(54);
        list.insert(46);
        list.removeAtIndex(2);
        int result = list.getItemAtIndex(2);
        assertEquals(46,result);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void doPopIndexLinkedListTesting() {
        LinkedList list = new LinkedList();
        list.insert(33);
        list.insert(5);
        list.insert(54);
        list.insert(46);
        list.pop();
        try{
            int result = list.getItemAtIndex(3);
        }catch (ArrayIndexOutOfBoundsException err){
            String message = "There is no data in given index!";
            assertEquals(message, err.getMessage());
            throw err;
        }
    }
}
