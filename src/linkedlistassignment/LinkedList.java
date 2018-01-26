package linkedlistassignment;

import java.util.Arrays;

public class LinkedList<T> {

    private static final Object[] EMPTY = {};
    private static int size = 0;
    private static int intialSize = 0;

    //Current Cursor position.
    private static int currentElement = 0;

    //T elements stored into listData
    private transient T[] listData;

    /*
     * Constructs a custom arrayList with an initial capacity.
     * @param initialSize
     */
    public LinkedList(int initialSize) {
        size = initialSize;
        this.listData = (T[]) new Object[size];
    }

    public LinkedList() {
        this(intialSize); // initial capicity

    }

    /**
     * Insert an item in front of the current cursor position in the list.
     *
     * If the list is empty {@code item} becomes the first and last item in the list.
     *
     * @complexity O(n2)
     * @param item The item to be inserted into the list.
     */
    public void insert(T itemToInsert) {
        ensureCapacity(listData.length + 1);
        listData = Arrays.copyOf(addPos(listData, currentElement, itemToInsert), listData.length);
    }

    /**
     * Increases the capacity to ensure that it can hold at least the number of elements specified by the minimum
     * capacity argument.
     *
     * @complexity O(1)
     * @param minCapacity the desired minimum capacity
     */
    private void growCustomArrayList(int minCapacity) {
        int newCapacity = minCapacity - size;
        int newCapacity1 = newCapacity + size;
        listData = Arrays.copyOf(listData, newCapacity1);
        size++;
    }

    /**
     * Ensure the capacity and grow the customArrayList vi growCustomArrayList(minCapacity);
     *
     * @complexity O(1)
     * @param minCapacity
     */
    private void ensureCapacity(int minCapacity) {
        if (listData == EMPTY) {
            minCapacity = getMax(intialSize, minCapacity);
        }
        if (minCapacity - listData.length > 0) {
            growCustomArrayList(minCapacity);
        }
    }

    /**
     * Returns the greater of two long values. That is, the result is the argument closer to the value of
     * Long.MAX_VALUE. If the arguments have the same value, the result is that same value. Parameters:
     *
     * @complexity O(1)
     * @param a an argument.
     * @param b another argument.
     * @return :the larger of a and b.
     *
     */
    private int getMax(int a, int b) {
        int max = a > b ? a : b;
        return max;
    }

    /**
     * Where listData is the original array, pos is the position of insertion, and itemToInsert is the item to be
     * inserted.
     *
     * @complexity O(n2)
     * @param listData an argument.
     * @param pos another argument.
     * @param itemToInsert another argument.
     * @return :new array with new inserted element.
     *
     */
    private T[] addPos(T[] listData, int pos, T itemToInsert) {
        T[] result = (T[]) new Object[listData.length];
        for (int i = 0; i < pos; i++) {
            result[i] = listData[i];
        }
        result[pos] = itemToInsert;
        for (int i = pos + 1; i < listData.length; i++) {
            result[i] = listData[i - 1];
        }
        return result;
    }

    /**
     * Where listData is the original array, pos is the position to remove.
     *
     * @param listData an argument.
     * @param pos another argument.
     * @complexity O(n2)
     * @return :new array with removed element.
     *
     */
    private T[] removePos(T[] listData, int pos) {
        T[] result = (T[]) new Object[listData.length - 1];
        for (int i = 0; i <= pos - 1; i++) {
            result[i] = listData[i];
        }
        result[pos] = null;
        for (int i = pos; i < listData.length - 1; i++) {
            result[i] = listData[i + 1];
        }
        return result;
    }

    private T[] removePoss(T[] listData, int pos) {
        T[] result = (T[]) new Object[pos + 1];
        for (int i = 0; i <= pos - 1; i++) {
            result[i] = listData[i];
        }
        return result;
    }

    /**
     * Removes the item, at the last position, from the list.
     *
     * @complexity O(n2)
     * @throws IndexOutOfBoundsException If an attempt is made to remove an element from an empty list.
     */
    public void removeLast() {
        try {
            if (listData.length > 0) {
                listData = Arrays.copyOf(removePos(listData, listData.length - 1), listData.length - 1);
                size--;
            } else {
                System.out.println("List is empty");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Remove all element in the linkedlist that is great than a target value.
     */
    public T[] removeAllItemsGreaterThenTarget(T item) {
        for (int i = 0; i < listData.length; i++) {
            if (listData[i] == item) {

                currentElement = i;
                T[] result = (T[]) new Object[(listData.length) - i];
                int ocunt = 0;
                for (int j = i; j < listData.length; j++) {
                    result[ocunt] = listData[j];
                    ocunt++;
                }
                listData = (T[]) new Object[(listData.length - 1) - i];
                System.out.println("new Array awdawdsize " + result.length);

                listData = Arrays.copyOf(result, result.length);

            }
        }
        return listData;

    }

    /**
     * Indicates if the list is empty or not.
     *
     * @complexity O(1)
     * @return true if the list is empty (has no elements); false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Move the internal cursor to the last element in the list.
     *
     * @complexity O(1)
     * @return The item at the last position in the list; null if the list is empty.
     */
    public T getFirst() {
        try {
            if (listData.length > 0) {
                return listData[listData.length - 1];
            } else {
                System.out.println("List is empty");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public T getLast() {
        try {
            if (listData.length > 0) {
                return listData[0];
            } else {
                System.out.println("List is empty");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void remove() throws IndexOutOfBoundsException {
        listData = Arrays.copyOf(removePos(listData, currentElement), listData.length - 1);
        size--;
    }

}
