class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();
        int[] prev = null;

        while(!pq.isEmpty()){
            int[] current = pq.poll();

            result.append((char) (current[0] + 'a'));
            current[1]--;

            if(prev != null){
                if(prev[1] > 0){
                    pq.offer(prev);
                }
            }

            prev = current;
        }

        return s.length() == result.length() ? result.toString() : "";
    }
}