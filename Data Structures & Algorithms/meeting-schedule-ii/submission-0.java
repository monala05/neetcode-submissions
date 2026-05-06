/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        //So the trick here is that we want to keep track of min amount of CONCURRENT rooms. So if we have overlap
        //We need a room for each interval. We can let go of a room when we reach start time that is greater then the end time of the current top of the heap
        
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int ans = 0;
        PriorityQueue<Interval> heap = new PriorityQueue<>(Comparator.comparingInt(i -> i.end));

        for(int i = 0; i < intervals.size(); i++){
            while(!heap.isEmpty() && heap.peek().end <= intervals.get(i).start){
                    heap.poll();
                }
            heap.offer(intervals.get(i));
            ans = Math.max(heap.size(), ans);

        }

        return ans;

    }
}
