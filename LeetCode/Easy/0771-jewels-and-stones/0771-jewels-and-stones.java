class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        int size = stones.length();
        int result = 0;
        for( int i = 0; i<size; i++){
            char j = stones.charAt(i);
            if(jewels.contains(String.valueOf(j))){
                result++ ;
            }
        }
        return result;

      /*  char[] c = stones.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for( char ch : c){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int size = jewels.length();
        int sum = 0;
        for( int i = 0; i<size; i++){
            char j = jewels.charAt(i);
            if(stones.contains(String.valueOf(j))){
                sum += map.get(j);
            }
        }
        return sum;  */
    }
}