import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("ASCII.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        System.out.println(str.length());
        // System.out.println(str);
        TreeSet<Integer> treeSet =new TreeSet<>();
        for (char c:str.toCharArray()) {
            // System.out.println((int)c);
            treeSet.add((int)c);
        }
        for (int c:treeSet) {
            System.out.println(c + " " + (char)c);
        }
    }
}
