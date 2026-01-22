class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int min = Integer.MAX_VALUE;
        char ch = letters[0];
        for(char c : letters){
            int result = c - target;
            if(result > 0){
                if(result < min){
                    min = result;
                    ch = c;
                }
            }
        }
        return ch;
    }
}