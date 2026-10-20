class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((d, e) -> e[1] - d[1]);

        if(a > 0){
            pq.offer(new int[] {0, a});
        } 
        if(b > 0){
            pq.offer(new int[] {1, b});
        } 
        if(c > 0){
            pq.offer(new int[] {2, c});
        } 

        StringBuffer result = new StringBuffer();

        while(!pq.isEmpty()){
            int[] first = pq.poll();
            char ch = (char) (first[0] + 'a');

            int n = result.length();

            if(n >= 2 && result.charAt(n - 1) == ch && result.charAt(n - 2) == ch){
                if(pq.isEmpty()){
                    break;
                }
                int[] second = pq.poll();
                char cr = (char) (second[0] + 'a');
                int freq = second[1] - 1;
                result.append(cr);
                if(freq > 0)
                    pq.offer(new int[] {second[0], freq});
                pq.offer(first);
            }

            else{
                result.append(ch);
                int freq = first[1] - 1;
                if(freq > 0)
                    pq.offer(new int[] {first[0], freq});
            }
        }

        return result.toString();
    }
}