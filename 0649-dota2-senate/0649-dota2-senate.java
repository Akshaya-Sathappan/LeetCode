class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new ArrayDeque<>();
        Queue<Integer> dire = new ArrayDeque<>();

        int n = senate.length();

        for(int i = 0; i < n; i++){
            if(senate.charAt(i) == 'R'){
                radiant.offer(i);
            }
            else{
                dire.offer(i);
            }
        }

        while(!radiant.isEmpty() && !dire.isEmpty()){
            int i = radiant.poll();
            int j = dire.poll();

            if(i < j){
                radiant.offer(i + n);
            }
            else{
                dire.offer(j + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}