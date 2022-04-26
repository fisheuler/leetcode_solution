package interview.design.TinyUrl.random;//Note: This is a companion problem to the System Design problem: Design TinyURL
//. 
//
// TinyURL is a URL shortening service where you enter a URL such as https://lee
//tcode.com/problems/design-tinyurl and it returns a short URL such as http://tiny
//url.com/4e9iAk. Design a class to encode a URL and decode a tiny URL. 
//
// There is no restriction on how your encode/decode algorithm should work. You 
//just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can
// be decoded to the original URL. 
//
// Implement the Solution class: 
//
// 
// Solution() Initializes the object of the system. 
// String encode(String longUrl) Returns a tiny URL for the given longUrl. 
// String decode(String shortUrl) Returns the original long URL for the given sh
//ortUrl. It is guaranteed that the given shortUrl was encoded by the same object.
// 
// 
//
// 
// Example 1: 
//
// 
//Input: url = "https://leetcode.com/problems/design-tinyurl"
//Output: "https://leetcode.com/problems/design-tinyurl"
//
//Explanation:
//Solution obj = new Solution();
//string tiny = obj.encode(url); // returns the encoded tiny url.
//string ans = obj.decode(tiny); // returns the original url after deconding it.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= url.length <= 104 
// url is guranteed to be a valid URL. 
// 
// Related Topics Hash Table String Design Hash Function 
// 👍 1393 👎 2682


import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

//leetcode submit region begin(Prohibit modification and deletion)
class Codec_535 {

    HashMap<String, String> tiny2OriginalMap = new HashMap<>();
    HashMap<String, String> original2TinyMap = new HashMap<>();
    AtomicLong atomicLong = new AtomicLong(0);
    String tinyPreix = "https://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (original2TinyMap.containsKey(longUrl)) {
            return original2TinyMap.get(longUrl);
        }

        String tiny = tinyPreix + String.valueOf(atomicLong.getAndIncrement());

        tiny2OriginalMap.put(tiny, longUrl);
        original2TinyMap.put(longUrl, tiny);

        return tiny;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tiny2OriginalMap.getOrDefault(shortUrl, "");
    }

    public static  String generateRandomShortUrl()
    {
        final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++)
        {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, BASE62.length());
            sb.append(BASE62.charAt(randomIndex));
        }
        return sb.toString();
    }


    public static void main(String[] args){
        HashSet<String> urlSets = new HashSet<>(40000000);

        long allStart = System.currentTimeMillis();
        int collision = 0;
        int i = 0;
        long start = System.currentTimeMillis();
        while(i<30000000){
            String url = generateRandomShortUrl();
            if(urlSets.contains(url)){
                collision++;
            }
            urlSets.add(url);
            i++;
            if(i%1000000==0){
                long end = System.currentTimeMillis();
                System.out.println(i + "iteration: size:"+i+ " consume time :"+(end-start) + " collision :"+collision);
                System.out.println(i + "iteration: collision percent " +((double)collision/(double)i)*(double)100);
                start=end;
            }

        }
        long end = System.currentTimeMillis();

        System.out.println("all consume:"+(end-allStart));
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
//leetcode submit region end(Prohibit modification and deletion)
