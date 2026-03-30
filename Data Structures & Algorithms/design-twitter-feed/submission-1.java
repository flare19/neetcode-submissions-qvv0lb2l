class Twitter {
int count;
HashMap<Integer, Set<Integer>> followMap;
HashMap<Integer, List<int[]>> tweetMap;

    public Twitter() {
        count = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{++count, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for(int followeeId : followMap.get(userId)) {
            if(tweetMap.containsKey(followeeId)) {
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});
            }
        }

        while(!minHeap.isEmpty() && res.size() < 10) {
            int[] curr = minHeap.poll();
            res.add(curr[1]);
            int index = curr[3];
            if(index > 0) {
                int[] tweet = tweetMap.get(curr[2]). get(index - 1);
                minHeap.offer(new int[]{tweet[0], tweet[1], curr[2], index - 1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
