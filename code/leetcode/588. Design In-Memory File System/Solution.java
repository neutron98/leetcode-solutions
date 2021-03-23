class FileSystem {
    private static class Node{
        boolean isFile = false;  // true for file
        // files in the path
        Map<String, Node> files = new HashMap<>();
        String content = "";  // empty when is a directory
        
    }
    private Node root;
    public FileSystem() {
        this.root = new Node();
    }
    
    /**
    Return a list that contains all file names in the dir
    or the list of the file name
    */
    public List<String> ls(String path) {
        Node p = root;
        List<String> result = new ArrayList<>();
        
        if (!path.equals("/")){ // not root
            String[] dirs = path.split("/");
            for (int i = 1; i < dirs.length; i++){
                p = p.files.get(dirs[i]);
            }
            if (p.isFile){ // if this is a file node
                result.add(dirs[dirs.length - 1]);
                return result;
            }
        }
        // otherwise this is a directory
        result.addAll(p.files.keySet());
        Collections.sort(result);
        return result;
    }
    
    public void mkdir(String path) {
        Node p = root;
        String[] dirs = path.split("/");
        
        for (int i = 1; i < dirs.length; i++){
            if (!p.files.containsKey(dirs[i])){
                p.files.put(dirs[i], new Node());
            }
            p = p.files.get(dirs[i]);
        }
    }
    
    // we assume the parent directories are present
    public void addContentToFile(String filePath, String content) {
        Node p = root;
        String[] dirs = filePath.split("/");
        // traverse the parent directories
        for (int i = 1; i < dirs.length - 1; i++) {
            p = p.files.get(dirs[i]);
        }
        // eg: "/a/b/c/d". we are now at Node {c}. we add node d if it does not exist
        if (!p.files.containsKey(dirs[dirs.length - 1])){
            p.files.put(dirs[dirs.length - 1], new Node());
        }
        p = p.files.get(dirs[dirs.length - 1]);
        p.isFile = true;
        p.content = p.content + content;
    }
    
    public String readContentFromFile(String filePath) {
        Node p = root;
        String[] dirs = filePath.split("/");
        for (int i = 1; i < dirs.length; i++){
            p = p.files.get(dirs[i]);
        }
        return p.content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
