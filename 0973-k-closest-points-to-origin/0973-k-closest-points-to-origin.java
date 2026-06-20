class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(int i = 0; i < points.length; i++){
            if(pq.size() < k){
                pq.offer(new int[] {i, squareDistance(points[i])});
            }

            else{
                if(pq.peek()[1] > squareDistance(points[i])){
                    pq.poll();
                    pq.offer(new int[] {i, squareDistance(points[i])});
                }
            }
        }

        int[][] result = new int[k][2];
        int j = 0;

        while(!pq.isEmpty()){
            int index = pq.poll()[0];
            result[j++] = points[index];
        }

        return result;
    }

    public int squareDistance(int[] i){
        return i[0] * i [0] + i[1] * i[1];
    }
}