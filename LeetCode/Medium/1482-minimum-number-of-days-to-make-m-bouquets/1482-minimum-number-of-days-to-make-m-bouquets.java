class Solution {

    public boolean canMakeBouquets(int[] days, int day, int m, int k){

        int count = 0;
        int noOfBouquets = 0;

        for(int i = 0; i < days.length; i++){
            if(days[i] <= day){
                count++;
            }
            else{
                noOfBouquets += count/k;
                count = 0;
            }
        }

        noOfBouquets += count/k;

        if(noOfBouquets >= m){
            return true;
        }

        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (long)m * k){
            return -1;
        }
        
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < bloomDay.length; i++){
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }

        int low = mini;
        int high = maxi;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(canMakeBouquets(bloomDay, mid, m, k)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}