class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxLength = 0;
        int[] arr = new int[26];
        int maxCharLength = 0;

        for(int right = 0; right < s.length(); right++){
            int i = s.charAt(right) - 'A';
            arr[i]++;

            while((right - left + 1) - getMax(arr) > k){
                int j = s.charAt(left) - 'A';
                arr[j]--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    private int getMax(int[] arr){
        int maxChar = 0;
        for(int a : arr){
            maxChar = Math.max(maxChar, a);
        }
        return maxChar;
    }
}