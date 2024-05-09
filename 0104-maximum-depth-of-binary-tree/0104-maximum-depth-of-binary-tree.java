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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<Integer> depth = new LinkedList<>();
        depth.offer(1);
        
        int answer = 0;
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int currentDepth = depth.poll();
            
            answer = Math.max(answer, currentDepth);
            
            if(node.left != null){
                queue.offer(node.left);
                depth.offer(currentDepth + 1);
            }
            
            if(node.right != null){
                queue.offer(node.right);
                depth.offer(currentDepth + 1);
            }
        }
        return answer;
    }
}