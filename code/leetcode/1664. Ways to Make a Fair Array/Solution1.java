class Solution {
  // O(n), O(n)
    public int waysToMakeFair(int[] nums) {
        // remove a value: even -> odd, odd -> even
        int n = nums.length;
        if (n == 1){
            return 1;
        }
        
        // leftOdd[i-1] + rightEven[i+1] == leftEven[i-1] + rightOdd[i+1]
        
        // prefix sum
        int[] leftOdd = new int[n];
        int[] leftEven = new int[n];
                
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < n; i++){
            if (i % 2 == 0){
                evenSum += nums[i];
            } else{
                oddSum += nums[i];
            }
            leftOdd[i] = oddSum;
            leftEven[i] = evenSum;
        }
        
        // suffix sum
        int[] rightOdd = new int[n];
        int[] rightEven = new int[n];
        evenSum = 0;
        oddSum = 0;
        for (int i = n - 1; i >= 0; i--){
            if (i % 2 == 0){
                evenSum += nums[i];
            } else{
                oddSum += nums[i];
            }
            rightOdd[i] = oddSum;
            rightEven[i] = evenSum;
        }

        // original odd sum -> even sum
        // original even sum -> odd sum
        // remove at even index: original even sum(curr Odd sum) -= nums[i]
        // remove at odd index: original odd sum(curr Even sum) -= nums[i]
        
        /**
        
        Even sum: 2 + 6 = 8. odd sum: 1 + 4 = 5
        
        remove at index 1: currOddSum = 8 - 1 = 7. currEvenSum = 
        */
        int count = 0;
        for (int i = 0; i < n; i++){
            
            if (i == 0){
                if (rightEven[i + 1] == rightOdd[i + 1]){
                    count++; 
                }
            } else if (i == n - 1){
                if (leftOdd[i - 1] == leftEven[i - 1]){
                    count++;
                }
            } else if (leftOdd[i - 1] + rightEven[i + 1] == leftEven[i - 1] + rightOdd[i + 1]){
                count++;
            }
        }
        
        return count;
    }
}
