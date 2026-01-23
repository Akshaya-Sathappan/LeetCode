class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        for(int key : map.keySet()){
            if(pq.size() < k){
                pq.offer(new int[]{key, map.get(key)});
            }
            else if(pq.peek()[1] < map.get(key)){
                pq.poll();
                pq.offer(new int[]{key, map.get(key)});
            }
        }
        int[] result = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            result[i++] = pq.poll()[0];
        }
        return result;
    }
}