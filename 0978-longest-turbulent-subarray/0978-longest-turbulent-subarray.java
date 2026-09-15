class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int sign = -1;
        int count = 0;
        int maxSize = 0;

        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] < arr[i + 1]){
                count = (sign == 1) ? count + 1 : 1;
                sign = 0;
            }
            else if(arr[i] > arr[i + 1]){
                count = (sign == 0) ? count + 1 : 1;
                sign = 1;
            }
            else{
                sign = -1;
            }
            maxSize = Math.max(count, maxSize);
        }
        return maxSize + 1;
    }
}