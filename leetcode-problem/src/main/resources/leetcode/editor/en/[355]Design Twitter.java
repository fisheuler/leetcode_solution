//Design a simplified version of Twitter where users can post tweets, follow/unf
//ollow another user, and is able to see the 10 most recent tweets in the user's n
//ews feed. 
//
// Implement the Twitter class: 
//
// 
// Twitter() Initializes your twitter object. 
// void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId 
//by the user userId. Each call to this function will be made with a unique tweetI
//d. 
// List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs 
//in the user's news feed. Each item in the news feed must be posted by users who 
//the user followed or by the user themself. Tweets must be ordered from most rece
//nt to least recent. 
// void follow(int followerId, int followeeId) The user with ID followerId start
//ed following the user with ID followeeId. 
// void unfollow(int followerId, int followeeId) The user with ID followerId sta
//rted unfollowing the user with ID followeeId. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", 
//"unfollow", "getNewsFeed"]
//[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
//Output
//[null, null, [5], null, null, [6, 5], null, [5]]
//
//Explanation
//Twitter twitter = new Twitter();
//twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
//twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 twe
//et id -> [5]. return [5]
//twitter.follow(1, 2);    // User 1 follows user 2.
//twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
//twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 twe
//et ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted afte
//r tweet id 5.
//twitter.unfollow(1, 2);  // User 1 unfollows user 2.
//twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 twe
//et id -> [5], since user 1 is no longer following user 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= userId, followerId, followeeId <= 500 
// 0 <= tweetId <= 104 
// All the tweets have unique IDs. 
// At most 3 * 104 calls will be made to postTweet, getNewsFeed, follow, and unf
//ollow. 
// 
// Related Topics Hash Table Linked List Design Heap (Priority Queue) 
// 👍 1986 👎 275


//leetcode submit region begin(Prohibit modification and deletion)
class Twitter {

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
    }
    
    public void follow(int followerId, int followeeId) {
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        
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
//leetcode submit region end(Prohibit modification and deletion)
