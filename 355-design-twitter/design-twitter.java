class Twitter {
    HashMap<Integer, HashSet<Integer>> followerMap;
    HashMap<Integer, ArrayList<int[]>> userTweetMap;
    int timestamp;

    public Twitter() {
        followerMap = new HashMap<>();
        userTweetMap = new HashMap<>();
        timestamp = 0;
    }   
    
    public void postTweet(int userId, int tweetId) {
        userTweetMap.putIfAbsent(userId, new ArrayList<>());
        userTweetMap.get(userId).add(new int[]{timestamp, tweetId});
        timestamp++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]); // timestamp, tweetId, followee, nextIndex

        followerMap.putIfAbsent(userId, new HashSet<>());
        followerMap.get(userId).add(userId);
        for(int followee: followerMap.get(userId)){
            ArrayList<int[]> tweets = userTweetMap.getOrDefault(followee, new ArrayList<>());
            if(tweets.isEmpty()){
                continue;
            }
            int lastIndex = tweets.size() - 1;
            int[] tweet = tweets.get(lastIndex);
            
            pq.add(new int[]{tweet[0], tweet[1], followee, lastIndex - 1});
        }

        while(!pq.isEmpty() && res.size() < 10){
            int[] curr = pq.poll();
            res.add(curr[1]);
            if(curr[3] >= 0){
                int[] tweet = userTweetMap.get(curr[2]).get(curr[3]);

                pq.add(new int[]{tweet[0], tweet[1], curr[2], curr[3] - 1});
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followerMap.putIfAbsent(followerId, new HashSet<>());
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerMap.containsKey(followerId)){
            followerMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */