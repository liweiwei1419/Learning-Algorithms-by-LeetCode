public class Main {

    public static void main(String[] args) {
        String s = "a.a..b............................";
        int l = s.split("\\.").length;
        System.out.println(l);
        for (String ss:s.split("\\.")) {
            System.out.println(ss);
        }
    }
}
