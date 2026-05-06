class Solution {
    
        //ALGO
        //We have to iterate through the array
        //We then ask for each nums[i] is there two othere numbers that when added together == 0
        //To do this we have to run what is ordered two sum on every other digit thats not nums[i];
        //The caveat here is that we cant have dupes.
        //In order to not have dupes we can check that the current nums[i] != nums[i - 1]
        //We also have to check that when we move the leftbound pointer the item we moved to is
        //not the same. BUT WHY?
        //We can also optimize by breaking the loop when nums[i] > 0
        // Now we will have a foor loop and while loop
        //the while loop will have two pointers l, r where l = i + 1; and r = length;
        //if the sum of all three pointers = 0 we add to the ans array and break because the 
        //next number in line cannot possibly be equal to 0 since this is and ordered array. and we dont do dupes
        //if they are less than 0< we move the left pointer inward untill we have a new num
        //if greater than 0 we move right pointer inward. We dont have to worry about dupes in this one
        //because since the left pointer will never allow for dupes this can potentially leed to new pairs
        
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)break;
            if(i > 0 && (nums[i - 1] == nums[i]))continue;

            int l = i + 1, r = nums.length - 1;

            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];

                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));

                    l++;
                    r--;

                    while(l < r && nums[l] == nums[l - 1]){
                        l++;
                    }

                }else if(sum < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }

        return ans;

    }

    //Where I messed up
    //I didnt sort the array
    //I wasnt truly thinking about where I needed to move the array
    //I assumed you would just escape the array if a value was found
    //However if a value is found its possible more values in the array could equal 0
    //So we had to move both pointers inward and try to avoid dupes
}
