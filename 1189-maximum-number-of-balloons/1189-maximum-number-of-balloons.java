class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        Set<Character> set = new HashSet<>(Arrays.asList('b', 'a', 'n'));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey().equals('l')) {
                list.add(map.get('l') / 2);
            } else if (entry.getKey().equals('o')) {
                list.add(map.get('o') / 2);
            } else if (set.contains(entry.getKey())) {
                list.add(entry.getValue());
            }
        }
        Collections.sort(list);
        if (list.size() < 5) {
            return 0;
        }
        return list.get(0);
    }
}