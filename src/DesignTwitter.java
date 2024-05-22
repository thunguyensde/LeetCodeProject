import java.util.*;

class DesignTwitter {
    /*
    355.

    */

    Map<Integer, Set<Integer>> followeeMap;
    Map<Integer, TweetNode> tweetMap;
    int time;
    public DesignTwitter() {
        followeeMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (tweetMap.containsKey(userId)) {
            TweetNode tweet = new TweetNode(tweetId, time++, tweetMap.get(userId));
            tweetMap.put(userId, tweet);
        } else {
            tweetMap.put(userId, new TweetNode(tweetId, time++, null));
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<TweetNode> heap = new PriorityQueue<>((a, b) -> b.time - a.time);
        Set<Integer> followees = followeeMap.getOrDefault(userId, Collections.singleton(userId));
        for (int followee : followees) {
            if (tweetMap.containsKey(followee)) {
                heap.add(tweetMap.get(followee));
            }
        }

        List<Integer> feed = new ArrayList<>();
        while (!heap.isEmpty() && feed.size() < 10) {
            TweetNode tweet = heap.poll();
            feed.add(tweet.id);
            if (tweet.next != null) {
                heap.add(tweet.next);
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        followeeMap.computeIfAbsent(followerId, k -> new HashSet<>(){{ add(followerId); }}).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followeeMap.containsKey(followerId)) {
            followeeMap.get(followerId).remove(followeeId);
        }
    }

    // Utilize customized linked list
    private static class TweetNode {
        int id;
        int time;
        TweetNode next;

        public TweetNode(int id, int time, TweetNode next) {
            this.id = id;
            this.time = time;
            this.next = next;
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