class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(int j=0; j<t.length(); j++){
            char ch = t.charAt(j);
            if(map.containsKey(ch) && map.get(ch)!=0){
                map.put(ch, map.get(ch)-1);
            }
            else{
                count++;
            }
        }
        return count;    
    }
}