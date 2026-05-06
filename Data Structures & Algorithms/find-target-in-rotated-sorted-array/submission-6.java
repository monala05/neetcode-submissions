class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length -1;

        while(l <= r){
            int mid = l + (r - l) /2;

            if(nums[mid] == target) return mid;
                
            // Here is where we check for sortedness.
            
            if(nums[l] <= nums[mid]){
                //if left hand is sorted we can work from here
                
                if(nums[l] <= target && nums[mid] > target){
                    r = mid - 1;
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
