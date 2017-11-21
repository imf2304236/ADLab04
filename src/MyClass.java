/**
 * Generic class MyClass
 * @param <Item> the type of the objects stored in the class
 */
public class MyClass <Item extends Comparable<Item>>
{
    private Item[] a;             // heap-ordered complete binary tree
    private int N = 0;            //    in a[1..N] with a[0] unused

    public MyClass(int maxN) {
        a = (Item[]) new Comparable[maxN+1];
    }

    public void insert(Item item) {
        a[++N] = item;
    }

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
