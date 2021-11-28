class Solution {
    private int target;
    private int[][] graph;
    private List<List<Integer>> results;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.target = graph.length - 1;
        this.graph = graph;
        this.results = new ArrayList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        path.addLast(0);
        this.backtrack(0, path);
        return this.results;
    }
    
    protected void backtrack(int currNode, LinkedList<Integer> path) {
        if (currNode == this.target) {
            this.results.add(new ArrayList<Integer>(path));
            return;
        }
        for (int nextNode : this.graph[currNode]) {
            path.addLast(nextNode);
            this.backtrack(nextNode, path);
            path.removeLast();
        }
    }
}