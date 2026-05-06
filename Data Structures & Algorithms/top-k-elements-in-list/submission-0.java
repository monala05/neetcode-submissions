class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashy = new HashMap<>();
        List<List<Integer>> buckets = new ArrayList(nums.length + 1);
        
        //get counts
        for(int i = 0; i < nums.length; i++){
            hashy.put(nums[i], hashy.getOrDefault(nums[i], 0) + 1);
        }

        //Initalize empty buckets
        for(int i = 0; i <= nums.length; i++){
            buckets.add(new ArrayList());
        }

        //fill buckets
        for(Map.Entry<Integer, Integer> entry: hashy.entrySet()){
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        //return k elements
        int j = 0;
        int[] ans = new int[k];
        for(int i = buckets.size() - 1; i > 0; i--){
            List<Integer> cur = buckets.get(i);
            
            for(int val: cur){
                ans[j] = val;
                j++;
                if(j == k){
                    return ans;
                }
            }
        }

        return ans;
        
    }
}
