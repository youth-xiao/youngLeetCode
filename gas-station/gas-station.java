class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_gas = 0;
        int curr_gas = 0;
        int start_station = 0;
        for (int i = 0; i < n; i++) {
            total_gas += gas[i] - cost[i];
            curr_gas += gas[i] - cost[i];
            if (curr_gas < 0) {
                start_station = i + 1;
                curr_gas = 0;
            }
        }
        return total_gas >= 0 ? start_station : -1;
    }
}