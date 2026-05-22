class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] sorted = new double[position.length][2];
        for(int i = 0; i < position.length; i++){
            sorted[i][0] = position[i];
            sorted[i][1] = (double)(target - position[i])/speed[i];
        }
        Arrays.sort(sorted, (a, b) -> Double.compare(b[0], a[0]));
        int ans = 0;
        double prev = 0;

        for(int i = 0; i < sorted.length; i++){
            if(sorted[i][1] > prev){
                ans++;
                prev = sorted[i][1];
            }
        }

        return ans;
    }
}
