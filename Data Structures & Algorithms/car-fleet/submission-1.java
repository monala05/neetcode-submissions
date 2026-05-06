class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];
        

        for(int i = 0; i < position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i])/speed[i];
        }
        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0]));

        int fleet = 0;
        double maxTime = 0;

        for(int i = 0; i < cars.length; i++){
            if(cars[i][1] > maxTime){
                fleet++;
                maxTime = cars[i][1];
            }
        }

        return fleet;
    }
}
 