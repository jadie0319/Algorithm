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


