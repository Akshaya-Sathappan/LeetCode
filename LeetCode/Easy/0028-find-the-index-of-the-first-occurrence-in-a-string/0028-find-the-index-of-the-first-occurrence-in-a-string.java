class Solution {
    public int strStr(String haystack, String needle) {
        int size_n = needle.length();
        int size_h = haystack.length();

        int i = 0;
        for ( i = 0; i <= size_h - size_n; i++){
            if(haystack.substring(i, i+size_n).equals(needle)) return i;
        }
        return -1;
    }
}