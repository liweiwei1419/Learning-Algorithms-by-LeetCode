import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);
        System.out.println(set.floor(12));
        System.out.println(set.floor(15));
        System.out.println(set.floor(20));
        System.out.println(set.floor(21));
        System.out.println("---");
        System.out.println(set.ceiling(12));
        System.out.println(set.ceiling(15));
        System.out.println(set.ceiling(20));
        System.out.println(set.ceiling(21));
    }
}
