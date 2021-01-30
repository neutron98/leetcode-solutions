class Solution{
	public int backpack(int m, int[] A, int[] V){
		// 1. f[i][w]: max value using first {i} [types] of items to make up {w}
		// 2. f[i][w] = max{f[i - 1][w - k * A[i - 1]] + k * V[i - 1] where w >= k * A[i - 1] && f[i - 1][w - k * A[i - 1]] != -1}
		// problem: k can be from 1 to m. Time complexity will be O(n*m^2)
		// 优化：
		// f[i][5] = max{f[i-1][5], f[i-1][3] + x, f[i-1][1] + 2x}
		// f[i][7] = max{f[i-1][7], f[i-1][5] + x, f[i-1][3] + 2x, f[i-1][1] + 3x}
		// f[i][7] = max{f[i-1][7], f[i][5] + x}
		// 所以：
		// f[i][w] = max{f[i-1][w], f[i][w-A[i-1] + V[i-1]}
		//4. answer: max{f[n][w]}

		int n = A.length;
		if (n == 0){
			return 0;
		}

		int [] f = new int[m + 1];
		f[0] = 0;
		for (int w = 1; w <= m; w++){
			f[w] = -1;
		}
		for (int i = 1; i <= n; i++){
			for (int w = A[i - 1]; w <= m; w++){
				if (f[w - A[i - 1]] != -1){
					f[w] = Math.max(f[w], f[w - A[i - 1] + V[i - 1]);
				}
			}
		}


		int res = 0;
		for (int w = 0; w <= m; w++){
			if (f[w] != -1){
				res = Math.max(res, f[w]);
			}
		}
		return res;
	}

}
