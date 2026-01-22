class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int result = 0;
        for(int cookie = 0; cookie < s.length; cookie++){
            if(child < g.length && s[cookie] >= g[child] ){
                child++;
                result++;
            }
        }
        return result;
    }
}