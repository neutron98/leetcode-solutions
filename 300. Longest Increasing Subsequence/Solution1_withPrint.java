class Solution {
    public int lengthOfLIS(int[] nums) {
        // last step:
        // (1) {a[j]}
        // (2) ends with a[j]
        
        // prev is a[i], and a[i] < a[j]
        
        // 2. transition function
        // f[j] = Max{1, f[i] + 1}, a[i] < a[j]
        if (nums == null || nums.length == 0){
            return 0;
        }
        // 3. f[0] = 1
        int n = nums.length;
        int res = 1;
        int[] f = new int[n];
        
        int p = 0;
        int[] pi = new int[n];
        for (int j = 0; j < n; j++){
            f[j] = 1;
            pi[j] = -1;
            for (int i = 0; i < j; i++){
                if (nums[i] < nums[j]){
                    f[j] = Math.max(f[j], f[i] + 1);
                    if (f[j] == f[i] + 1){ // if updated
                        pi[j] = i;   // its smaller element is i
                    }
                }
            }
            res = Math.max(res, f[j]);
            if (res == f[j]){ // if updated
                p = j;    // the sequence ends with j 
            }
        }
        
        
        int[] seq = new int[res];
        for (int i = res - 1; i >= 0; i--){
            seq[i] = nums[p];  // find the element using the pointer p
            p = pi[p];  // update p with its previous element 
        }
        for (int i = 0; i < res; i++){
            System.out.print(seq[i] + " ");
        }
        
        return res;
    }
}
