class Solution {
    // DFS + Memorization
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        int n = queries.size();
        double[] results = new double[n];
        
        
        // dfs
        // start from the num, stop until find the denom
        // problem: redundency
        
        // ["a","b"],["b","c"], ["c", "d"]
        
        // calc("a", "c")
        // calc("a", "d")
        
        // solution: use a cache  -> Map key: equation, value: value. 
        // O(E): num of edges
        // O(V): num of nodes
        // O(E + V)    
        
        
        HashMap<String, HashMap<String, Double>> cache = new HashMap<>();    // a-b -> [2.0]
        
        // build cache

        
        for (int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);
            String num = equation.get(0);
            String denom = equation.get(1);
            
            if (!cache.containsKey(num)){
                cache.put(num, new HashMap<String, Double>());
            }
            if (!cache.containsKey(denom)){
                cache.put(denom, new HashMap<String, Double>());
            }
            cache.get(num).put(denom, values[i]);
            cache.get(denom).put(num, 1.0 / values[i]);

        }
        
        for (int i = 0; i < n; i++){
            List<String> query = queries.get(i);
            String num = query.get(0);
            String denom = query.get(1);
            // if this var never appeared before. return -1.0 
            if (!cache.containsKey(num) || !cache.containsKey(denom)){
                results[i] = -1.0;
            } else{
                results[i] = dfs(num, denom, cache, new HashSet<>());
            }
            
        }
        
        return results;
    }
    /**
    do dfs to calculate result
    @param num          numerator
    @param denom        denominator
    @param cache        map of equation -> value
    @param visited      visited nodes in current search. used to avoid cycles such as a->b->a
    
    @return value of num/denom. if cannot calculate, return -1.0
    */
    private double dfs(String num, String denom, 
                       HashMap<String, HashMap<String, Double>> cache, Set<String> visited){
        // if we have in cache, return
        visited.add(num);
        
        if (num.equals(denom)){
            return 1.0;
        }
        
        if (cache.containsKey(num) && cache.get(num).containsKey(denom)){
            return cache.get(num).get(denom);
        }
        
        if (cache.containsKey(denom) && cache.get(denom).containsKey(num)){
            return 1.0 / cache.get(denom).get(num);
        }
        double result = -1.0;
        for (String nextNum: cache.get(num).keySet()){
            if (visited.contains(nextNum)){
                continue;
            }
            double eval1 = dfs(num, nextNum, cache, visited);
            double eval2 = dfs(nextNum, denom, cache, visited);
          
            if (eval2 != -1.0){  // case: equations = [["a","b"],["c","d"]]. calc(a, c)  should return -1 because cannot go b->c
                result = eval1 * eval2;
                //cache.get(num).put(denom, result);
                //cache.get(denom).put(num, 1.0 / result);
                return result;
            }
            
        }
        
        return -1.0;
    }
}
