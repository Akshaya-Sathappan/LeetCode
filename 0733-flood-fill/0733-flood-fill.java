class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int nRows = image.length;
        int nColumns = image[0].length;
        int orgColor = image[sr][sc];

        if(orgColor == color){
            return image;
        }

        helper(image, sr, sc, orgColor, color);

        return image;
    }

    public void helper(int[][] image, int sr, int sc, int orgColor, int color){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != orgColor){
            return;
        }

        image[sr][sc] = color;

        helper(image, sr + 1, sc, orgColor, color);
        helper(image, sr - 1, sc, orgColor, color);
        helper(image, sr, sc + 1, orgColor, color);
        helper(image, sr, sc - 1, orgColor, color);
    }
}