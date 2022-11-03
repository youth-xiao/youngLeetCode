class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (bank.length == 0) return -1;
        Set<String> bankSet = new HashSet<>();
        for (String mutation : bank) {
            bankSet.add(mutation);
        }
        if (!bankSet.contains(end)) return -1;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        
        int count = 0;
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                String gene = queue.poll();
                if (changeOneNucleotide(gene, end, queue, bankSet, visited)) {
                    return count + 1;
                } 
            }
            count++;
        }
        
        return -1;
    }
    
    private boolean changeOneNucleotide(String currGene, String end, Queue<String> queue, Set<String> bankSet, Set<String> visited) {        
        char[] nucleotides = new char[] {'A', 'C', 'G', 'T'};
        char[] geneArray = currGene.toCharArray();
        for (int i = 0; i < geneArray.length; i++) {
            char ch = geneArray[i];
            for (int j = 0; j < nucleotides.length; j++) {
                char curr = nucleotides[j];
                if (ch == curr) continue;
                geneArray[i] = nucleotides[j];
                String resultGene = String.valueOf(geneArray);
                if (bankSet.contains(resultGene)) {
                    if (resultGene.equals(end)) {
                        return true;
                    }
                    if (!visited.contains(resultGene)) {
                        queue.add(resultGene);
                        visited.add(resultGene);
                    }
                }
            }
            geneArray[i] = ch;
        }
        return false;
    }
}