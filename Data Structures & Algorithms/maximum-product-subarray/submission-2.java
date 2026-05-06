
class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int global = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int prevMin = min;
            int prevMax = max;

            min = Math.min(nums[i], Math.min(nums[i] * prevMin, nums[i] * prevMax));
            max = Math.max(nums[i], Math.max(nums[i] * prevMin, nums[i] * prevMax));

            global = Math.max(global, max);
        }

        return global;
    }
}
