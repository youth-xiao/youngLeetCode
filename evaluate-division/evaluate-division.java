class Solution {
    public double[] calcEquation(List<List<String>> equations, 
                                 double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String numerator = equation.get(0);
            String dominator = equation.get(1);
            double quotient = values[i];
            graph.putIfAbsent(numerator, new HashMap<String, Double>());
            graph.putIfAbsent(dominator, new HashMap<String, Double>());
            graph.get(numerator).put(dominator, quotient);
            graph.get(dominator).put(numerator, 1/quotient);
        }
        
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String numerator = query.get(0);
            String dominator = query.get(1);
            if (!graph.containsKey(numerator) || !graph.containsKey(dominator)) {
                results[i] = -1.0;
            } else if (numerator == dominator) {
                results[i] = 1.0;
            } else {
                HashSet<String> visited = new HashSet<>();
                results[i] = backtrackEvaluate(graph, numerator, dominator, 1, visited);
            }
        }
        return results;
    }
    
    private double backtrackEvaluate(HashMap<String, HashMap<String, Double>> graph, String currNode, String targetNode, double accumuProduct, Set<String> visited) {
        visited.add(currNode);
        double ans = -1.0; // default answer if no valid nodes are found
        Map<String, Double> neighbors = graph.get(currNode);
        if (neighbors.containsKey(targetNode)) {
            ans = accumuProduct * neighbors.get(targetNode);
        } else {
            for (Map.Entry<String, Double> pair : neighbors.entrySet()) {
                String nextNode = pair.getKey();
                if (visited.contains(nextNode)) {
                    continue;
                }
                ans = backtrackEvaluate(graph, nextNode, targetNode,
                                       accumuProduct * pair.getValue(), visited);
                if (ans != -1.0) {
                    break;
                }
            }
        }
        visited.remove(currNode);
        return ans;
    }
}



// class Solution {
//     public double[] calcEquation(List<List<String>> equations, 
//                                  double[] values, List<List<String>> queries) {
//         Set<String> varSet = new HashSet<>();
//         Map<List<String>, Double> divMap = new HashMap<>();
//         List<Double> results = new ArrayList<>();
        
//         for (int i = 0; i < equations.size(); i++) {
//             List<String> eq = equations.get(i);
//             varSet.add(eq.get(0));
//             varSet.add(eq.get(1));
//             double val = values[i];
//             divMap.put(eq, val);
//         }
        
//         for (int i = 0; i < queries.size(); i++) {
//             List<String> query = queries.get(i);
//             String numerator = query.get(0);
//             String dominator = query.get(1);
//             if (!varSet.contains(numerator) || !varSet.contains(dominator)) {
//                 results.add(-1.0);
//             } else if (numerator == dominator) {
//                 results.add(1.0);
//             } else {
//                 int numeratorPos = -1;
//                 int dominatorPos = -1;
//                 double numeratorVal = -1.0;
//                 double dominatorVal = -1.0;
//                 for (Map.Entry<List<String>, Double> e : divMap.entrySet()) {
//                     List<String> eq = e.getKey();
//                     if (eq.contains(numerator) && eq.contains(dominator)) {
//                         if (eq.get(0) == numerator && eq.get(1) == dominator) {
//                             results.add(e.getValue());
//                         } else {
//                             results.add(1.0/e.getValue());
//                         }
//                     } else if (eq.contains(numerator) || eq.contains(dominator)) {
//                         if (eq.get(0) == numerator) {
//                             numeratorPos = 0;
//                             numeratorVal = e.getValue();
//                         } else {
//                             numeratorPos = 1;
//                             numeratorVal = e.getValue();
//                         }
//                         if (eq.get(1) == dominator) {
//                             dominatorPos = 1;
//                             dominatorVal = e.getValue();
//                         } else {
//                             dominatorPos = 0;
//                             dominatorVal = e.getValue();
//                         }
//                     }
//                 }
//                 if (numeratorPos == 0 && dominatorPos == 1) {
//                     results.add(numeratorVal * dominatorVal);
//                 }
//             }
//         }
//         double[] ans = new double[results.size()];
//         for (int i = 0; i < ans.length; i++) {
//             ans[i] = results.get(i);
//         }
//         return ans;
//     }
// }