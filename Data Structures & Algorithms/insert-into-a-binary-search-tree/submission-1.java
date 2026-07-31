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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }

        TreeNode node = dfs(root, val);
        
        return root;
    }

    private TreeNode dfs(TreeNode node, int val) {
        if(node == null) {
            return new TreeNode();
        }
        if(node.val < val) {
            if(node.right == null) {
                node.right = new TreeNode(val);
                return node.right;
            }
            dfs(node.right, val);
        }
        if(node.val > val) {
            if(node.left == null) {
                node.left = new TreeNode(val);
                return node.left;
            }
            dfs(node.left, val);
        }
        return new TreeNode();
    }
}