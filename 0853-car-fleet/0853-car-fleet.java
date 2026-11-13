class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];

        for(int i = 0; i < position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        int fleet = 0;
        double fleetTime = 0;

        for(int[] car : cars){
            double time = (double) (target - car[0])/ (double) car[1];

            if(time > fleetTime){
                fleet++;
                fleetTime = time;
            }
        }

        return fleet;
    }
}
