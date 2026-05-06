class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while(l <= r){
            int mid = l + (r - l)/2;
            //Since we are actually searching for a target, not start we have to make it so we keep
            //the binary search property.

            if(nums[mid] == target)return mid;

            if(nums[l] <= nums[mid]){
                if(nums[l] <= target && nums[mid] > target){
                    r = mid -1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(nums[mid] < target && nums[r] >= target){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
