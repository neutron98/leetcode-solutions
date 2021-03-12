class AutocompleteSystem {

    private static class TrieNode{
        private char c;
        private String word;
        private int time;
        private Map<Character, TrieNode> children;
        TrieNode(){
            this.word = null;
            this.time = 0;
            this.children = new HashMap<>();
        }
        TrieNode(char c){
            this();
            this.c = c;
        }
    }


    private TrieNode root;

    private StringBuilder builder;

    private TrieNode startNode;  // last node where we input
    
    // 注意点： minHeap和startNode都要是class variable
    PriorityQueue<TrieNode> minHeap;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        startNode = root;
        builder = new StringBuilder();
        minHeap = new PriorityQueue<>(new Comparator<TrieNode>(){
            @Override
            public int compare(TrieNode n1, TrieNode n2){
                if (n1.time == n2.time){
                    return n2.word.compareTo(n1.word);
                }
                return Integer.compare(n1.time, n2.time);
            }
        });

        for (int i = 0; i < sentences.length; i++){
            addWord(sentences[i], times[i]);
        }


    }

    public List<String> input(char c) {

        if (c == '#'){
            // case 1: word contained
            if (startNode.word != null){
                startNode.time++;
            } else{
                addWord(builder.toString(), 1);
            }
            builder.setLength(0); // clear input
            startNode = root;  // rest last node
            return new ArrayList<>();
        }

        builder.append(c);
        if (!startNode.children.containsKey(c)){
            startNode.children.put(c, new TrieNode(c));
        }
        startNode = startNode.children.get(c);
        return findWords();
    }

    // Find all words when this node is a root of sub Trie
    private List<String> findWords(){

        findWordsHelper(startNode);
        List<String> words = new LinkedList<>();
        while (!minHeap.isEmpty()){
            words.add(0, minHeap.poll().word);  // TODO: 一定要用poll，不要用for循环！
        }
        return words;

    }

    // helper to find all words, this will update the minHeap
    private void findWordsHelper(TrieNode node){
        if (node == null){
            return;
        }

        if (node.word != null){
            minHeap.offer(node);
            if (minHeap.size() > 3){
                minHeap.poll();
            }
        }

        // dfs
        for (Map.Entry<Character,TrieNode> e: node.children.entrySet()){
            TrieNode child = e.getValue();
            findWordsHelper(child);
        }
    }


    private void addWord(String word, int time){
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (!p.children.containsKey(c)){
                p.children.put(c, new TrieNode());
            }
            p = p.children.get(c);
        }
        p.word = word;
        p.time = time;
    }

}
