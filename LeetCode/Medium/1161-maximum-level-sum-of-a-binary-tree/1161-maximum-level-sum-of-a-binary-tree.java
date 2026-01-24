/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer, Long> map = new HashMap<>();

    public int maxLevelSum(TreeNode root) {
        traversal(root, 1);
        long maxi = Long.MIN_VALUE;
        int level = 0;
        for(int i = 1; i <= map.size(); i++){
            if(maxi < map.get(i)){
                maxi = map.get(i);
                level = i;
            }
        }
        return level;
    }

    public void traversal(TreeNode node, int level){
        if(node == null){
            return;
        }
        map.put(level, map.getOrDefault(level, 0L) + node.val);

        traversal(node.right, level + 1);
        traversal(node.left, level + 1);
    }
}