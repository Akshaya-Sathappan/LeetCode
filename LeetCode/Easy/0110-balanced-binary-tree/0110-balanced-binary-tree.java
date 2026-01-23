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
    public boolean isBalanced(TreeNode root) {
        int i = height(root);
        if(i == -1) return false;
        return true;
    }

    private int height(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        if(left == -1){
            return -1;
        }
        else if(right == -1){
            return -1;
        }
        else if(Math.abs(left - right) > 1){
            return -1;
        }

        return 1 + Math.max(left, right);
    }
}