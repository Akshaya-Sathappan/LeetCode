class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        int i = 0;

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int key : map.keySet()){
            if(pq.size() < k){
                pq.add(key);
            }
            else{
                if(map.get(pq.peek()) < map.get(key)){
                    pq.poll();
                    pq.add(key);
                }
            }
        }

        while(!pq.isEmpty()){
            result[i++] = pq.poll();
        }

        return result;
    }
}