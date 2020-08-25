class Solution {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0){
            int curr = x % 10;
            x /= 10;
            if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MIN_VALUE / 10 && curr > 7){ // ans = ans * 10 + curr > Integer.MAX_VALUE
                return 0;
            }
            
            if (ans < Integer.MIN_VALUE/ 10 || ans == Integer.MIN_VALUE / 10 && curr < -8){// ans = ans * 10 + curr > Integer.MAX_VALUE
                return 0;
            }
            ans = ans * 10 + curr;
        }
        return ans;
    }
}
