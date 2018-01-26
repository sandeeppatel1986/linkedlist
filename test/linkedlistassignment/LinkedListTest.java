package linkedlistassignment;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 *
 * @author Mohit Sangwan
 * @since Jan 26, 2018, 4:59:12 PM
 */
public class LinkedListTest {

    private LinkedList<TestObject> list;

    @Before
    public void createEmptyLinkedList() {
        list = new LinkedList<TestObject>();
    }

    @Test
    public void insertOneItem() {
        TestObject itemToInsert = new TestObject("Item to be Inserted");
        list.insert(itemToInsert);
        assertThat("Adding an item resulted in an empty list.", list.isEmpty(), is(equalTo(false)));
    }

}
