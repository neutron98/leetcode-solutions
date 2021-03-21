class Solution {
    public int lengthOfLongestSubstring(String s) {
        int totalNumDist = 0;
        boolean[] hasChar = new boolean[25];
        for (int i = 0; i < s.length(); i++){
            int charVal = s.charAt(i) - 'a';
            if (!hasChar[charVal]){
                hasChar[charVal] = true;
                totalNumDist++;
            }
        }
        
        int[] charFreq = new int[25];
        int l = 0, r;
        int minLen = Math.MAX_VALUE;
        int currDist = 0;
        for (r = 0; r < s.length(); r++){
            int rightCharVal = s.charAt(r) - 'a';
            charFreq[rightCharVal]++;
            if (charFreq[rightCharVal] == 1){
                currDist++;
            }
            
            if (currDist == totalNumDist){
                while (charFreq[s.charAt(l) - 'a'] > 1){
                    if (charFreq[s.charAt(l) - 'a'] > 1){
                        charFreq[s.charAt(l) - 'a']--;
                    }
                    l++;
                }
            }
            minLen = Math.min(minLen, r - l + 1);
        }
        
        return minLen;
    }
}
