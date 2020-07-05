// O(n^2), O(n)
// O(nlogn) 方法之后讲
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0){
            return 0;
        }
        // sort by length
        Arrays.sort(envelopes, new Comparator<>(){
            public int compare(int[] a, int[] b){
                if (a[0] == b[0]){
                    return a[1] - b[1];
                } else{
                    return a[0] - b[0];
                }
            }
        });
        
        int n = envelopes.length;
        int[] f= new int[n];
        int res = 0;
        for (int j = 0; j < n; j++){
            f[j] = 1;
            for (int i = 0; i < j; i++){
                if (envelopes[i][0] < envelopes[j][0] && 
                   envelopes[i][1] < envelopes[j][1]){ // length might be equal
                    f[j] = Math.max(f[j], f[i] + 1);
                }
            }
            res = Math.max(f[j], res);
        }
        
        return res;
    }
}
