class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentGas = 0;
        int startIndex = 0;
        int totalGas = 0;
        int totalCost = 0;

        for(int j = 0; j < gas.length; j++){
            totalGas += gas[j];
            totalCost += cost[j];
        }

        if(totalGas < totalCost){
            return -1;
        }

        for(int i = 0; i < gas.length; i++){
            currentGas += gas[i] - cost[i];

            if(currentGas < 0){
                startIndex = i + 1;
                currentGas = 0;
            }
        }
        return startIndex;
    }
}