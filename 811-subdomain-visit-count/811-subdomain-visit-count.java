class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> output = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] sub = domain.split("\\s+");
            int visits = Integer.parseInt(sub[0]);
            String address = sub[1];
            // map.put(address, visits);
            String[] parts = address.split("\\.");
            
            String curr = "";
            for (int i = parts.length - 1; i >= 0; --i) {
                curr = parts[i] + (i < parts.length - 1 ? "." : "") + curr;
                map.put(curr, map.getOrDefault(curr, 0) + visits);
            }
            
            
            // if (parts.length == 2) {
            //     map.put(parts[1], map.getOrDefault(parts[1], 0) + visits);
            // } else if (parts.length == 3) {
            //     String second = parts[1] + "." + parts[2];
            //     map.put(second, map.getOrDefault(second, 0) + visits);
            //     map.put(parts[2], map.getOrDefault(parts[2], 0) + visits);
            // }
        }
        
        for (Map.Entry<String,Integer> e : map.entrySet()) {
            String domain = e.getKey();
            int visits = e.getValue();
            String ans = visits + " " + domain;
            output.add(ans);
        }
        
        return output;
    }
}