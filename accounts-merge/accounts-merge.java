class Solution {
    
    HashSet<String> visited = new HashSet<>();
    Map<String, List<String>> adjacent = new HashMap<>();
    
    private void dfs(List<String> mergedAccount, String email) {
        visited.add(email);
        mergedAccount.add(email);
        if (!adjacent.containsKey(email)) {
            return;
        }
        for (String neighbor : adjacent.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(mergedAccount, neighbor);
            }
        }
    }
        
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int accountsSize = accounts.size();
        for (List<String> account : accounts) {
            int accountSize = account.size();
            String accountFirstEmail = account.get(1);
            for (int j = 2; j < accountSize; j++) {
                String accountEmail = account.get(j);
                if (!adjacent.containsKey(accountFirstEmail)) {
                    adjacent.put(accountFirstEmail, new ArrayList<String>());
                }
                adjacent.get(accountFirstEmail).add(accountEmail);
                if (!adjacent.containsKey(accountEmail)) {
                    adjacent.put(accountEmail, new ArrayList<String>());
                }
                adjacent.get(accountEmail).add(accountFirstEmail);
            }
        }
        
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> account : accounts) {
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);
            if (!visited.contains(accountFirstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                mergedAccount.add(accountName);
                dfs(mergedAccount, accountFirstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }
        return mergedAccounts;
    }
}



// class Solution {
    
//     Map<Integer, Integer> father;
    
//     public List<List<String>> accountsMerge(List<List<String>> accounts) {
//         father = new HashMap<>();
//         Map<String, List> emailToIds = getEmailToIds(accounts);
//         for (String email : emailToIds.keySet()) {
//             List<Integer> ids = emailToIds.get(email);
//             for (int i = 1; i < ids.size(); i++) {
//                 union(ids.get(i), ids.get(0));
//             }
//         }
        
//         Map<Integer, Set<String>> idToEmailSet = getIdToEmailSet(accounts);
//         List<List<String>> mergedAccounts = new ArrayList<>();
//         for (Integer id : idToEmailSet.keySet()) {
//             List<String> sortedEmails = new ArrayList(idToEmailSet.get(id));
//             Collections.sort(sortedEmails);
//             sortedEmails.add(0, accounts.get(id).get(0));
//             mergedAccounts.add(sortedEmails);
//         }
//         return mergedAccounts;
//     }
    
//     private Map<String, List> getEmailToIds (List<List<String>> accounts) { // 先把邮箱和编号对应
//         Map<String, List> emailToIds = new HashMap<>();
//         for (int user_id = 0; user_id < accounts.size(); user_id++) { // 先粗分: 每个账号对应一个编号 这个编号是arbitrary的
//             List<String> account = accounts.get(user_id); // 先把每一个subset分离出来
//             for (int i = 1; i < account.size(); i++) { // 遍历每个account里的邮箱 i.e. sub-subset
//                 List<Integer> ids = emailToIds.getOrDefault(account.get(i), new ArrayList<Integer>()); // account.get(i) 就是每一个account里的每一个邮箱
//                 ids.add(user_id); // 以邮箱为主 往里面加user_id(也可以说是每个账号的id) 这样能保证‘独特性’(exclusive)
//                 emailToIds.put(account.get(i), ids); // 把邮箱 和ids 对应起来 把邮箱作为key 因为邮箱具有独特性
//             }
//         }
//         return emailToIds;
//     }
    
//     private Map<Integer, Set<String>> getIdToEmailSet(List<List<String>> accounts) { // 反向 根据ids 输出邮箱
//         Map<Integer, Set<String>> idToEmailSet = new HashMap<>();
//         for (int user_id = 0; user_id < accounts.size(); user_id++) {
//             int root_id = find(user_id); // 
//             Set<String> emailSet = idToEmailSet.getOrDefault(root_id, new HashSet<String>()); //根据root_id 来分类emails
//             List<String> account = accounts.get(user_id);
//             for (int i = 1; i < account.size(); i++) {
//                 emailSet.add(account.get(i));
//             }
//             idToEmailSet.put(root_id, emailSet);
//         }
//         return idToEmailSet;
//     }
    
//     private int find(int id) {
//         List<Integer> path = new ArrayList<>();
//         while (father.containsKey(id)) {
//             path.add(id);
//             id = father.get(id);
//         }
//         for (Integer i : path) {
//             father.put(i, id);
//         }
//         return id;
//     }
    
//     private void union(int id1, int id2) {
//         int root1 = find(id1);
//         int root2 = find(id2);
//         if (root1 != root2) {
//             father.put(root1, root2);
//         }
//     }
// }