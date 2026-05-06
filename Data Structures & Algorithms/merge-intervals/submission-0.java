class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<List<Integer>> output = new ArrayList<>();

        int i = 0;
        while(i < intervals.length){
            int start = intervals[i][0];
            int end = intervals[i][1];

            while(i < intervals.length - 1 && end >= intervals[i+1][0]){
                end = Math.max(end, intervals[i+1][1]);
                i++;
            }
            List<Integer> cur = new ArrayList<>();
            cur.add(start);
            cur.add(end);
            output.add(cur);
            i++;
        }

        int[][] ans = new int[output.size()][2];

        for(int j = 0; j < output.size(); j++){
            ans[j][0] = output.get(j).get(0);
            ans[j][1] = output.get(j).get(1);
        }

        return ans;
    }
}
