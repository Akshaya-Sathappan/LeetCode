class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        /* HashMap<Character,Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char ch : ransomNote.toCharArray()){
            if(map.containsKey(ch)){
                if(map.get(ch)==0){
                    return false;
                }
                map.put(ch, map.get(ch)-1);
            }
            else if(!map.containsKey(ch)){
                return false;
            }
        }
        return true; */

        int[] count = new int[26];
        for(char ch : magazine.toCharArray()){
            count[ch - 'a']++;
        }
        for(char ch : ransomNote.toCharArray()){
            count[ch - 'a']--;
        }
        for(int i=0; i<26; i++){
            if(count[i] < 0){
                return false;
            }
        }
        return true;
    }
}