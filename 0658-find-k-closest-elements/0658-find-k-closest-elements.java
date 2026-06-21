class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int a : arr){
            if(pq.size() < k){
                pq.offer(a);
            }

            else{
                int i = pq.peek();
                if(Math.abs(a - x) < Math.abs(i - x)){
                    pq.poll();
                    pq.offer(a);
                }
                else if(Math.abs(a - x) == Math.abs(i - x)  && a < i){
                    pq.poll();
                    pq.offer(a);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        
        return list;
    }
}