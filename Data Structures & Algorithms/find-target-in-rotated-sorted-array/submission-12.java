class Solution {
    public int search(int[] nums, int target) {
        //The idea here is to split this up into two arrays and do two binary searches

        int l = 0;
        int r = nums.length - 1;
        int mid =-1;
        //Find the smallest index
        while(l < r){
            mid = l + (r- l) /2;

            if(nums[mid] > nums[r]){
                l = mid +1;
            }else{
                r = mid;
            }
        }

        int begin = l;
        //search left side
        int leftResult = dfs(0, begin, nums, target);
        //search right side
        int rightResult = dfs(begin, nums.length -1, nums, target);

        return Math.max(leftResult, rightResult);
    }

    //classic binary search
    public int dfs(int l, int r, int[] nums, int target){

        while(l <= r){
            int mid = l + (r -l)/ 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid -1;
            }
        }

        return -1;
    }
}
