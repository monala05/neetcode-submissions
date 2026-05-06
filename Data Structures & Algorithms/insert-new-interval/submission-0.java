class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> valid = new ArrayList();
        int i = 0;

        //Add all intervals that do not overlap
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            List<Integer> cur = new ArrayList();
            cur.add(intervals[i][0]);
            cur.add(intervals[i][1]);
            valid.add(cur);
            i++;
        }

        int start = newInterval[0];
        int end = newInterval[1];
        //Try and find the merged intervals
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            start = Math.min(intervals[i][0], start);
            end = Math.max(intervals[i][1], end);
            i++;
        }

        List<Integer> merged = new ArrayList();
        merged.add(start);
        merged.add(end);
        valid.add(merged);

        //add remaining intervals if we havent reached the end
        while(i < intervals.length){
            List<Integer> cur = new ArrayList();
            cur.add(intervals[i][0]);
            cur.add(intervals[i][1]);
            valid.add(cur);
            i++;
        }

        //convert list to array so we can return an answer
        int[][] ans = new int[valid.size()][2];

        for(int j = 0; j < valid.size(); j++){
            ans[j][0] = valid.get(j).get(0);
            ans[j][1] = valid.get(j).get(1);
        }

        return ans;

    }
}
