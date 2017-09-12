import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * @author Yashveer Singh
 * @version 1.0
 * @param <T> a Comparable generic type
 */
public class ComparableCollection<T extends Comparable> implements
    CollectionInterface<T>, Iterable<T> {
    private Comparable[] collection;

    /**
     * Constructor
     */
    public ComparableCollection() {
        collection = (T[]) new Comparable[15];
    }

    /**
     * Creates an iterator
     *
     * @return a ComparableCollectionIterator
     */
    public Iterator<T> iterator() {
        return new ComparableCollectionIterator();
    }

    /**
     * @author cmuse7
     */
    public class ComparableCollectionIterator implements Iterator<T> {
        private int current = 0;  // the current element we are looking at

        /**
         * Check to see if there is a next element
         *
         * @return whether or not there are more elements in the array that
         * have not been iterated over.
         */
        public boolean hasNext() {
            return ((current < ComparableCollection.this.collection.length - 1)
                && (ComparableCollection.this.collection[current] != null));
        }

        /**
         * return the next element of the iteration and move the current
         * index to the element after that.
         *
         * @return next element of the iteration
         */
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (T) ComparableCollection.this.collection[current++];
        }
    }

    /**
     * Adds an element into the collection.
     * If the new element would exceed the size of the backing array,
     * instead resize the array, doubling it in size and copy over the
     * old elements.
     *
     * @param elem The element being added.
     */
    public void add(T elem) {
        if (collection[collection.length - 1] == null) {
            int pointer = 0;
            while (collection[pointer] != null) {
                pointer++;
            }
            collection[pointer] = elem;
        } else {
            Comparable[] temp = (T[]) new Comparable[collection.length * 2];
            for (int i = 0; i < collection.length; i++) {
                temp[i] = collection[i];
            }
            collection = temp;
            int pointer = 0;
            while (collection[pointer] != null) {
                pointer++;
            }
            collection[pointer] = elem;
        }
    }

    /**
     * Adds all elements in elems to the collection.
     *
     * @param elems Array of elements to be added.
     */
    public void addAll(T[] elems) {
        for (T elem : elems) {
            if (elem != null) {
                this.add(elem);
            }
        }
    }

    /**
     * Remove elem from the collection. Removing an element
     * should shift all the elements behind it forward, ensuring
     * that the backing array is contiguous. For example:
     *
     * Collection = ["hi", "hello", "wsup", "hey", null]
     * Collection after remove("hello") = ["hi", "wsup", "hey", null, null]
     *
     * @param elem Element to be removed.
     * @return true if the element was removed,
     *         false if it was not in the collection.
     */
    public boolean remove(T elem) {
        int pointer = 0;
        for (Comparable item : collection) {
            if (elem.equals((T) item)) {
                for (int i = pointer; i < collection.length - 1; i++) {
                    collection[i] = collection[i + 1];
                }
                collection[collection.length - 1] = null;
                return true;
            }
            pointer++;
        }
        return false;
    }

    /**
     * Removes each element in elems from the collection.
     *
     * @param elems Array of elements to be removed.
     * @return true if any elements were removed,
     *         false if no elements were removed.
     */
    public boolean removeAll(T[] elems) {
        for (T elem : elems) {
            int i = 0;
            while (i < collection.length) {
                if (!(elem.equals(collection[i]))) {
                    i++;
                }
                if (elem.equals(collection[i])) {
                    this.remove(elem);
                    i = collection.length;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks to see if the collection contains a given element.
     *
     * @param elem The element we are checking for.
     * @return true if the collection contains elem, false otherwise.
     */
    public boolean contains(T elem) {
        for (Comparable item : collection) {
            if (elem.equals((T) item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets an element from the collection, using its 0-based index.
     * If the index is within our backing array but more than our last
     * element, rather than returning null, this should throw
     * a java.util.NoSuchElementException.
     *
     * @param index The index of the element we want.
     * @return The element at the specified index.
     * @throws NoSuchElementException if index is in bounds but after
     * element
     */
    public T get(int index) throws NoSuchElementException {
        if (collection[index] == null) {
            throw new NoSuchElementException(String.format("There is "
                + "no item in your ComparableCollection at index %d", index));
        } else {
            return (T) collection[index];
        }
    }

    /**
     * Returns the current number of elements in the collection.
     *
     * @return The size of the collection.
     */
    public int size() {
        int size = 0;
        if (collection[collection.length - 1] != null) {
            size = collection.length;
        } else {
            while (collection[size] != null) {
                size++;
            }
        }
        return size;
    }

    /**
     * Returns the current capacity of the collection - namely, the
     * size of its backing array.
     *
     * @return The total capacity of the collection.
     */
    public int capacity() {
        return collection.length;
    }

    /**
     * Clears the collection, resetting size and starting from a fresh
     * backing array of size 5.
     */
    public void clear() {
        collection = (T[]) new Comparable[5];
    }

    /**
     * Tests if the collection is empty, i.e. it contains no elements.
     *
     * @return true if the collection has no elements, false otherwise.
     */
    public boolean isEmpty() {
        boolean empty = true;
        for (Comparable elem : collection) {
            if (elem != null) {
                empty = false;
            }
        }
        return empty;
    }

    /**
     * While having toString be defined in the interface doesn't force you
     * to override the method in the implementing class, the format we
     * expect the toString() is as follows:
     *
     * [element1, element2, element3, ..., elementN]
     *
     * The end of the list should not contain any nulls, even if the
     * backing array is larger than the number of elements.
     *
     * @return [element1, element2, element3, ..., elementN]
     */
    public String toString() {
        String res = "[";
        for (Comparable elem : collection) {
            res += elem.toString() + ", ";
        }
        int endex = res.length() - 2;
        res = res.substring(0, endex);
        res += "]";
        return res;
    }

}