**1. Backpack I** [IDE](https://www.lintcode.com/problem/backpack/description)

有 n 个物品和一个大小为 m 的背包.每个物品只能取一次. 第 i 个物品的体积为 A[i].

问最多能装多满？

	样例
	
		样例 1:
			输入:  [3,4,8,5], backpack size=10
			输出:  9
			
		样例 2:
			输入:  [2,3,5,7], backpack size=12
			输出:  12
	
**2. Backpack II（01背包）** [IDE](https://www.lintcode.com/problem/backpack-ii/description)

有 n 个物品和一个大小为 m 的背包. 每个物品只能取一次. 第 i 个物品的体积为 A\[i], *价值为 V[i]*.

问可以装入背包的最大价值是多少?

	样例
	
		样例 1:
		输入: m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4]
		输出: 9
		解释: 装入 A[1] 和 A[3] 可以得到最大价值, V[1] + V[3] = 9 
		
		样例 2:
		输入: m = 10, A = [2, 3, 8], V = [2, 5, 8]
		输出: 10
		



**3. Backpack III**    [IDE](https://www.lintcode.com/problem/backpack-iii/description)

有 n 个物品和一个大小为 m 的背包.每种物品都有*无限个*. 第 i 个物品的体积为 A[i], 价值为 V[i].

问可以装入背包的最大价值是多少?


	样例
		样例 1:
		输入: A = [2, 3, 5, 7], V = [1, 5, 2, 4], m = 10
		输出: 15
		解释: 装入三个物品 1 (A[1] = 3, V[1] = 5), 总价值 15.
		
		样例 2:
		输入: A = [1, 2, 3], V = [1, 2, 3], m = 5
		输出: 5
		
		解释: 策略不唯一. 比如, 装入五个物品 0 (A[0] = 1, V[0] = 1).

**4. Backpack V** [IDE](https://www.lintcode.com/problem/backpack-v/description)

给出 n 个物品, 以及一个数组, nums[i] 代表第i个物品的大小, 保证大小均为正数, 正整数 target 表示背包的大小。*每一个物品只能使用一次*。

找到能*填满*背包的方案数。

	样例
		给出候选物品集合 [1,2,3,3,7] 以及 target 7

		结果的集合为:
		[7]
		[1,3,3]
		
		返回 2


**5. Backpack VI(Combination Sum)** [IDE](https://www.lintcode.com/problem/combination-sum-iv/description)

给出一个都是正整数的数组 nums，其中没有重复的数。

从中找出所有的和为 target 的组合个数。

注意事项：

- 一个数可以在组合中出现多次。

- 数的顺序不同则会被认为是不同的组合。

	样例
		样例1

		输入: nums = [1, 2, 4] 和 target = 4
		输出: 6
		解释:
		可能的所有组合有：
		[1, 1, 1, 1]
		[1, 1, 2]
		[1, 2, 1]
		[2, 1, 1]
		[2, 2]
		[4]
		
		样例2

		输入: nums = [1, 2] 和 target = 4
		输出: 5
		解释:
		可能的所有组合有：
		[1, 1, 1, 1]
		[1, 1, 2]
		[1, 2, 1]
		[2, 1, 1]
		[2, 2]
