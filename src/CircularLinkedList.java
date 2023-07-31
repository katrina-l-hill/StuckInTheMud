import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic class
 * @param <E>
 *     Author's code from chapter 16 but for a generic class
 */
public class CircularLinkedList<E> implements CircularLinkedListInterface<E>, Iterable<E> {

    /**
     * Represents the front node of the linked list; starts as null.
     */
    private ListNode<E> front = null;  // first value in the list


    /**
     * Constructor
     */
    public CircularLinkedList() {
        front = null;
    }

    /**
     * Second constructor
     * @param elements varargs parameter
     */
    @SafeVarargs
    public CircularLinkedList(E... elements) {
        for(E x: elements){
            add(x);
        }
    }

    /**
     * Returns the number of elements in the list
     * @return the number of elements in the list
     */
    public int size() {
        if (front == null) {
            return 0;
        }
        int count = 1;
        ListNode<E> current = front;
        while (current != null && current.next != front) {
            current = current.next;
            count++;
        }
        return count;
    }

    /**
     * Retrieves a count of elements being maintained by the list.
     *
     * @return the size of the list (count of elements)
     */
    @Override
    public int getSize() {
        return size();
    }


    public E get(int index) {
        return nodeAt(index).data;
    }

    /**
     * Removes the specified item from the list, if it exists there.
     *
     * @param value the element to remove from the list
     * @return true, if the element was found and removed; false, if not found or list is empty
     */
    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        } else {
            remove(index);
            return true;
        }
    }


    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode<E> current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list, or -1 if not found
     * @param value the element to search for
     * @return the index of the first occurrence of the element in the list, or -1 if not found
     */
   public int indexOf(E value) {
        int index = 0;
        ListNode<E> current = front;
        while (current.next != front) {
            if (current.data.equals(value)) {
                return index;
            }
            index++;
            current = current.next;
        }
        if (current.data.equals(value)) {
            return index;
        }
        return -1;
    }

    /**
     * Adds a new node to the end of the list; by nature, this element's next will point to the first element
     *
     * @param value the element to add to the list
     */
    @Override
    public void add(E value) {
        if (front == null) {
            front = new ListNode<E>(value);
            front.next = front;
        } else {
            ListNode<E> current = front;
            while (current.next != front) {
                current = current.next;
            }
            current.next = new ListNode<E>(value);
            current.next.next = front;
        }
    }

    public void remove(int index) {
        if (index == 0) {
            if (front.next == front) {
                front = null;
            } else {
                ListNode<E> oldFront = front;
                front = front.next;
                ListNode<E> current = front;
                while (current.next != oldFront) {
                    current = current.next;
                }
                current.next = front;
            }
        } else {
            ListNode<E> current = nodeAt(index - 1);
            current.next = current.next.next;
        }


    }

    /**
     * Retrieves an iterator over the list's elements.  Do not do other list operations like add or remove
     * from within an iterator loop; the results are not guaranteed to function as you might expect
     *
     * @return a strongly typed iterator over elements in the list
     */
    @Override
    public Iterator<E> iterator() {
        return new InnerIterator();
    }

    /**
     * Inner class for Iterator that implements Iterator generic class
     */
    class InnerIterator implements Iterator<E>{

        /**
         * Constructs a new InnerIterator object
         */
        public InnerIterator() {

        }

        /**
         * Reference to the current ListNode object
         */
        ListNode<E> current = null;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            if (current != null) {
                return current.next != null;
            } else{
                return front != null;
            }
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (current != null) {
                current = current.next;
                return current.data;
            } else if (front == null) {
                throw new NoSuchElementException();
            }
            else {
                current = front;
                return current.data;
            }
        }
    }

    /**
     * Returns the ListNode at the specified index
     * @param index the index of the ListNode to retrieve
     * @return the ListNode at the specified index
     */
    private ListNode<E> nodeAt(int index) {
        ListNode<E> current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
