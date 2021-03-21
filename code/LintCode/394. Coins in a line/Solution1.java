
// O(n), O(n) -> O(1)   滚动数组
class Solution1{
	public int coinsInALine(int n){
	// 1. 如果取1个或2个石子后，能让剩下的局面先手必败，则当前先手必胜
	// 如果不管怎么走，剩下的局面都是先手必胜，则当前先手必败

	// 宗旨： 必胜：在当下的局面走出一步，让对手无路可逃
	// 必败：让自己无路可逃

	// subproblem: 要求面对N个石子，是否先手必胜
	// 需要知道面对N-1和N-2 个石子，是否先手必胜

	// 2. f[i] = (f[i-1] == false || f[i-2] == false)
	// 3. f[0] = false, f[1] = f[2] = true
		if (n == 0){
			return false;
		}

		if (n == 1){
			return true;
		}


		boolean[] f = new boolean[n+1];
		f[0] = false;
		f[1] = true;
		f[2] = true;
		for (int i = 3; i <= n; i++){
			f[i] = (!f[i-1] || !f[i-2]);
		}

		return f[n];
	}

}
