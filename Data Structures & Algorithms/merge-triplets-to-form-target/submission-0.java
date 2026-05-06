class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int x = 0, y = 0, z = 0;

        //Scan tripplets checking if we can use the tripplet
        for(int i = 0; i < triplets.length; i++){
            int a = triplets[i][0];
            int b = triplets[i][1];
            int c = triplets[i][2];

            //check if we can use triplet
            if(a <= target[0] && b <= target[1] && c <= target[2]){
                x = Math.max(x, a);
                y = Math.max(y, b);
                z = Math.max(z, c);
            }
        }

        if(x == target[0] && y == target[1] && z == target[2]){
            return true;
        }else{
            return false;
        }
    }
}
