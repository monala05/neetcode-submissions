class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //we have to sort the array
        //now we loop thought the array and we have to find three numbers that equal 0 and add them
        //to an answer array. 
        // we can do this by picking a number and then running a while loop that basically scans for
        // two values that equal 0.
        // we need to make sure that we dont put up duplicates

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] > 0 ) break;
            if(i > 0 && nums[i] == nums[i -1])continue;
        
            int l = i + 1;
            int r = nums.length - 1;

            while(l < r){
                //[-4,-1,-1,0,1,2]
                int cur = nums[i] + nums[l] + nums[r]; 
                System.out.println(cur);
                System.out.println( "i = " + i + "L = " + l + " R = " + r);
                //-1 + -1 + 2 = 
                if(cur == 0){
                    List<Integer> temp = new ArrayList();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    ans.add(temp);
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }

                }else if(cur < 0){
                    l++;
                }else{
                    r--;
                }
            } 
        }

        return ans;
    }
}
