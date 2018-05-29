
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String digits = "234";

        String two = "abc"; // 2
        String three = "def"; // 3
        String four = "ghi"; // 4


        List<String> result = new ArrayList<>();
        StringBuilder s = null;
        for (int i = 0; i < 3; i++) {
            s = new StringBuilder();
            s.append(two.charAt(i));
            for (int j = 0; j < 3; j++) {
                s.append(three.charAt(i));
                for (int k = 0; k < 3; k++) {
                    s.append(four.charAt(i));
                }
            }
            result.add(s.toString());

        }
        System.out.println(result);

    }
}
