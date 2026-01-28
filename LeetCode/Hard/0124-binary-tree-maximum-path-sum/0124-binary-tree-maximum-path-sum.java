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
    int maxi;

    public int maxPathSum(TreeNode root){
        maxi = Integer.MIN_VALUE;
        maxSum(root);
        return maxi;
    } 

    public int maxSum(TreeNode node) {
        if(node == null){
            return 0;
        }

        int leftSubtree = Math.max(maxSum(node.left), 0);
        int rightSubtree = Math.max(maxSum(node.right), 0);

        maxi = Math.max(maxi, node.val + leftSubtree + rightSubtree);

        return node.val + Math.max(leftSubtree, rightSubtree);
        
    }
}