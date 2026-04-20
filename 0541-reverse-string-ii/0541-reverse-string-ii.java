class Solution {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for(int i = 0; i < s.length(); i += 2 * k){
            int start = i;
            int end = Math.min(i + k - 1, s.length() - 1);
            while(start < end){
                char temp = a[start];
                a[start++] = a[end];
                a[end--] = temp;
            }
        }
        return new String(a);
    }
}