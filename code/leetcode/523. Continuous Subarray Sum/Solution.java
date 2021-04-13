class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        
        /**
        
        S[i] : accumulative sum of nums[0: n)      => O(N)
        target: find i, j (j > i) such that sum(nums[i:j]) % k == 0 -> (S[j] - S[i]) % k == 0


        discompose the sums:
        S[j] = a * k + b    (0 <= b < k)
        S[i] = c * k + d    (0 <= d < k)
        
        S[j] - S[i] -> (a - c) * k + (b - d)
        
        S[j] - S[i] is a multiple of k if b == d
        
        cache the remainders of accumulative sums     => O(N)
        R[i] = S[i] % k
        
        traverse the array, sum(nums[i:j])  is a multiple of k if this remainder appears before -> if R[j] == R[i]      
        also make sure (j - i) > 1
        
        R is a map. key: remainder, value: index
        
        => O(N)
        
        */
        
        int sum = 0;
        Map<Integer, Integer> remainders = new HashMap<>();
        remainders.put(0, -1);
        
        
        for (int i = 0; i < n; i++){
            sum += nums[i];
            int r = sum % k;
            if (remainders.containsKey(r)){ // if this remainder appears before
                // check the length
                if (i - remainders.get(r) > 1){
                    return true;
                }
            } else{ // greedy: update the index only if this remainder did not appear before, ensure the length is long enough
                remainders.put(r, i);
            }
            
        }
        
        return false;
        
    }
}
