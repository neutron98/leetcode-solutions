//https://www.lintcode.com/problem/copy-books/description


// 时间： O(N^2 * K), 空间
// 优化了A[j] + ... A[i-1]的计算
class Solution{
	public int copyBooks(int[] A, int K){
		// 1. 最后一步： 最后一个抄写员Bob(第K个）抄写的部分（一段连续的书）
		// 如果抄写第j到第N-1本书，则它需要时间A[j] + ... + A[N-1]

		//需要知道前面K-1个人最少需要多少时间抄完第0~j-1本书
		//这样知道前面是瓶颈还是Bob是瓶颈

		//有什么用？假设前面K-1个人不是瓶颈，那么前面K-1个人抄的时间阅越短，结果肯定不会差

		// 那么干脆一刀切


		// 2. transition function
		// f[k][i]: min time that first {K} copiers need to copu first {i} books

		// f[k][i] = min{max{f[k-1][j], A[j] + ... A[i-1]}}   | j = 0, .. i
		// 前k个，前i本书      前k-1个，前j本书       第k个Bob 抄j到i-1（i-j)本书

		// max 是木桶原理，找到慢的是谁
		// min是最小化这个最慢的时间


		// 3. 初始化：每个维度都0


		// 4. 顺序： [0][0], [0][1]...[0][N]
		// [n][0], ...

		//如果K>N, 可以赋值K=N(人比书多，有的人不用干事)

		int n = A.length;

		if (n == 0){
			return 0;
		}

		if (K > n){
			K = n;
		}

		int[][] f = new int[K + 1][n + 1];

		f[0][0] = 0;
		for (int i = 1; i <= n; i++){
			f[0][i] = Integer.MAX_VALUE;   // 0个人抄正数本书是正无穷，表示抄不了
		}

		for (int k = 1; k <= K; k++){
			f[k][0] = 0; // 前k个人抄0本书是0
			for (int i = 0; i <= n; i++){
				f[k][i] = Integer.MAX_VALUE;
				int sum = 0;
				for (int j = i; j >= 0; j--){
					// sum = A[j] + ... + A[i-1]  j从后向前可以优化时间
		// f[k][i] = min{max{f[k-1][j], A[j] + ... A[i-1]}}   | j = 0, .. i

					f[k][i] = Math.min(f[k][i], Math.max(f[k-1][j], sum));
					if (j > 0){
						sum += A[j - 1];  // 注意这个index，因为是从i-1加到j
					}
				}
			}
		}

		return f[K][n];
	}

}
