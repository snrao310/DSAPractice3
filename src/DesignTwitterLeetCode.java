import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class DesignTwitterLeetCode {

    public static class Twitter {

        HashMap<Integer, HashSet<Integer>> followsMap;
        HashMap<Integer, ArrayList<Tweet>> tweetMap;
        int time;

        public class Tweet{
            int ID;
            int time;
            int user;

            public Tweet(int ID, int time, int user) {
                this.ID = ID;
                this.time = time;
                this.user = user;
            }
        }

        public Twitter() {
            followsMap = new HashMap<>();
            tweetMap = new HashMap<>();
            time = 0;
        }

        public void postTweet(int userId, int tweetId) {
            if(!tweetMap.containsKey(userId)){
                tweetMap.put(userId,new ArrayList<Tweet>());
            }
            ArrayList<Tweet> tweets = tweetMap.get(userId);
            tweets.add(new Tweet(tweetId, time++, userId));
        }

        public List<Integer> getNewsFeed(int userId) {
            HashSet<Integer> followees = followsMap.getOrDefault(userId, new HashSet<Integer>());
            PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
            for (int followee : followees) {
                ArrayList<Tweet> tweets = tweetMap.get(followee);
                if (tweets != null && !tweets.isEmpty()) {
                    heap.add(new int[]{tweets.getLast().ID,tweets.getLast().user,tweets.getLast().time,tweets.size()-1});
                }
            }
            ArrayList<Tweet> ownTweets = tweetMap.get(userId);
            if (ownTweets != null && !ownTweets.isEmpty()) {
                Tweet t = ownTweets.getLast();
                heap.add(new int[]{t.ID,t.user,t.time,ownTweets.size()-1});
            }
            int tweetCount = 0;
            List<Integer> res = new ArrayList<>();
            while (tweetCount < 10 && !heap.isEmpty()) {
                int[] current = heap.poll();
                res.add(current[0]);
                int user = current[1];
                int index = current[3];
                ArrayList<Tweet> tweets = tweetMap.get(user);
                if (tweets != null && index > 0) {
                    heap.add(new int[]{tweets.get(index-1).ID,tweets.get(index-1).user,tweets.get(index-1).time,index-1});
                }
                tweetCount++;
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            if(followerId == followeeId) return;
            if(followsMap.containsKey(followerId)){
                followsMap.get(followerId).add(followeeId);
            }
            else
                followsMap.put(followerId, new HashSet<Integer>(){{add(followeeId);}});
        }

        public void unfollow(int followerId, int followeeId) {
            HashSet<Integer> set = followsMap.getOrDefault(followerId, null);
            if (set != null) {
                set.remove(followeeId);
            }
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 10); // User 1 posts a new tweet with id = 10.
        twitter.postTweet(2, 20); // User 2 posts a new tweet with id = 20.
        System.out.println(twitter.getNewsFeed(1)); // User 1's news feed should only contain their own tweets -> [10].
        System.out.println(twitter.getNewsFeed(2)); // User 2's news feed should only contain their own tweets -> [20].
        twitter.follow(1, 2); // User 1 follows user 2.
        System.out.println(twitter.getNewsFeed(1)); // User 1's news feed should contain both tweets from user 1 and user 2 -> [20,
                                // 10].
        System.out.println(twitter.getNewsFeed(2)); // User 2's news feed should still only contain their own tweets -> [20].
        twitter.unfollow(1, 2); // User 1 unfollows user 2.
        System.out.println(twitter.getNewsFeed(1)); // User 1's news feed should only contain their own tweets -> [10].
    }
}