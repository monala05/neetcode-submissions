class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //This needs to be sorted this way can correctly identify all overlaps
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        //Since we dont have to remove. Maybe we can ccount the amount of colisions?
        //The tough question here is that since its in order if we mere 1 2 and 1 4
        // 1 4 still colides with 2 4, maybe we only add the first interval to keep the longest distances
        int count = 0;
        int lastEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < lastEnd){
                //Skip
                count++;
            }else{
                //dont skip add
                lastEnd = intervals[i][1];
            }
        }
        
        return count;
        
    }
}
