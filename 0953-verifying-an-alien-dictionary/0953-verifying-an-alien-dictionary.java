class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];

        for(int i = 0; i < order.length(); i++){
            rank[order.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i];
            String w2 = words[i + 1];

            int len = Math.min(w1.length(), w2.length());

            for(int j = 0; j < len; j++){
                int r1 = rank[w1.charAt(j) - 'a'];
                int r2 = rank[w2.charAt(j) - 'a'];

                if(r1 < r2){
                    break;
                }
                else if (r1 > r2){
                    return false;
                }
                else if(j == len - 1 && w1.length() > w2.length()){
                    return false;
                }
                else{
                    continue;
                }
            }
        }
        return true;
    }
}