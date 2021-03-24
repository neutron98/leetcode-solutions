class Solution {
    

    Set<Integer> stoneSet = new HashSet<>();
    Map<String, Boolean> stateMap = new HashMap<>();            // pos+$+lastJump
    public boolean canCross(int[] stones) {
        
        for (int pos: stones){
            stoneSet.add(pos);
        }
        return dfs(stones, 0, 0);
    }
    
    private boolean dfs(int[] stones, int pos, int lastJump){

        
        if (pos == stones[stones.length - 1]){  // if reach the last position
            return true;
        }

        String key = pos + "$" + lastJump;

        if (stateMap.containsKey(key)){
            return stateMap.get(key);    
        }
        
        if (!stoneSet.contains(pos)){ // if this is not a stone
            return false;
        }
        
        
        boolean canReach = (lastJump > 0 && dfs(stones, pos + lastJump, lastJump)) 
            || dfs(stones, pos + lastJump + 1, lastJump + 1) 
            || (lastJump > 1 && dfs(stones, pos + lastJump - 1, lastJump - 1));
        
        if (canReach){
            stateMap.put(key, true);
            return true;
        }
        // otherwise failed
        stateMap.put(key, false);
        return false;
    }
}
