/**
 * <pre>
 * ADL Lab 04
 * Ian Fennie: 2304236
 * 21.10.17
 *
 * Project file compiled with Javac using JetBrains IntelliJ IDEA 2017.2.5
 * </pre>
 *
 * An implementation of a Priority Queue which is heap sorted according the minimum value.
 * @param <Item> generic Type of elements to be stored and sorted
 */
public class PQmin <Item extends Comparable<Item>> {
    private Item[] a;
    private int N;

    /**
     * Construct an empty Minimum Priority Queue
     */
    public PQmin () {
        a = (Item[]) new Comparable[1];
        int N = 0;
    }

    /**
     * Construct an empty Minimum Priority Queue of an initial size
     * @param maxN the Integer value of the inital size of the Minimum Priority Queue
     */
    public PQmin (int maxN) {
        a = (Item[]) new Comparable[maxN + 1];
        int N = 0;
    }

    /**
     * Construct a heap sorted Minimum Priority Queue from an array of objects
     * @param items the Array of objects to be heap sorted
     */
    public PQmin (Item[] items) {
        a = (Item[]) new Comparable[items.length + 1];
        for (Item item : items) {
            this.insert(item);
        }
    }

    /**
     * Add and sort an object into the Minimum Priority Queue
     * @param item the Object to be added and sorted
     */
    public void insert(Item item) {
        if (N+1 == a.length) {
            resize(2*a.length);
        }
        a[++N] = item;
        swim(N);
    }

    /**
     * Returns and deletes the object in the Queue with the lowest comparable value
     * @return the Object in the Queue with the lowest value
     */
    public Item delMin() {
        Item min = a[1];
        exch(1, N);
        N--;
        a[N+1] = null;
        sink(1);
        if (N > 0 && N < a.length/4) {
            resize(a.length/2);
        }
        return min;
    }

    /**
     * Determines whether the Minimum Priority Queue is empty.
     * @return true if the Minimum Priority Queue is empty; false otherwise.
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Returns the size of the Minimum Priority Queue
     * @return the integer number of elements in the Queue
     */
    public int size() {
        return N;
    }

    private void swim(int k) {
        while (k > 1 && less(k, k/2)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j+1, j)) {
                j++;
            }
            if (!less(j, k)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Comparable[max + 1];
        for (int i = 0; i <= N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    private boolean less(int v, int w) {
        if (a[v].compareTo(a[w]) < 0) {
            return true;
        }
        else {
            return false;
        }
    }

    private void exch(int j, int k) {
        Item temp = a[j];
        a[j] = a[k];
        a[k] = temp;
    }

    public static void main(String[] args) {

        // Test Case 1
        PQmin<Integer> pq = new PQmin<>(100);
        Integer[] a = TextFileHandler.readIntegersFromFile("./resources/numbers100.txt", 100);

        for (Integer k : a) {
            pq.insert(k);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.delMin());
        }

        // Test Case 2
        pq = new PQmin<>();
        a = TextFileHandler.readIntegersFromFile("./resources/numbers100.txt", 100);

        for (Integer k : a) {
            pq.insert(k);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.delMin());
        }

        // Test Case 3
        pq = new PQmin<>(10000);
        a = TextFileHandler.readIntegersFromFile("./resources/numbers10000.txt", 10000);

        for (Integer k : a) {
            pq.insert(k);
        }

        Comparable next, last;
        last = pq.delMin();

        try {
            while (!pq.isEmpty()) {
                next = pq.delMin();
                if (last.compareTo(next) > 0) {
                    throw new Exception("Heap not sorted.");
                }
                last = next;
            }
        } catch (Exception e) {
            System.err.print(e);
        }

        // Test Case 4
        a = TextFileHandler.readIntegersFromFile("./resources/numbers10000.txt", 10000);
        pq = new PQmin<>(a);

        last = pq.delMin();

        try {
            while (!pq.isEmpty()) {
                next = pq.delMin();
                if (last.compareTo(next) > 0) {
                    throw new Exception("Heap not sorted.");
                }
                last = next;
            }
        } catch (Exception e) {
            System.err.print(e);
        }
    }
}
