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
    int longest = 0;
    public int dfs(TreeNode root){
        if(root == null)
            return -1;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        
        if(root.left == null || root.val != root.left.val){
            left = -1;
        }
    
        if(root.right == null || root.val != root.right.val){
            right = -1;
        }
        
        longest = Math.max(longest, left+right+2);
        
        return Math.max(left, right) + 1;
    }
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return longest;
    }
}