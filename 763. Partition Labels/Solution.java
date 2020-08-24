// O(n)
// 27
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[27];
        for (int i = 0; i < S.length(); i++){
            int pos = S.charAt(i) - 'a' + 1;
            lastIndex[pos] = i;
        }
        List<Integer> results = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++){
            int pos = S.charAt(i) - 'a' + 1;
            end = Math.max(end, lastIndex[pos]);
            if (i == end){
                results.add(end - start + 1);
                start = end + 1;
            }
        }
        
        return results;
    }
}
