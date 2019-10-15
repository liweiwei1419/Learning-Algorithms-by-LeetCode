/**
 * @author liweiwei1419
 * @date 2019/10/9 4:22 下午
 */
public class Solution2 {
    /**
     * 插入排序
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }


    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
