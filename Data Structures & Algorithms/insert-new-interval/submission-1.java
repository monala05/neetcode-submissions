class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> valid = new ArrayList();

        int i = 0;

        while(i < intervals.length && newInterval[0] > intervals[i][1]){
            valid.add(intervals[i]);
            i++;
        }
        int start = newInterval[0];
        int end = newInterval[1];

        while(i < intervals.length && end >= intervals[i][0]){
            start = Math.min(intervals[i][0], start);
            end = Math.max(intervals[i][1], end);
            i++;
        }

        int[] merged = new int[]{start, end};
        valid.add(merged);

        while(i < intervals.length){
            valid.add(intervals[i]);
            i++;
        }

        int[][] ans = new int[valid.size()][2];
        for(int j = 0; j < valid.size(); j++){
            ans[j] = valid.get(j);
        }

        return ans;
    }
}
