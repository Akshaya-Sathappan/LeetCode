class Solution {
    public boolean checkIfExist(int[] arr) {
        int size = arr.length;
        for( int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                if(arr[i] == 2 * arr[j] && i != j){
                    return true;
                }
            }
        }
        return false;
    }
}