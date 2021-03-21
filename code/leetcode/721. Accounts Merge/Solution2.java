// Time complexity: O(N* alpha(N)), where N is the number of emails
// Space complexity: O(N)


class Solution {
       private static class DSU{
        Map<String, String> parent; // will use primary email as the root node of each account
        Map<String, Integer> rank;
        
        DSU(){
            // initialize in find and union because we do not have the key
            parent = new HashMap<>();
            rank = new HashMap<>();
        }
        
        public String find(String x) {
            String px = parent.getOrDefault(x, x);
            if (!px.equals(x)) {
                px = find(px);
            }
            return px;
        }
        
        
        public boolean union(String x, String y){
            String px = find(x), py = find(y);
            if (px.equals(py)){
                return false;
            }
            int rankPX = rank.getOrDefault(px, 0);
            int rankPY = rank.getOrDefault(py, 0);
            if ( rankPX < rankPY){
               // merge px to py
                parent.put(px, py);
                rank.put(py, rankPY + 1);
            } else{
                // merge py to px
                parent.put(py, px);
                rank.put(px, rankPX + 1);
            }
            
            return true;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        if (accounts.isEmpty()){
            return new ArrayList<>();
        }
        
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap<>();
        // union emails, and mapping email to name
        for (List<String> account : accounts) {
            String name = account.get(0);
            String primaryEmail = account.get(1);
            
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                dsu.union(primaryEmail, email);
            }
        }
        
         // key: primary email, value: email list under same account
        Map<String, List<String>> mergedAccounts = new HashMap<>();
        
         for (String email : emailToName.keySet()) { // for each email
            String primaryEmail = dsu.find(email);
             if (mergedAccounts.get(primaryEmail) == null){
                 mergedAccounts.put(primaryEmail, new ArrayList<>());
             }

            mergedAccounts.get(primaryEmail).add(email);
        }
        
        // add to results and sort
        List<List<String>> results = new ArrayList<>(mergedAccounts.size());
        
        for (List<String> emails : mergedAccounts.values()) {
            Collections.sort(emails);
            List<String> account = new ArrayList<>(emails.size() + 1);
            // add name
            account.add(emailToName.get(emails.get(0)));
            // add emails
            account.addAll(emails);
            results.add(account);
        }
        return results;
        
    }
}

