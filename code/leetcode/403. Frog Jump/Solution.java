class Solution {
    /***
    f[i][k]: if the frog can reach end from stone in pos {i}, when last jump from some index to {i} is {k} unit
    
    d[0][0] = 0
    
    if i == n - 1 : return true
    f[i][k] = f[i+k+1][k+1] || f[i+k-1][k-1] || f[i+k][k]
    
    
    ***/
    Set<Integer> stoneSet = new HashSet<>();
    Map<Pair<Integer, Integer>, Boolean> stateMap = new HashMap<>();
    
    public boolean canCross(int[] stones) {
        for (int stone: stones){
            stoneSet.add(stone);
        }
        return dfs(stones, 0, 0);
    }
    
    private boolean dfs(int[] stones, int pos, int lastJump){
        if (pos == stones[stones.length - 1]){
            return true;
        }
        
        if (!stoneSet.contains(pos)){
            return false;
        }
        
        Pair<Integer, Integer> pair = new Pair<>(pos, lastJump);
        if (stateMap.containsKey(pair)){
            return stateMap.get(pair);
        }
        
        boolean canReach = false;
        if (lastJump > 1 && dfs(stones, pos + lastJump - 1, lastJump - 1)){
            canReach = true;
        }
        if (lastJump > 0 && dfs(stones, pos + lastJump, lastJump)){
            canReach = true;
        }
        if (dfs(stones, pos + lastJump + 1, lastJump + 1)){
            canReach = true;
        }
        
        stateMap.put(pair, canReach);
        return canReach;
    }
}
