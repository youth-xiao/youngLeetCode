class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int happyCustomers = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                happyCustomers += customers[i];
                customers[i] = 0;
            }
        }
        
        int maxHappyCustomers = 0;
        int currNumber = 0;
        for (int i = 0; i < customers.length; i++) {
            currNumber += customers[i];
            if (i >= minutes) {
                currNumber -= customers[i - minutes];
            }
            maxHappyCustomers = Math.max(currNumber, maxHappyCustomers);
        }
            
        return happyCustomers + maxHappyCustomers;
    }
}