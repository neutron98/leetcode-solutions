1. Minimum Size Subarray Sum >= k
Shrink窗口的条件:>=target
更新窗口在循环内部.

因为是at least,只要满足就赶紧存档

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r;
        int minLen = Integer.MAX_VALUE;
        */
        int sum = 0;
        for (r = 0; r < nums.length; r++){
            sum += nums[r];
            while (sum >= target && l <= r){
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l++];
            }
            
        }
        if (minLen == Integer.MAX_VALUE){
            return 0;
        }
        
        return minLen;
    }
}
```

2. Longest Substring with At Most K Distinct Characters

Shrink窗口的条件window size > k
更新窗口在循环外部

因为是at most,先超过了,减到不超过再更新

```java
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        
        int l = 0, r;
        int maxLen = 0;
        
        char[] arr = s.toCharArray();
        
        for (r = 0; r < arr.length; r++){
            freq.put(arr[r], freq.getOrDefault(arr[r], 0) + 1);
            
            while (freq.size() > k){
                freq.put(arr[l], freq.get(arr[l]) - 1);
                if (freq.get(arr[l]) == 0){
                    freq.remove(arr[l]);
                }
                l++;
            }
            
            maxLen = Math.max(maxLen, r - l + 1);
        }
        
        return maxLen;
    }
}
```

**3. Longest Substring Without Repeating Characters**

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
        
        a   b   c   a   b   c   b   b
                    l
        
                            r
        
        
        map  <char : lastIndex> 
        a : 3
        b : 4
        c : 2
        
        
        */
        
        Map<Character, Integer> indexMap = new HashMap<>();
        int maxLen = 0;
        int l = 0, r;
        
        char[] arr = s.toCharArray();
        for (r = 0; r < arr.length; r++){
            
            if (indexMap.containsKey(arr[r])){
                l = Math.max(l, indexMap.get(arr[r]) + 1);
            }
            indexMap.put(arr[r],  r);
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
```
