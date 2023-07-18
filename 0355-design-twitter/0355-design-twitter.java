class Twitter {
    // key: follower, value: {poster1, poster2, poster3}
    HashMap<Integer, HashSet<Integer>> followeesMap;
    // key: userId, value: {[count1, tweetId1], [count2, tweetId2] ....}
    HashMap<Integer, ArrayList<int[]>> postsMap;
    int count;
    
    public Twitter() {
        followeesMap = new HashMap<>();
        postsMap = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!postsMap.containsKey(userId)){
            postsMap.put(userId, new ArrayList<>());
        }
        postsMap.get(userId).add(new int[]{count++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> topTenPosts = new ArrayList<>();
        
        //max heap based on count to get most recent tweet
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        
        // add all the lists into the pq
        if(!followeesMap.containsKey(userId)){
            followeesMap.put(userId, new HashSet<>());
        }
        followeesMap.get(userId).add(userId);
        
        for(int followeeId: followeesMap.get(userId)){
            if(!postsMap.containsKey(followeeId))
                continue;
            int index = postsMap.get(followeeId).size() - 1;
            int lastTweet = postsMap.get(followeeId).get(index)[1];
            int currCount = postsMap.get(followeeId).get(index)[0];
            pq.add(new int[]{currCount, lastTweet, followeeId, index - 1});
        }
        
        while(!pq.isEmpty() && topTenPosts.size() < 10){
            int[] polled = pq.poll(); // count, tweet, followee, next index
            int currTweet = polled[1];
            int followeeId = polled[2];
            int nextIndex = polled[3];
            
            topTenPosts.add(currTweet);
            
            if(nextIndex >= 0){
                int nextCount = postsMap.get(followeeId).get(nextIndex)[0];
                int nextTweet = postsMap.get(followeeId).get(nextIndex)[1];
                pq.add(new int[]{nextCount, nextTweet, followeeId, nextIndex - 1});
            }
        }
        
        return topTenPosts;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followeesMap.containsKey(followerId)){
            followeesMap.put(followerId, new HashSet<>());
        }
        followeesMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followeesMap.containsKey(followerId))
            followeesMap.get(followerId).remove(followeeId);
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