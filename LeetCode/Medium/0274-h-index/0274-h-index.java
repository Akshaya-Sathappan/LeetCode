class Solution {
    public int hIndex(int[] citations) {
        int[] noOfPapers = new int[citations.length + 1];
        int n = citations.length;

        for(int c : citations){
            if(c >= n){
                noOfPapers[n]++;
            }
            else{
                noOfPapers[c]++;
            }
        }

        int total = 0;

        for(int i = n; i >= 0; i--){
            total += noOfPapers[i];
            if(total >= i){
                return i;
            }
        }
        return 0;
    }
}