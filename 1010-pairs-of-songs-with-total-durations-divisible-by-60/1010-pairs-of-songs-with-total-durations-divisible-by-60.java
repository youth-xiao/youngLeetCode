class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : time) {
            int rem = i % 60;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        
        long pairs = 0;
        
        for (int rem : map.keySet()) {
            if (rem > 30) continue;
            else if (rem == 30 || rem == 0) {
                long size = map.get(rem);
                pairs += size * (size - 1) / 2;
            } else {
                pairs += map.get(rem) * map.getOrDefault(60 - rem, 0);
            }
        }
        
        return (int) pairs;
    }
}

// class Solution {
//     public int numPairsDivisibleBy60(int[] time) {
//         Map<Integer, List<Integer>> map = new HashMap<>();
//         for (int i = 0; i < time.length; i++) {
//             int num = time[i];
//             if (!map.containsKey(num)) {
//                 map.put(num, new ArrayList<>());
//             }
//             map.get(num).add(i);
//         }

//         int pairs = 0;
//         Set<Integer> keyList = map.keySet();
//         Set<Set<Integer>> visited = new HashSet<>();
//         for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
//             int num = e.getKey();
//             int rem = 60 - num;
//             // find any number p, such that p % 60 == rem
//             for (int p : keyList) {
//                 Set<Integer> set = new HashSet<>(List.of(p, num));
//                 if (p % 60 == rem && !visited.contains(set)) {
//                     if (p != num) {
//                         pairs += map.get(p).size() * map.get(num).size();
//                     } else {
//                         if (map.get(p).size() > 1) {
//                             pairs += (map.get(p).size() - 1) * map.get(p).size() / 2;
//                         }
//                     }
//                     visited.add(set);
//                 }
//             }
//         }
//         return pairs;
//     }
// }