class Solution {
    public String removeDuplicates(String s) {
        StringBuilder str = new StringBuilder();
        int sbLength = 0;
        for(int i = 0; i < s.length(); i++){
            if(sbLength != 0 && s.charAt(i) == str.charAt(sbLength - 1)){
                str.deleteCharAt(sbLength - 1);
                sbLength--;
            }
            else{
                str.append(s.charAt(i));
                sbLength++;
            }
        }
        return str.toString();
    }
}