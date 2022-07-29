class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        Set<String> available = Stream.of(supplies).collect(Collectors.toCollection(HashSet::new));
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, Set<String>> ingredientToRecipe = new HashMap<>();
        
        for (int i = 0; i < recipes.length; i++) {
            int unavailable = 0;
            for (String ingredient : ingredients.get(i)) {
                if (!available.contains(ingredient)) {
                    ingredientToRecipe.computeIfAbsent(ingredient, s -> new HashSet<>()).add(recipes[i]);
                    unavailable++;
                }
            }
            if (unavailable == 0) {
                ans.add(recipes[i]);
            } else {
                indegree.put(recipes[i], unavailable);
            }
        }
        
        for (int i = 0; i < ans.size(); i++) {
            String recipe = ans.get(i);
            if (ingredientToRecipe.containsKey(recipe)) {
                for (String r : ingredientToRecipe.remove(recipe)) {
                    if (indegree.merge(r, -1, Integer::sum) == 0) {
                        ans.add(r);
                    }
                }
            }
        }
        return ans;
    }
}


// class Solution {
//     public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
//         int n = recipes.length;
//         Set<String> canBeMade = new HashSet<>();
//         List<String> res = new ArrayList<>();
//         for (String su : supplies) canBeMade.add(su);
//         for (int i = 0; i < n; i++) {
//             String recipe = recipes[i];
//             List<String> ingredient = ingredients.get(i);
//             boolean all = true;
//             for (String in : ingredient) {
//                 if (!canBeMade.contains(in)) {
//                     all = false;
//                     break;
//                 }
//             }
//             if (all) {
//                 res.add(recipe);
//                 canBeMade.add(recipe);
//             }
//         }
//         return res;
//     }
// }