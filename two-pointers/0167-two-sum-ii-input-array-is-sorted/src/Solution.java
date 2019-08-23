public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int left = 0;
        int right = len - 1;
        int sum;

        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
