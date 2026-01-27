class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder str = new StringBuilder();
        int increment = (numRows - 1) * 2;
        int length = s.length();
        
        for(int j = 0; j < numRows; j++){
            for(int i = j; i < length; i+=increment){
                str.append(s.charAt(i));
                if(j > 0 && j < numRows - 1){
                    int add = i + increment - (2 * j);
                    if(add < length){
                        str.append(s.charAt(add));
                    }
                }
            }
        }
        return str.toString();
    }
}