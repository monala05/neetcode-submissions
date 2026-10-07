class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> adj = new HashMap();
        int length = 1;
        wordList.add(beginWord);
        for(String s: wordList){
            adj.put(s, new ArrayList());
        }

        for(String s: wordList){
            for(String j: wordList){
                if(!s.equals(j)){
                    if(isNeighbor(s, j)){
                        adj.get(s).add(j);
                    }
                }
            }
        }

        //Iterate via bfs
        Queue<String> queue = new ArrayDeque();
        HashSet<String> visited = new HashSet();

        queue.offer(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Process all words at the current distance.
            for (int i = 0; i < levelSize; i++) {
                String current = queue.poll();

                if (current.equals(endWord)) {
                    return length;
                }

                for (String neighbor : adj.get(current)) {
                    if (visited.add(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }

            length++;
        }

        return 0;

    }

    private boolean isNeighbor(String a, String b) {
        int differences = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                differences++;
                if (differences > 1) return false;
            }
        }
        return differences == 1;
    }
}
