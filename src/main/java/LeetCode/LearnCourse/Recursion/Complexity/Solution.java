package LeetCode.LearnCourse.Recursion.Complexity;

/**
 * @author choijaeyong on 14/03/2019.
 * @project Algorithm
 * @description
 */

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}


public class Solution {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    TreeNode node1 = new TreeNode(9);
    TreeNode node2 = new TreeNode(20);
    TreeNode node3 = new TreeNode(15);
    TreeNode node4 = new TreeNode(7);

    root.left = node1;
    root.right = node2;

    node1.left = null;
    node1.right = null;

    node2.left = node3;
    node2.right = node4;

    Solution solution = new Solution();
    System.out.println(solution.maxDepth(root));


  }

  public int maxDepth(TreeNode root) {
    int depth = 0;
    int result = maxDepth(root,depth);
    return result;
  }

  public int maxDepth(TreeNode root, int depth) {
    if(root == null) {
      return depth;
    }
    depth = depth + 1;
    return Math.max(maxDepth(root.left , depth) , maxDepth(root.right, depth));
  }

}


