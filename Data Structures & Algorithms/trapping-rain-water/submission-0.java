class Solution {
    public int trap(int[] height) {
        
        int ans = 0;

        int l = 0, r = height.length - 1;
        int lMax = height[l], rMax = height[r];

        while(l < r){
            if(height[l] < height[r]){
                l++;
                lMax = Math.max(height[l], lMax);
                ans += lMax - height[l];
            }else{
                r--;
                rMax = Math.max(height[r], rMax);
                ans += rMax - height[r];
            }
        }

        return ans;
    }
}
