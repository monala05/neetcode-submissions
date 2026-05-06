class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length -1;

        while(l < r){
            int curSum = numbers[l] + numbers[r];

            if(curSum > target){
                r--;
            }else if(curSum < target){
                l++;
            }else{
                int[] ans = {l+1, r+1};
                return ans;
            }
        }

        int[] temp = {-1,-1};
        return temp;
    }
}
