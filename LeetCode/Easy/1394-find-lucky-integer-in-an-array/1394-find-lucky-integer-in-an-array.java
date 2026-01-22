class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for ( int a : arr){
            map.put(a, map.getOrDefault(a,0)+1);
        }

        int max = -1;
        int result = 0;
        for( int i : map.keySet()){
            if(map.get(i) == i){
                max = i;
            }
        }
        return max;
    }
}