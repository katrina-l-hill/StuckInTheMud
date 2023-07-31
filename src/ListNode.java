import java.util.List;

/**
 * Declares a generic class
 * @param <E> generic type parameter
 */
public class ListNode<E> {

    /**
     * Generic instance variable
     */
    public E data;

    /**
     * Public instance variable of type ListNode with generic type parameter E
     */
    public ListNode<E> next;


    /**
     * Constructor
     */
    public ListNode() {
        data = null;
        next = null;
    }


    /**
     * Constructor
     * @param data assigns the value of the data parameter to the instance variable
     * @param next assigns the value of the next parameter to the instance variable
     */
    public ListNode(E data, ListNode<E> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Constructor
     * @param data assigns the value of the data parameter to the instance variable
     */
    public ListNode(E data) {
        this.data = data;
    }

}
