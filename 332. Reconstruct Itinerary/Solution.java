class Solution {
    // postorder DFS
    //  before adding the last airport (vertex) in the final path, we have visited all its outgoing vertex.
    public List<String> findItinerary(List<List<String>> tickets) {
        // the itinerary must begin with "JFK"
        // O(V * nlogn)  where n is avg num of flights ..
        // for each itenary, we have n flights, so we do insert n times for every iternary
        // n = E/2 in worst case, when JFK is the only departure (E flights in total, JFK has all, others has none)
        // n = (E/V) on average
        // so in total is O(V * E/V * log(E/V)) = O(E*log(E/V))
        // space is O(E+V)
        
        Map<String, PriorityQueue<String>> graph = new HashMap<>();  // depart -> pq<dest>    
        // If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order
        
        for (List<String> pair: tickets){
            String depart = pair.get(0);
            String dest = pair.get(1);
            
            if (!graph.containsKey(depart)){
                graph.put(depart, new PriorityQueue<String>((s1, s2) -> s1.compareTo(s2)));
            }

            graph.get(depart).add(dest);
        }
        
        /*
        JFK 0
        MUC 1
        LHR 1
        SFO 1
        SJC 1
        
        
        JFK 1
        ATL 1
        SFO 1
        
        */
        
        
        List<String> results = new LinkedList<>();
        
        dfs("JFK", graph, results);
        return results;
    }
    // O(E)
    private void dfs(String curr, 
                     Map<String, PriorityQueue<String>> graph, List<String> results){
        
        
        PriorityQueue<String> nextStations = graph.get(curr);
        while (nextStations != null && !nextStations.isEmpty()){
            String next = nextStations.poll();
            dfs(next, graph, results);
        }
        results.add(0, curr);
    }
}
