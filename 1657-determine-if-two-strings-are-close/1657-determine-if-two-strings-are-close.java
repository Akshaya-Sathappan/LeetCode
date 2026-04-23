class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i = 0; i < word1.length(); i++){
            freq1[word1.charAt(i) - 'a']++;
        }

        for(int j = 0; j < word2.length(); j++){
            freq2[word2.charAt(j) - 'a']++;
        }

        for(int k = 0; k < 26; k++){
            if((freq1[k] > 0 && freq2[k] == 0) || (freq1[k] == 0 && freq2[k] > 0)){
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for(int l = 0; l < 26; l++){
            if(freq1[l] != freq2[l]){
                return false;
            }
        }
        return true;
    }
}