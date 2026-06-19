class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if(k > s.length()) return 0;

        int left = 0;
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for(int right = 0; right < s.length(); right++){
            while(set.contains(s.charAt(right)) || right - left + 1 > k){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            if((right - left + 1) == k){
                count++;
            }
        }
        return count;
    }
}