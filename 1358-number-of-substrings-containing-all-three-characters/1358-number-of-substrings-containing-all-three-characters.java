class Solution {
    public int numberOfSubstrings(String s) {
        return atMost(s, 3) - atMost(s, 2);
    }

    public int atMost(String s, int k){
        int left = 0;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while(map.size() > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}