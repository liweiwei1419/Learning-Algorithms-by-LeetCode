public class Solution3 {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int[] res = new int[2];
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((xor & mask) != 0) {
                break;
            }
            mask <<= 1;
        }
        for (int num : nums) {
            if ((num & mask) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(1 << 0);
        System.out.println(1 << 1);
        System.out.println(1 << 2);
        System.out.println(1 << 3);
    }
}
