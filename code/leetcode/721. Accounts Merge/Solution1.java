class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> emailToNeighbor = new HashMap<>();  //<email node, neighbor nodes>
        Map<String, String> emailToOwner = new HashMap<>();        //<email, username>
        
         // Build the emailToNeighbor and emailToOwner graph
        for (List<String> account : accounts) {
            String userName = account.get(0);
            Set<String> neighbors = new HashSet<>(account);
            neighbors.remove(userName);
        
              for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToNeighbor.containsKey(email)) {
                    emailToNeighbor.put(email, new HashSet<>());
                }
                emailToNeighbor.get(email).addAll(neighbors);
                emailToOwner.put(email, userName);
            }
        }
        
        Set<String> visited = new HashSet<>();
        List<List<String>> results = new ArrayList<>();
        
        // dfs the graph, using email as unique key
        
        for (String email: emailToOwner.keySet()){
            if (visited.contains(email)){
                continue;
            }
            List<String> userResult = new ArrayList<>();
            dfs(email, emailToNeighbor, visited, userResult);
            Collections.sort(userResult); // sort before adding user name
            userResult.add(0, emailToOwner.get(email));
            
            results.add(userResult);
        }
        
        return results;
    }
    
    private void dfs(String email, Map<String, Set<String>> emailToNeighbor, 
                     Set<String> visited, List<String> userResult){
        
        userResult.add(email);
        visited.add(email);
        
        for (String neighbor: emailToNeighbor.get(email)){
            if (!visited.contains(neighbor)){
                dfs(neighbor, emailToNeighbor, visited, userResult);
            }
        }
        
    }
}
