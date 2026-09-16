class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int count = 0;
        int sign = -1;
        int maxSize = 0;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i - 1]){
                count = (sign == 0) ? count + 1 : 1;
                sign = 1;
            }
            else if(arr[i] > arr[i - 1]){
                count = (sign == 1) ? count + 1 : 1;
                sign = 0;
            }
            else{
                sign = -1;
            }

            maxSize = Math.max(maxSize, count);
        }

        return maxSize + 1;
    }
}