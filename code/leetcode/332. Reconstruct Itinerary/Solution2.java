class Solution {
    /***
    Backtracking.
    the itinerary must begin with "JFK"
    Time: O(V * nlogn)  where n is avg num of flights, n = (E/V) on average
    so time is O(V * E/V * log(E/V)) = O(E*log(E/V))
    // space is O(V) + O(V * E/V) = O(E+V)
    add to result only when we can go back to JFK
    
    graph: start -> [dest1, dest 2...]
    
    dfs:
    start with JFK, goto each dest and construct the path as a string
    if can use up, return true and copy the path to result
    
    ***/
    int flights;
    List<String> result;
    public List<String> findItinerary(List<List<String>> tickets) {
        // Tickets
        Map<String, List<String>> graph = new HashMap<>();
        // If a ticket is used
        HashMap<String, boolean[]> visitBitmap = new HashMap<>();
        flights = tickets.size();        
        for (List<String> ticket: tickets){
            String start = ticket.get(0);
            String end = ticket.get(1);
            if (!graph.containsKey(start)){
                graph.put(start, new ArrayList<>());
                
            }
            graph.get(start).add(end);
        }

        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
          Collections.sort(entry.getValue());
          visitBitmap.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }
        
        result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add("JFK");
        dfs(graph, "JFK", path, visitBitmap);
        return result;
    }
    
    /***
    Traverse all destinations from "start" airport, add destination path. copy path to result when this path can use up all tickets.
    @param graph        The graph.
    @param curr         Current start airport.
    @param path         The path.
    @param visitBitmap  Whether it was visited from curr.
    @returns true if this can use up all tickets.
    ***/
    private boolean dfs(Map<String, List<String>> graph, String curr, List<String> path, HashMap<String, boolean[]> visitBitmap){
        if (path.size() == flights + 1){
            result = new ArrayList<>(path);
            return true;
        }
        boolean[] visited = visitBitmap.get(curr);
        
        if (!graph.containsKey(curr)){
            return false;
        }
        
        List<String> nextStations = graph.get(curr);
        for (int i = 0; i < nextStations.size(); i++){
            String next = nextStations.get(i);
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            path.add(next);
            boolean validPath = dfs(graph, next, path, visitBitmap);
            path.remove(path.size() - 1);
            visited[i] = false;

            if (validPath){
                return true;
            }
        }
        return false;
    }
}
