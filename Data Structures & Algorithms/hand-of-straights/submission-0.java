class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        HashMap<Integer, Integer> hashy = new HashMap();

        for(int i = 0; i < hand.length; i++){
            hashy.put(hand[i], hashy.getOrDefault(hand[i], 0) + 1);
        }

        for(int i = 0; i < hand.length; i++){
            if(hashy.get(hand[i]) == 0){
                continue;
            }

            for(int j = 0; j < groupSize; j++){
                int cur = hand[i] + j;

                if(hashy.getOrDefault(cur, 0) == 0){
                    return false;
                }else{
                    hashy.put(cur, hashy.get(cur) - 1);
                }
            }
        }

        return true;

    }
}
