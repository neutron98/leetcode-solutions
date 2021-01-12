// O(N), O(1)
class Solution {
    public int[] singleNumber(int[] nums) {
        // get the XOR of the numbers
        int n1xn2 = 0;
        for(int num: nums){
            n1xn2 ^= num;
        }
        // get the rightmost bit that is '1'
        int rightmostOne = 1;
        while ((rightmostOne & n1xn2) == 0){
            rightmostOne <<= 1;
        }
        
        //seperate the two numbers 
        int num1 = 0, num2 = 0;
        for (int num: nums){
            if ((num & rightmostOne) != 0){// the bit is set
                num1 ^= num;
            } else{
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }
}
