class Solution { // two pointers method
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        // sort based on starting time
        Arrays.sort(slots1, (a, b) -> (a[0] - b[0]));
        Arrays.sort(slots2, (a, b) -> (a[0] - b[0]));
        
        int pointer1 = 0;
        int pointer2 = 0;
        
        while (pointer1 < slots1.length && pointer2 < slots2.length) {
            // 这是找到共有时间的方法 如果left不取max right不取min 那我们找到的并不是exclusive intersection
            int intersectLeft = Math.max(slots1[pointer1][0], slots2[pointer2][0]);
            int intersectRight = Math.min(slots1[pointer1][1], slots2[pointer2][1]);
            if (intersectRight - intersectLeft >= duration) {
                return new ArrayList<Integer>(Arrays.asList(intersectLeft, intersectLeft + duration));
            }
            else { // 哪个slot先结束 就移动哪个slot的指针
                if (slots1[pointer1][1] < slots2[pointer2][1]) {
                    pointer1++;
                }
                else {
                    pointer2++;
                }
            }                                
        }
        return new ArrayList<Integer>();  
    }
}