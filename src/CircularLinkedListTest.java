import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for CircularLinkedList
 */
class CircularLinkedListTest {


    /**
     * Test case to verify the constructors
     */
    @org.junit.jupiter.api.Test
    public void testConstructors() {
        LinkedList<Integer> list = new LinkedList<>();
        assertNotNull(list);
        assertEquals(list.getSize(), 0);
        list = new LinkedList<>(1, 2, 3);
        assertNotNull(list);
        assertEquals(list.getSize(), 3);
        Player player = new Player();
        assertNotNull(player);
        player = new Player("Joe Bob");
        assertNotNull(player);
        assertEquals(player.getName(), "Joe Bob");
        ListNode<Integer> node = new ListNode<>();
        assertNotNull(node);
        ListNode<Integer> node2 = new ListNode<>(10, node);
        assertNotNull(node2);
        assertNotNull(node2.next);
        assertEquals(node2.data, 10);
        CircularLinkedList<Integer> cll = new CircularLinkedList<>();
        assertNotNull(cll);
        cll = new CircularLinkedList<>(1, 2, 3);
        assertNotNull(cll);
        assertEquals(cll.getSize(), 3);
    }


    /**
     * Test case to verify the size() method of CircularLinkedList
     */
    @org.junit.jupiter.api.Test
    public void size() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        int size = list.size();
        assertEquals(0, size);
    }


    /**
     * Test case to verify the getSize() method of CircularLinkedList
     */
    @org.junit.jupiter.api.Test
    public void getSize() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(10);
        int size = list.getSize();
        assertEquals(1, size);
    }


    /**
     * Test case to verify get() method of CircularLinkedList
     */
    @org.junit.jupiter.api.Test
    public void get() {
    }


    /**
     * Test case to verify the toString() method of CircularLinkedList
     */
    @org.junit.jupiter.api.Test
    public void testToString() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        String result = list.toString();
        assertEquals("[]", result);
    }


    /**
     * Test case to verify the indexOf() method of CircularLinkedList
     */
    @org.junit.jupiter.api.Test
    public void indexOf() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(10);
        list.add(5);
        list.add(3);
        int index = list.indexOf(10);
        assertEquals(0, index);
    }


    /**
     * Test case to verify the add() method of CircularLinkedList
     */
    @org.junit.jupiter.api.Test
    public void add() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(10);
        int size = list.size();
        assertEquals(1, size);
        assertEquals(10, list.get(0));
    }


    /**
     * Test case to verify the iterator() method of CircularLinkedList
     */
    @org.junit.jupiter.api.Test
    public void iterator() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        Iterator<Integer> iterator = list.iterator();
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}