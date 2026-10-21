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
        int n = intervals.size();
        int[][] sorted = new int[n][2];

        for(int i = 0; i < n; i++){
            sorted[i][0] = intervals.get(i).start;
            sorted[i][1] = intervals.get(i).end;
        }

        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue();

        int ans = 0;
        for(int i = 0; i < n; i++){
            int start = sorted[i][0];
            int end = sorted[i][1];

            while(!pq.isEmpty() && pq.peek() <= start){
                pq.poll();
            }

            pq.offer(end);
            ans = Math.max(pq.size(), ans);
        }        

        return ans;
    }
}
