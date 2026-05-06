class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while(l < r){
            int mid = l + (r - l)/2;
            
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return nums[l];
    }

    // what are our search conditions?
    //We need to find the smallest element.
    //What do the pointers tell us about how we need to search.
    //what is the win condition?
    //We need to see if the mid point and right is sorted.
    //if its not sorted. We move the left pointer if the right is greater than mid. Else we move the right
    //The point is to find the sorted portions and move based on sortedness.




}
