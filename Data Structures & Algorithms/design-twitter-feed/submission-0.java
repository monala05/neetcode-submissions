class Twitter {
    // Timestamp for current tweet
    int time;
    
    // Maps a user to a list of their followers
    HashMap<Integer, List<Integer>> users;
    
    // Stores tweets with time, userId, and tweetId
    PriorityQueue<int[]> tweets;

    public Twitter() {
        this.time = 0;
        this.users = new HashMap<>();
        this.tweets = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));  // Max-heap based on time
    }
    
    // Method to post a tweet
    public void postTweet(int userId, int tweetId) {
        time++;
        int[] tweet = {time, userId, tweetId};
        tweets.offer(tweet);
    }
    
    // Method to get the user's news feed
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> followersList = users.getOrDefault(userId, new ArrayList<>());
        List<Integer> tweetFeed = new ArrayList<>();
        int index = 10;  // We only want the 10 most recent tweets

        // A priority queue to temporarily hold the processed tweets and restore the original order later
        PriorityQueue<int[]> used = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        // Poll tweets until we have 10 tweets or the queue is empty
        while (!tweets.isEmpty() && index > 0) {
            int[] cur = tweets.poll();
            used.offer(cur); // Put the tweet back into the used queue for later restoration

            // Check if the tweet is from the user or from their followers
            if (cur[1] == userId || followersList.contains(cur[1])) {
                tweetFeed.add(cur[2]);
                index--;
            }
        }

        // Restore the tweets back into the main queue to maintain the order
        while (!used.isEmpty()) {
            tweets.offer(used.poll());
        }

        return tweetFeed;
    }
    
    // Method for a user to follow another user
    public void follow(int followerId, int followeeId) {
        List<Integer> followersList = users.getOrDefault(followerId, new ArrayList<>());
        if (!followersList.contains(followeeId)) {
            followersList.add(followeeId);
            users.put(followerId, followersList);
        }
    }
    
    // Method for a user to unfollow another user
    public void unfollow(int followerId, int followeeId) {
        List<Integer> followersList = users.getOrDefault(followerId, new ArrayList<>());
        followersList.remove(Integer.valueOf(followeeId)); // Remove by value, not by index
        users.put(followerId, followersList); // Update the users map with the new list
    }
}