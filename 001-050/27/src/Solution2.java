public class Solution2 {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        for (; i < nums.length; i++) {
            if(nums[i]==val){
                continue;
            }
            nums[j] = nums[i];
            // 只要遇到与 val 不等的元素，就累加 1
            // 所以，直接返回 j 就可以了
            j++;
        }
        return j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.removeElement(new int[]{3,2,2,3},2);
        System.out.println(result);
    }
}
