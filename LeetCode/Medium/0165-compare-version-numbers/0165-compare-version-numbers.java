class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int len1 = ver1.length;
        int len2 = ver2.length;

        for(int i = 0; i < Math.max(len1, len2); i++){
            int v1 = i < len1 ? Integer.parseInt(ver1[i]) : 0;
            int v2 = i < len2 ? Integer.parseInt(ver2[i]) : 0;
            if(v1 < v2) return -1;
            if(v1 > v2) return 1;
        }
        return 0;
    }
}