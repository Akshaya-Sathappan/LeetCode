class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int size = operations.length;
        int x = 0;
        for(int i = 0; i<size; i++){
            String str = operations[i];
            if(str.equals("--X") || str.equals("X--")){
                x -= 1;
            }
            else if(str.equals("++X") || str.equals("X++")){
                x += 1;
            }
        }
        return x;
    }
}