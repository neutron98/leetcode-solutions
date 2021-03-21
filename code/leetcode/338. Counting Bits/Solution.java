class Solution {
    public int[] countBits(int num) {
        // f[i] = f[i>>1] + (i % 2)
        
        int[] f = new int[num+1];// 因为要输出0 - num
        f[0] = 0;
        
        for (int i = 1; i <= num; i++){
            f[i] = f[i>>1] + (i & 1);
        }
        
        return f;
    }
}
