public class Solution {

    public enum State {
        BEGIN, UP, DOWN
    }

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }
        State state = State.BEGIN;
        int res = 1;
        for (int i = 1; i < len; i++) {
            switch (state) {
                case BEGIN:
                    if (nums[i - 1] < nums[i]) {
                        res++;
                        state = State.UP;
                    }
                    if (nums[i - 1] > nums[i]) {
                        res++;
                        state = State.DOWN;
                    }
                    break;
                case UP:
                    if (nums[i - 1] > nums[i]) {
                        res++;
                        state = State.DOWN;
                    }
                    break;
                case DOWN:
                    if (nums[i - 1] < nums[i]) {
                        res++;
                        state = State.UP;
                    }
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        Solution solution = new Solution();
        int wiggleMaxLength = solution.wiggleMaxLength(nums);
        System.out.println(wiggleMaxLength);
    }
}
