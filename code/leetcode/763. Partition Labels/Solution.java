class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        int n = S.length();
        for (int i = 0; i < n; i++){
            int key = S.charAt(i) - 'a';
            lastIndex[key] = i;
        }
        List<Integer> results = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++){
            int key = S.charAt(i) - 'a';  // key for current character
            end = Math.max(end, lastIndex[key]);   // extend the key
            if (i == end){   // if i reaches the end of the partition
                results.add(end - start + 1);  // add the length
                start = end + 1;
            }
        }
        
        return results;
    }
}
