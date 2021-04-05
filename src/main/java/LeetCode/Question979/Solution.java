package LeetCode.Question979;

/**
 * @author choijaeyong on 12/04/2019.
 * @project Algorithm
 * @description
 */
public class Solution {

  int count;

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode node1 = new TreeNode(0);
    TreeNode node2 = new TreeNode(0);
    TreeNode node3 = new TreeNode(3);


    root.left = node1;
    root.right = node2;
    node1.right = node3;

    Solution solution = new Solution();

    System.out.println(solution.distributeCoins(root));

  }

  public int distributeCoins(TreeNode root) {
    count=0;
    dfs(root);
    return count;
  }

  public int dfs(TreeNode node) {
    if(node == null) {
      return 0;
    }

    int L = dfs(node.left);
    int R = dfs(node.right);
    count += Math.abs(L) + Math.abs(R);
    return node.val + L + R - 1;

  }

}


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}