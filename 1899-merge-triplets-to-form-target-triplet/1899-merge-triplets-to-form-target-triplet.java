class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;

        for(int i = 0; i < triplets.length; i++){
            for(int j = 0; j < 3; j++){
                if(triplets[i][j] > target[j]){
                    break;
                }
                if(j == 2){
                    max1 = Math.max(max1, triplets[i][0]);
                    max2 = Math.max(max2, triplets[i][1]);
                    max3 = Math.max(max3, triplets[i][2]);

                    if(max1 == target[0] && max2 == target[1] && max3 == target[2]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}