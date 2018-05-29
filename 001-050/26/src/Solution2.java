import java.util.Arrays;

public class Solution2 {

    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int memory = nums[0];
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - memory > 0) {
                nums[j] = nums[i];
                j++;
                memory = nums[i];
            } else {
                continue;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] nums = new int[]{1,1,1,2,2,2,3,3,3,4,5,6,7,7,7,8,9,10,10};
        int[] nums = new int[]{1};
        int result = solution.removeDuplicates(nums);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }
}
