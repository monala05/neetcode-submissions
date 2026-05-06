class Solution {
    public int characterReplacement(String s, int k) {
        // What are we doing, we are getting a count off all the characters of current string
        // If the length of the current string + 2 > k we annot make the string work with the current string
        // So we keep subtracting from the current string until it fits the condition


        int[] arr = new int[26];
        int l = 0;
        int maxSum = 0;

        for(int i = 0; i < s.length(); i++){
            char curVal = s.charAt(i);
            int curMax = 0;
            arr[curVal - 'A']++;

            for(int j = 0; j < 26; j++){if(arr[j] > curMax){curMax = arr[j];}}

            while(i - l + 1 - curMax > k){
                arr[s.charAt(l) - 'A']--;
                l++;
            }

            maxSum = Math.max(i - l + 1, maxSum);
        }


        return maxSum;
    }
}
