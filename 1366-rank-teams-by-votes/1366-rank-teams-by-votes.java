class Solution {
    public String rankTeams(String[] votes) {
        if (votes.length == 1) return votes[0];
        Map<Character, int[]> map = new HashMap<>();
        int n = votes[0].length();
        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < n; j++) {
                char c = votes[i].charAt(j);
                if (!map.containsKey(c)) {
                    map.put(c, new int[n]);
                }
                map.get(c)[j]++;
            }
        }
        
        // 直接把所有characters提取出来做排序可以更快
        // 不需要用priority queue 去存map.entry
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (map.get(a)[i] != map.get(b)[i]) {
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a - b;
        });
        
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}




// class Solution {
//     public String rankTeams(String[] votes) {
//         if (votes.length == 1) return votes[0];
//         Map<Character, int[]> map = new HashMap<>();
//         int n = votes[0].length();
//         for (int i = 0; i < votes.length; i++) {
//             for (int j = 0; j < n; j++) {
//                 char c = votes[i].charAt(j);
//                 if (!map.containsKey(c)) {
//                     map.put(c, new int[n]);
//                 }
//                 map.get(c)[j]++;
//             }
//         }
        
        
//         PriorityQueue<Map.Entry<Character, int[]>> pq = new PriorityQueue<>(n, new RankComparator());
//         pq.addAll(map.entrySet());
        
//         StringBuilder sb = new StringBuilder();
        
//         while (!pq.isEmpty()) {
//             Map.Entry<Character, int[]> entry = pq.poll();
//             char ch = entry.getKey();
//             sb.append(ch);
//         }
        
//         return sb.toString();
//     }
// }

// class RankComparator implements Comparator<Map.Entry<Character, int[]>> {
//     public int compare(Map.Entry<Character, int[]> e1, Map.Entry<Character, int[]> e2) {
//         int res = 0;
//         int len = e1.getValue().length;
//         int index = 0;
        
//         while (index < len) {
//             int[] v1 = e1.getValue();
//             int[] v2 = e2.getValue();
//             if (v1[index] > v2[index]) {
//                 res = -1;
//                 break;
//             } else if (v1[index] < v2[index]) {
//                 res = 1;
//                 break;
//             } else {
//                 if (index == len - 1) {
//                     char c1 = e1.getKey();
//                     char c2 = e2.getKey();
//                     res = Character.compare(c2, c1);
//                 } else {
//                     index++;
//                 }
//             }
//         }
//         return res;
//     }
// }