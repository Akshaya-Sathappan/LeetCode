class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int low = 0;
        for(int i : weights){
            sum += i;
            low = Math.max(low, i);
        }

        int high = sum;
        int result = 0;

        while(low <= high){
            int mid = (low + high)/2;
            boolean ans = ableToShip(weights, days, mid);

            if(ans){
                result = mid;
                high = mid - 1;
            }

            else{
                low = mid + 1;
            }
        }
        return result;
    }

    public boolean ableToShip(int[] weights, int days, int maxWeight){
        int noOfDays = 1;
        int weight = maxWeight;

        for(int j : weights){
            weight -= j;
            if(weight < 0){
                noOfDays++;
                weight = maxWeight - j;
            }
        }

        if(noOfDays <= days){
            return true;
        }

        return false;
    }
}