class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(int i = 0; i < points.length; i ++){
            int[] cur = new int[3];
            int x = points[i][0];
            int y = points[i][1];

            cur[0] = (x * x) + (y * y);
            cur[1] = x;
            cur[2] = y;
            q.offer(cur);

            if(q.size() > k){
                q.poll();
            }
        } 

        int[][] ans = new int[k][2];
        int i = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            ans[i] = new int[]{cur[1], cur[2]};
            i++;
        }

        return ans;
    }
}
