/**
 * IntelliJ Project
 * Created by IF on 20.11.17.
 */
public class PQmin <Item extends Comparable<Item>> {
    private Item[] a;
    private int N;

    /**
     *
     */
    public PQmin () {
        a = (Item[]) new Comparable[1];
        int N = 0;
    }

    /**
     *
     * @param maxN
     */
    public PQmin (int maxN) {
        a = (Item[]) new Comparable[maxN + 1];
        int N = 0;
    }

//    /**
//     *
//     * @param a
//     */
//    public PQmin (Item[] a) {
//
//    }

    /**
     *
     * @param item
     */
    public void insert(Item item) {
        if (N+1 == a.length) {
            resize(2*a.length);
        }
        a[++N] = item;
        swim(N);
    }

    /**
     *
     * @return
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
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     *
     * @return
     */
    public int size() {
        return N;
    }

    /**
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k, k/2)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    /**
     *
     * @param k
     */
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

    /**
     *
     * @param v
     * @param w
     * @return
     */
    private boolean less(int v, int w) {
        if (a[v].compareTo(a[w]) < 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *
     * @param j
     * @param k
     */
    private void exch(int j, int k) {
        Item temp = a[j];
        a[j] = a[k];
        a[k] = temp;
    }

    public static void main(String[] args) {

        // Test Case 1
        PQmin<Integer> pq = new PQmin<>(100);
        String[] a = TextFileHandler.readStringsFromFile("./resources/numbers100.txt", 100);

        for (String s : a) {
            pq.insert(Integer.parseInt(s));
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.delMin());
        }

        // Test Case 2
        pq = new PQmin<>();
        a = TextFileHandler.readStringsFromFile("./resources/numbers100.txt", 100);

        for (String s : a) {
            pq.insert(Integer.parseInt(s));
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.delMin());
        }

        // Test Case 3
        pq = new PQmin<>(10000);
        a = TextFileHandler.readStringsFromFile("./resources/numbers10000.txt", 10000);

        for (String s : a) {
            pq.insert(Integer.parseInt(s));
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
    }
}
