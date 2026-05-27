class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = -1;
        while(l < r){
            mid = (l + r)/2;

            if(nums[mid] > nums[r]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }

        return Math.max(bs(nums, 0, l, target), bs(nums, l, nums.length - 1, target));
    }

    public int bs(int[] nums, int l, int r, int target){
        
        int start = l;
        int end = r;

        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;        
    }

}
