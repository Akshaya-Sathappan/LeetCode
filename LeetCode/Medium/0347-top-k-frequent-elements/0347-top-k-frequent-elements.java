class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int n : map.keySet()){
            pq.add(n);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] arr = new int[pq.size()];
        int i = pq.size() - 1;
        while(!pq.isEmpty()){
            arr[i--] = pq.poll();
        }

        return arr;
    }
}
