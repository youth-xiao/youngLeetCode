class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                int absDiff = Math.abs(arr[i] - arr[i + 1]);
                if (absDiff <= min) {
                    if (absDiff < min) {
                        res.clear();
                        min = absDiff;
                    }
                    res.add(new ArrayList<>(List.of(arr[i], arr[i + 1])));
                }
            } else if (i == arr.length - 1) {
                int absDiff = Math.abs(arr[i] - arr[i - 1]);
                if (absDiff <= min) {
                    if (absDiff < min) {
                        res.clear();
                        min = absDiff;
                    }
                    res.add(new ArrayList<>(List.of(arr[i - 1], arr[i])));
                }
            } else {
                int flag = 0;
                int ad1 = Math.abs(arr[i] - arr[i - 1]);
                int ad2 = Math.abs(arr[i] - arr[i + 1]);
                if (ad1 < ad2) flag = 1;
                else if (ad1 > ad2) flag = 2;
                else flag = 3;
                
                if (flag == 1) {
                    if (ad1 <= min) {
                        if (ad1 < min) {
                            res.clear();
                            min = ad1;
                        }
                        res.add(new ArrayList<>(List.of(arr[i - 1], arr[i])));
                    }
                } else if (flag == 2) {
                    if (ad2 <= min) {
                        if (ad2 < min) {
                            res.clear();
                            min = ad2;
                        }
                        res.add(new ArrayList<>(List.of(arr[i], arr[i + 1])));
                    }
                } else if (flag == 3) {
                    if (ad1 <= min) {
                        if (ad1 < min) {
                            res.clear();
                            min = ad1;
                        }
                        res.add(new ArrayList<>(List.of(arr[i - 1], arr[i])));
                        res.add(new ArrayList<>(List.of(arr[i], arr[i + 1])));
                    }
                }
            }
        }
        
        List<List<Integer>> cleanList = res.stream().distinct().collect(Collectors.toList());
        
        return cleanList;
    }
}