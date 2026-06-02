class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) 
        -> b[0] - a[0]);

        for(int i = 0; i < points.length; i++){
            int a = points[i][0];
            int b = points[i][1];

            int[] cur = new int[3];
            cur[0] = (a*a) + (b*b);
            cur[1] = a;
            cur[2] = b;

            maxHeap.add(cur);
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }

        int[][] ans = new int[k][2];

        for(int i = 0; i < ans.length; i++){
            int[] cur = maxHeap.remove();

             ans[i][0] = cur[1];
             ans[i][1] = cur[2]; 
        }

        return ans;
    }
}
