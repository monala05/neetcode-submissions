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
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> heap = new PriorityQueue(); 
        int ans = 0;

        for(int i = 0; i < intervals.size(); i++){
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            while(!heap.isEmpty() && heap.peek() <= start){
                heap.poll();
            }
            heap.offer(intervals.get(i).end);
            ans = Math.max(ans, heap.size());
        }

        return ans;
    }
}
