class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuffer ans = new StringBuffer();

        while(columnNumber > 0){
            columnNumber--;
            ans.append((char) ((columnNumber % 26) + 'A'));
            columnNumber /= 26;
        }
        return ans.reverse().toString();
    }
}