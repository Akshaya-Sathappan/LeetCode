class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[] freq = new int[26];
        Queue<int[]> q = new LinkedList<>();
        int count = 0;

        for(char c : tasks){
            int character = (int) c;
            freq[character - 'A']++;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                pq.offer(new int[] {i, freq[i]});
            }
        }

        while(!pq.isEmpty() || !q.isEmpty()){
            if(!pq.isEmpty()){
                int[] arr = pq.poll();
                count++;
                int remaining = arr[1] - 1;
                if(remaining > 0){
                    q.add(new int[] {arr[0], remaining, count + n});
                }
            }
            else{
                count++;
            }

            if (!q.isEmpty() && q.peek()[2] <= count) {
                int[] i = q.poll();
                pq.add(new int[]{i[0], i[1]});
            }
        }

        return count;
    }
}