/**
 * <pre>
 * ADL Lab 04
 * Ian Fennie: 2304236
 * 21.10.17
 *
 * Project file compiled with Javac using JetBrains IntelliJ IDEA 2017.2.5
 * </pre>
 *
 * The minimum implementation of a generic class which operates similiarly to
 * a pushdown stack ("Last In, First Out (LIFO)") can be used to store an
 * array of objects of a generic type.
 *
 * @param <Item> generic Type of elements to be stored
 */
public class MyClass <Item extends Comparable<Item>>
{
    private Item[] a;
    private int N = 0;

    /**
     * Constructor which initializes an array field with a fixed size
     * @param maxN Integer value of the maximum number of elements to be stored
     *             in the array
     */
    public MyClass(int maxN) {
        a = (Item[]) new Comparable[maxN+1];
    }

    /**
     * Add an element to the array field
     * @param item Item to be added as an element of the array field
     */
    public void insert(Item item) {
        a[++N] = item;
    }

    /**
     * Returns the last item added to the array field
     * @return the last element added to the class
     */
    public Item getItem() {
        Item temp = a[N--];
        a[N+1] = null;
        return temp;
    }

    public static void main(String[] args) {
        MyClass<Integer> mc = new MyClass<>(1);
        mc.insert(1);
        int i = mc.getItem();
        System.out.println(i);

        MyClass<Student> mc2 = new MyClass<>(1);
        mc2.insert(new Student());
        Student s = mc2.getItem();
        System.out.println(s);
    }
}
