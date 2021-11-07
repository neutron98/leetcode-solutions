**动态规划题目特点**
1. 计数
- 有多少种方式走到右下角
- 有多少种方法选出k个数使得和是Sum
2. 求最大值最小值
- 从左上角走到右下角路径的最大数字和
- 最长上升子序列长度
3. 求存在性
- 取石子游戏，先手是否必胜
- 能不能选出k个数使得和是Sum


**解题过程**
1. 确定状态
 - 数组中每个元素f[i]或者f[i][j]代表什么
2. 转移方程
3.初始条件和边界情况
4. 计算顺序


1. 坐标型动态规划
2. 序列型动态规划
3. 划分型动态规划
4. 区间和背包型动态规划
5. 双序列型动态规划


**1. Longest Increasing Subsequence**
转移方程不难，但是别忘了ans是max(dp[i])，而不是dp[n-1]

```java

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}

```
