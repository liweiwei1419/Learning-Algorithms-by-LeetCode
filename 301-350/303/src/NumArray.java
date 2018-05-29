import java.util.Arrays;

public class NumArray {
    // cumsum 实现
    // [1,2,3,4]
    // [1,3,6,10]

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return nums[j] - (i - 1 < 0 ? 0 : nums[i - 1]);
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        NumArray numArray = new NumArray(nums);
        int result = numArray.sumRange(2, 3);
        System.out.println(result);
    }
}
