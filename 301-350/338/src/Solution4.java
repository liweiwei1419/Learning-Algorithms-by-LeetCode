import java.util.Arrays;

/**
 * @author liwei
 * @date 18/7/3 下午4:03
 */
public class Solution4 {

    // 每个都计算一下，也不会超时

    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ret[i] = bitCount(i);
        }
        return ret;
    }

    private int bitCount(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] countBits = solution4.countBits(5);
        System.out.println(Arrays.toString(countBits));
    }
}
