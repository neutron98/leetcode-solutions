// O(n), O(1)
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int num = 1;
        /**
            2   3   4   7   11
                            i
        
        
        num: 9
        
        count:5
        */
        int count = 0;
        int i = 0;
        while (i < arr.length){    
            if (num < arr[i]){
                count++;
                if (count == k){
                    break;
                }
                
            } else{
                i++;
            }
            num++;
        }
        
        if (count < k){
            num = (k - count) + arr[arr.length - 1];
        }
        return num;
    }
}
