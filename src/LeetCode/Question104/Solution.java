package LeetCode.Question104;

/**
 * @author choijaeyong on 12/04/2019.
 * @project Algorithm
 * @description
 */
public class Solution {
  public static void main(String[] args) {
    // 3,9,20,null,null,15,7
    TreeNode root = new TreeNode(3);
    TreeNode node1 = new TreeNode(9);
    TreeNode node2 = new TreeNode(20);
    TreeNode node3 = new TreeNode(15);
    TreeNode node4 = new TreeNode(7);

    root.left = node1;
    root.right = node2;
    node2.left = node3;
    node2.right = node4;

    System.out.println(maxDepth(root));

  }

  public static int maxDepth(TreeNode root) {

    int depth = 0;
    depth = dfs(root,depth);
    return depth;
  }

  public static int dfs(TreeNode node,int depth) {
    if(node == null) {
      return depth;
    }

    depth = depth + 1;
    return Math.max(dfs(node.left, depth) , dfs(node.right, depth));


  }

}



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
