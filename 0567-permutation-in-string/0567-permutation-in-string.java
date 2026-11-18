class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        if(s2.length() < s1.length()){
            return false;
        }

        int m = s1.length();
        int n = s2.length();

        for(int i = 0; i < m; i++){
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(arr1, arr2)){
            return true;
        }

        for(int j = m; j < n; j++){
            arr2[s2.charAt(j - m) - 'a']--;
            arr2[s2.charAt(j) - 'a']++;

            if(Arrays.equals(arr1, arr2)){
                return true;
            }
        }
        return false;
    }
}
