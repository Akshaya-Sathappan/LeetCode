class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] countS = new int[26];
        int[] countP = new int[26];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < p.length(); i++){
            countP[(int) (p.charAt(i) - 'a')]++;
        } 

        for(int j = 0; j < s.length(); j++){
            countS[(int) (s.charAt(j) - 'a')]++;
            if(j >= p.length()){
                countS[(int) (s.charAt(j - p.length()) - 'a')]--;
            }

            if(Arrays.equals(countP,countS)){
                list.add(j - p.length() + 1);
            }
        }
        return list;
    }
}